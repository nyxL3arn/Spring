package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) //erster Schritt: hiermit lege ich fest, dass 
//die Parameter getestet werden solle
public class StringHelper_ParameterisedTest {
	
	StringHelper helper= new StringHelper();
	
	//Schritt3: ich erzeuge mir die Variablen für die Parameter
	private String input;
	private String expectedOutput;
	
	
	//SChritt 4: rechtsklick, source, generate constructor using fields
	//(und da nehme ich helper raus)--> generiert den Konstruktor
	public StringHelper_ParameterisedTest(String input, String expectedOutput) {
		super();
		this.input = input;
		this.expectedOutput = expectedOutput;
	}


	@Parameters //Schritt 2: hier werden die Parameter festgelegt
	public static Collection <String[]> testConditions() {
		String expectedOutputs[][]= {{"AACD","CD"},
				{"ACD", "CD"}};
		return Arrays.asList(expectedOutputs); //wandelt Array in Collection um
		}
	
	//Schritt 5: Ich will den Test dazu kriegen, die parameter zu benutzeb
	@Test
	public void testTruncateAInFirst2Positions_AinfirstTwoPositions() {
		assertEquals(expectedOutput,helper.truncateAInFirst2Positions(input));
			
	}             

	@Test 
	public void test2_AinfirstPosition() {
		assertEquals(expectedOutput,helper.truncateAInFirst2Positions(input));
	}
	
	
	
	
}
