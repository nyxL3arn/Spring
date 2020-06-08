package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

public class ListCase {

	@Test
	public void letsMockListSizeMethod_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3);
		assertEquals(2, listMock.size());
		assertEquals(3, listMock.size());
	}

	@Test(expected=RuntimeException.class) 
	public void letsMockListThrowException(){
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		listMock.get(0);
	}
	
	@Test
	public void letsMockListSizeMethodGet_usingBDD() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("Huhu");
		
		//When
		String firstElement = listMock.get(0);
		//listMock.get(0);
		
		//Then
		assertThat(firstElement,is("Huhu"));
		

		}
	}
