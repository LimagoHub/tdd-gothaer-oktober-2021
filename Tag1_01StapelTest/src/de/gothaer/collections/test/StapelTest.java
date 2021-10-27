package de.gothaer.collections.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.gothaer.collections.Stapel;
import de.gothaer.collections.StapelException;

class StapelTest {
	
	private Stapel objectUnderTest;
	
	@BeforeEach
	public void setUp() {
		objectUnderTest = new Stapel();
	}

	@Test
	void isEmpty_leererStapel_returnsTrue() {
		// Arrange
		
		
		
		// Act
	
		
		// Assertion
		assertTrue(objectUnderTest.isEmpty());
	}

	@Test
	void isEmpty_nichtLeererStapel_returnsFalse() throws Exception{
		// Arrange
		
		objectUnderTest.push(new Object());
		
		// Act
	
		
		// Assertion
		assertFalse(objectUnderTest.isEmpty());
	}
	
	@Test
	void isEmpty_wiederLeererStapel_returnsTrue() throws Exception{
		// Arrange
		
		objectUnderTest.push(new Object());
		objectUnderTest.pop();
		// Act
	
		
		// Assertion
		assertTrue(objectUnderTest.isEmpty());
	}

	@Test
	void push_LeererStapel_valueSuccessfullyStored() throws Exception{
		// Arrange
		
		Object object = new Object();
		
		// Act
	
		objectUnderTest.push(object);
		// Assertion
		
		Object result = objectUnderTest.pop();
		assertSame(object, result);
	}

	@Test
	void push_fillupToLimit_noException() throws Exception{
		// Arrange
		
		fillUpToLimit();
		
		// Act
		
		
		// Assertion
		//assertDoesNotThrow(()->objectUnderTest.push(new Object())); // so ist es richtig
		
	}
	
	@Test
	void push_overflow_throwsStapelException() throws Exception{
		// Arrange
		
		fillUpToLimit();
		
		// Act
		
		StapelException ex = assertThrows(StapelException.class, ()->objectUnderTest.push(new Object()));
		// Assertion
		
		assertEquals("Overflow", ex.getMessage());
		
	}

	private void fillUpToLimit() throws StapelException {
		for (int i = 0; i < 10; i++) {
			objectUnderTest.push(new Object());
		}
	}


}
