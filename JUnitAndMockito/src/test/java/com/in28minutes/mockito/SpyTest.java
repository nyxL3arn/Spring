package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		
	List arrayListMock=mock(ArrayList.class);
	assertEquals(0,arrayListMock.size());
		
		//mocks return default value 0
	//--> the test passes. 
		
//ArrayList doesn have functionality,
	//das ist mir aber auch egal.
	//Aber, wenn ich Funktionalität haben will, dann
	//nutze ich statt mock spy:
		
	List arrayListSpy=spy(ArrayList.class);
	//creates a real ArrayList of size 0
	assertEquals(0,arrayListSpy.size());
	
	arrayListSpy.add("Dummy");
	assertEquals(1,arrayListSpy.size());
	
	//--> ist eine real ArrayList, ABER:
	//I can use stub methods:	
	stub(arrayListSpy.size()).toReturn(5);
	
	assertEquals(5,arrayListSpy.size());
	verify(arrayListSpy, never()).clear();
	
	}

}
