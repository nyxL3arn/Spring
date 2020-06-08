package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;
import org.hamcrest.Matcher;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;

import org.junit.Test;

import com.in28minutes.data.api.ToDoService;
import com.in28minutes.data.api.ToDoServiceStub;




public class ToDoBusinessImplStubTest {

	@Test
	public void testRetrieveTodosRelatedToSpringTest_withStub() {
		
		ToDoService todoServiceStub = new ToDoServiceStub();
		
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoServiceStub);
		
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
	//	assertEquals(2,filteredTodos.size());
		
		assertThat(filteredTodos, 
			      hasItems("Learn Spring Boot", "Learn Spring"));
		
		
			}
		
		

}
