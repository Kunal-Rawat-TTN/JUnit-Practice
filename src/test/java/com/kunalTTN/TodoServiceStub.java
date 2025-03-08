package com.kunalTTN;

import com.kunalTTN.service.TodoService;

import java.util.List;

public class TodoServiceStub implements TodoService {

    @Override
    public List<String> retrieveTodos(String user) {
        return List.of("List of Spring", "Learn Spring", "Bootcamp");
    }

    @Override
    public void deleteTodo(String Todo) {
    }
}
