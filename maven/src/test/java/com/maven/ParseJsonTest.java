package com.maven;

import static org.junit.Assert.*;


import org.junit.Test;

public class ParseJsonTest {

	
	@Test
	public void testParseObject() {
		String gender = null ;
		String male = null;
		
		String expected=gender;
		String actual = male;
		assertEquals(expected, actual);
	}

	@Test
	public void testParseObject1() {
		String status = null ;
		String active = null;
		String expected=status;
		String actual = active;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testParseObject2() {
		
		String expected="kocchar_rita_md@marvin.com";
		String actual = "kocchar_rita_md@marvin.com";
		assertEquals(expected, actual);
	}
	@Test
	public void testParseObject3() {
		String name = "Rudra Khan" ;
		String expected=name;
		String actual = "Rudra Khan";
		assertEquals(expected, actual);
	}
}
