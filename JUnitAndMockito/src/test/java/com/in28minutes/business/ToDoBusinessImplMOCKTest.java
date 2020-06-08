package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.in28minutes.data.api.ToDoService;

public class ToDoBusinessImplMOCKTest {

	@Test
	public void testRetrieveTodosRelatedToSpringTest_withMock() {
		
		ToDoService todoService = mock(ToDoService.class);
		
		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn testing");
		
		when(todoService.retrieveTodos("Dummy")).thenReturn(allToDos);
		
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
		
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		assertEquals(1,todos.size());
		
			
			}
	
	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {
		
		//Given -alles, was zum setup gehört
		ToDoService todoService = mock(ToDoService.class);
		
		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn testing");
		
		//in BDD kann ich statt when..thenReturn given...willReturn machen
		//macht das gleiche, nur andere Syntax
		given(todoService.retrieveTodos("Dummy")).willReturn(allToDos);
				
		
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
		
		//When -specific action, methodcall
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		
		//Then
		assertThat(todos.size(), is(1));
		//assertThat(),is()  ist auch einfach eine andere Syntax für AssertEquals
		
			
			}

	@Test
	public void testDeleteTodosUnrelatedToSpring() {
		
		//Given 
		ToDoService todoService = mock(ToDoService.class);
			
		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn Spring");
		
		given(todoService.retrieveTodos("Dummy")).willReturn(allToDos);
					
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
		
		//When 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		
		//Then
		verify(todoService).deleteTodo("clean");
		//alternativ zu verify die BDD-Syntax then....should
		then(todoService).should(never()).deleteTodo("learn Spring");
		verify(todoService,times(1)).deleteTodo("clean");
	}
	
	@Test
	public void testDeleteTodosUnrelatedToSpring_captureArgument() {
		//hier will ich jetzt checken, welcher Parameter dazu geführt hat,
		//dass "deleteTodo()" aufgerufen wurde. also wlecher parameter übergeben wurde
		
		//SChritt 1): Declare ArgumentCaptor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Schritt 2): Define Argument captor on specific method
		//Schritt 3): Capture the argument
		
		
		//Given 
		ToDoService todoService = mock(ToDoService.class);
			
		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn Spring");
		
		given(todoService.retrieveTodos("Dummy")).willReturn(allToDos);
					
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
		
		//When 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		
		//Then
		
		//Schritt 2): Define Argument captor on specific method
		then(todoService).should().deleteTodo(stringArgumentCaptor.capture());
		
		//Schritt 3): Capture the argument
		assertThat(stringArgumentCaptor.getValue(),is("clean"));
		
	
	}
	
	@Test
	public void testDeleteTodosUnrelatedToSpring_captureMultipleArguments() {
		//hier will ich jetzt checken, welcher Parameter dazu geführt hat,
		//dass "deleteTodo()" aufgerufen wurde. also wlecher parameter übergeben wurde
		
		//SChritt 1): Declare ArgumentCaptor
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//Schritt 2): Define Argument captor on specific method
		//Schritt 3): Capture the argument
		
		
		//Given 
		ToDoService todoService = mock(ToDoService.class);
			
		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn Spring testing");
		
		given(todoService.retrieveTodos("Dummy")).willReturn(allToDos);
					
		ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoService);
		
		//When 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");
		
		
		//Then
		
		//Schritt 2): Define Argument captor on specific method
		
		//then(todoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		then(todoService).should().deleteTodo(stringArgumentCaptor.capture());
		
		//Schritt 3): Capture the argument
		//assertThat(stringArgumentCaptor.getAllValues().size(),is(2)); (dafür muss spring bei testing raus)
		assertThat(stringArgumentCaptor.getValue(),is("clean"));
		
	
	}
}
