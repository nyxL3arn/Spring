package com.in28minutes.junit.helper;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {

	//wir verwenden Arrays.sort(array[],startpunkt,endpunkt) --> sortiert Arrays aufsteigend
	@Test
	public void testArraySort() {
		int[] numbers= {12,3,4,1};
		int[] expected= {1,3,4,12};
		Arrays.sort(numbers); //ergibt 1,3,4,12 Die Methode hat keine Rückgabe
		assertArrayEquals(expected,numbers);
		//Fehlermeldung: arrays first differed at element [1]; expected:<4> but was:<3>
		
	}
	@Test(expected=NullPointerException.class)
	public void testArraySort_NullArray() {
		int[] numbers= null;
		Arrays.sort(numbers); //wirft NullPointerException
				//da wir diese erwartet haben, ist Test grün
		//Wenn wir aber statt null ein leeres Array übergeben (numbers={}),
		//dann gibt's keine exception und der test ist rot
	}
} 
