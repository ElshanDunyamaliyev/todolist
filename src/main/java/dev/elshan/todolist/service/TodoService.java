package dev.elshan.todolist.service;

import dev.elshan.todolist.model.Todo;

import java.util.List;

public interface TodoService {

    Todo getTodoById(Long id);
    List<Todo> getAllTodos();
    void addTodo(Todo todo);
    void updateTodo(Long id, Todo todo);
    void deleteTodo(Long id);
}
