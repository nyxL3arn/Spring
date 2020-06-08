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
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.ToDoService;

//statt dem Runner kann ich auch eine @Rule definieren:
//die macht das gleiche, aber ich kann mehrere davon haben

@RunWith(MockitoJUnitRunner.class)
public class ToDoBusinessImplMockito_InjectMocks {
	//@Rule
	//public MockitoRule mockitoRule = MockitoJUnit.rule();
	//kümmert sich auch wie der Runner darum, eine Instanz des Konstruktors mit
	//den richtigen parametern zu erzeugen und dass die Mocks funktionieren.
	
	
	@Mock
	ToDoService todoServiceMock;
	//das ist dasselbe wie vorher: =mock(toDoService)

	@InjectMocks
	ToDoBusinessImpl todoBusinessImpl;
	//das erzeugt eine Instanz v. ToDoBusinessImpl mit dem passenden Mock toDoService
	//wenn ich vorher mit @Mocks noch mehr Instanzen erzeugt hätte und ToDoBusinessImpl die bräcuhte,
	//dann würden die hier auch eingefügt
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor= ArgumentCaptor.forClass(String.class);
	
	@Test
	public void testRetrieveTodosRelatedToSpringTest_withMock() {


		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn testing");

		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(allToDos);

		//diese Zeile kann weg, weil @InjectMocks schon eine Initialisierung des Konstruktors ToDoBusinessImpl
		//mit den passenden Mocks macht:
		//ToDoBusinessImpl todoBusinessImpl = new ToDoBusinessImpl(todoServiceMock);

		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

		assertEquals(1,todos.size());


	}

	@Test
	public void testRetrieveTodosRelatedToSpring_usingBDD() {

		//Given -alles, was zum setup gehört

		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn testing");

		//in BDD kann ich statt when..thenReturn given...willReturn machen
		//macht das gleiche, nur andere Syntax
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allToDos);


		//When -specific action, methodcall
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");


		//Then
		assertThat(todos.size(), is(1));
		//assertThat(),is()  ist auch einfach eine andere Syntax für AssertEquals


	}

	@Test
	public void testDeleteTodosUnrelatedToSpring() {

		//Given 


		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn Spring");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allToDos);


		//When 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");


		//Then
		verify(todoServiceMock).deleteTodo("clean");
		//alternativ zu verify die BDD-Syntax then....should
		then(todoServiceMock).should(never()).deleteTodo("learn Spring");
		verify(todoServiceMock,times(1)).deleteTodo("clean");
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

		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn Spring");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allToDos);


		//When 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");


		//Then

		//Schritt 2): Define Argument captor on specific method
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

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
		
		List<String>allToDos = Arrays.asList("learn Spring Boot", "clean", "learn Spring testing");

		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(allToDos);


		//When 
		todoBusinessImpl.deleteTodosNotRelatedToSpring("Dummy");


		//Then

		//Schritt 2): Define Argument captor on specific method

		//then(todoService).should(times(2)).deleteTodo(stringArgumentCaptor.capture());
		then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

		//Schritt 3): Capture the argument
		//assertThat(stringArgumentCaptor.getAllValues().size(),is(2)); (dafür muss spring bei testing raus)
		assertThat(stringArgumentCaptor.getValue(),is("clean"));


	}
}
