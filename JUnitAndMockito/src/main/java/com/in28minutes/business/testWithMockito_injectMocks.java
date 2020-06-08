package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.ToDoService;


public class testWithMockito_injectMocks extends ToDoBusinessImpl {

	private ToDoService todoService;



	public testWithMockito_injectMocks(ToDoService todoService) {
		super(todoService);
		this.todoService = todoService;
	}


	public List<String> retrieveTodosRelatedToSpring(String user){
		List<String> filteredTodos = new ArrayList<String>();
		List<String> todos =  todoService.retrieveTodos(user);

		for(String todo : todos) {
			if (todo.contains("Spring"))
			{
				filteredTodos.add(todo);
			}
		}

		return filteredTodos;
	}


	public void deleteTodosNotRelatedToSpring(String user){

		List<String> todos =  todoService.retrieveTodos(user);

		for(String todo : todos) {
			if (!todo.contains("Spring"))
			{
				todoService.deleteTodo(todo);
			}
		}

	}
}



