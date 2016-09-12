package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Card;

public class TestCardClass {

	@Test
	public void testConstructor(){
		Card card = new Card(1234);
		assertNotNull(card);
	}
	
	@Test
	public void testGetNumber(){
		Card card = new Card(1234);
		assertEquals(1234, card.getNumber());
	}
}
