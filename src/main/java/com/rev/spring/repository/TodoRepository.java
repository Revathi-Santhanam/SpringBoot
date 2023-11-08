package com.rev.spring.repository;

import com.rev.spring.model.Book;
import com.rev.spring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TodoRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Todo> findAllTodo(){
        return  jdbcTemplate.query("SELECT * FROM todo;"
                ,new BeanPropertyRowMapper<>(Todo.class));
    }

    public Todo findTodoById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id=?;",
                new Object[]{id},new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insertTodo(Todo todo){
        jdbcTemplate.update("INSERT INTO todo(task) VALUES (?);",
                new Object[]{todo.getTask()});
        return findAllTodo() ;
    }
    public List<Todo> updateTodo(Todo todo){
        jdbcTemplate.update("UPDATE todo SET task=? WHERE id=?;",
                new Object[]{todo.getTask(),todo.getId()});
        return findAllTodo() ;
    }
    public List<Todo> deleteTodoById(int id){
        jdbcTemplate.update("DELETE FROM todo WHERE id=?;",
                new Object[]{id});
        return findAllTodo() ;
    }


}
