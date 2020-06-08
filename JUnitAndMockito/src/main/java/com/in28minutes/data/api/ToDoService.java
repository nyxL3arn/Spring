package com.in28minutes.data.api;

import java.util.List;

public interface ToDoService {
public List<String> retrieveTodos(String user);

public void deleteTodo(String todo);
}
