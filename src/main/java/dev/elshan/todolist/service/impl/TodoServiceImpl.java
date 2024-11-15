package dev.elshan.todolist.service.impl;

import dev.elshan.todolist.model.Todo;
import dev.elshan.todolist.repository.TodoRepository;
import dev.elshan.todolist.service.TodoService;
import jakarta.persistence.PreUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository repository;

    @Override
    public Todo getTodoById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"No todo found with given id"));
    }

    @Override
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @Override
    public void addTodo(Todo todo) {
        repository.save(todo);
    }

    @Override
    public void updateTodo(Long todoId, Todo todo) {
        var oldTodo = getTodoById(todoId);
        oldTodo.setContent(todo.getContent());
        oldTodo.setIsDone(todo.getIsDone());
        repository.save(oldTodo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        repository.deleteById(todoId);
    }
}
