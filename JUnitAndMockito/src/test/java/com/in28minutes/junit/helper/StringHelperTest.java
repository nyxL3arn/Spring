package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringHelperTest {
	StringHelper helper= new StringHelper();

	@Test
	public void testTruncateAInFirst2Positions_AinfirstTwoPositions() {
		assertEquals("CD",helper.truncateAInFirst2Positions("AACD"));
		
		
	}             

	@Test 
	public void test2_AinfirstPosition() {
		assertEquals("CD",helper.truncateAInFirst2Positions("ACD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_BasicPositiveScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
	}
	
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_2charactersScenario() {
		assertTrue(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
	@Test
	public void testAreFirstAndLastTwoCharactersTheSame_OnecharactersScenario() {
		assertFalse(helper.areFirstAndLastTwoCharactersTheSame("AB"));
	}
}
