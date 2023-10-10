package com.mutipolar.bootcamp.kyc.service;

import com.mutipolar.bootcamp.kyc.domain.Todo;
import com.mutipolar.bootcamp.kyc.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //    fungsi untuk get all todos
    public List<Todo> getAllTodos(){ // untuk mendapatkan data dari repository
        return todoRepository.findAll();
    }

    //    fungsi untuk get todo by id
    public Optional<Todo> getTodoById(String id){
        return todoRepository.findById(id);
    }

    //    fungsi untuk create or update todo
    public Todo createOrUpdateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    //    fungsi untuk menghapus todo
    public void deleteTodoById(String id){
        todoRepository.deleteById(id);
    }
}
