package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService {

	public List<String> retrieveTodos(String user) {
		//jetzt machen wir den stub:
		return Arrays.asList("Learn Spring Boot","Learn Testing", "Learn Spring");
	}

	public void deleteTodo(String todo) {
		// TODO Auto-generated method stub
		
	}
	
	

}
