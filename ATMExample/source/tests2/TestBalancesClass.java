package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Balances;
import banking.Money;

public class TestBalancesClass {

	@Test
	public void testConstructor(){
		Balances bal = new Balances();
		assertNotNull(bal);
	}
	
	@Test
	public void testSetBalances(){
		Balances bal = new Balances();
		Money total = new Money(100);
		Money available = new Money(100);
		bal.setBalances(total, available);
		
		assertEquals("$100.00", bal.getTotal().toString());
		assertEquals("$100.00", bal.getAvailable().toString());
		
		
	}
}
