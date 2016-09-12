package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Money;

public class TestMoneyClass {
	
	@Test
	public void testConstructor(){
		Money newMoney = new Money(100);
		assertNotNull(newMoney);
	}
	
	@Test
	public void testCopyConstructor(){
		Money newMoney = new Money(100);
		Money theMoney = new Money(newMoney);
		assertNotNull(theMoney);
		assertEquals("$100.00", theMoney.toString());
	}
	
	@Test
	public void testToString(){
		Money newMoney = new Money(100, 10);
		assertEquals("$100.10", newMoney.toString());
		
	}
	
	@Test
	public void testAdd(){
		Money newMoney = new Money(100);
		Money toAdd = new Money(10);
		newMoney.add(toAdd);
		assertEquals("$110.00", newMoney.toString());
	}

	@Test
	public void testSubtract(){
		Money newMoney = new Money(100);
		Money toSub = new Money(10);
		newMoney.subtract(toSub);
		assertEquals("$90.00", newMoney.toString());
	}

	@Test
	public void testLessEqual(){
		Money newMoney = new Money(100);
		Money toCompare = new Money(10);
		
		assertFalse(newMoney.lessEqual(toCompare));
		toCompare.add(newMoney);
		assertTrue(newMoney.lessEqual(toCompare));
	}
	
	@Test
	public void testGetCents(){
		Money newMoney = new Money(100);
		assertEquals(10000, newMoney.getCents());
	}
	
}
