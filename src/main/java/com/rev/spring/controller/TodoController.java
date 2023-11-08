package com.rev.spring.controller;

import com.rev.spring.model.Book;
import com.rev.spring.model.Todo;
import com.rev.spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @GetMapping("todo/all")
    public List<Todo> getAllTodos(){
        return todoRepository.findAllTodo();
    }
    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable int id){
        return todoRepository.findTodoById(id);
    }

    @PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
        return todoRepository.insertTodo( todo);
    }
    @PutMapping("/todo")
    public List<Todo> updateBook(@RequestBody Todo todo){
        return todoRepository.updateTodo(todo);
    }

    @DeleteMapping("/todo/{id}")
    public List<Todo> deleteBook(@PathVariable int id){
        return todoRepository.deleteTodoById(id);
    }

}
