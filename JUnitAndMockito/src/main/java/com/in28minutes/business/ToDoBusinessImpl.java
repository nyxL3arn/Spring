package com.in28minutes.business;

import java.util.ArrayList;
import java.util.List;

import com.in28minutes.data.api.ToDoService;

//ToDoBusinessImpl ist das SUT: das System Under Test
//ToDoService ist eine Dependency. Wir wissen nicht, wie der Code ist und 
//wie genau die retrieveTodo-Methode funktioniert. Wir bekommen aber davon 
//die ToDo-Liste, die wir weiterverwenden.
//Um unser SUT zu testen, müssen wir die externe ToDoService mocken

public class ToDoBusinessImpl {

	private ToDoService todoService;


	public ToDoBusinessImpl(ToDoService todoService) {
		super();
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
