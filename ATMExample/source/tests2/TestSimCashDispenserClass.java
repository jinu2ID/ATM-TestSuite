package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Money;
import simulation.SimCashDispenser;

public class TestSimCashDispenserClass {
	
	@Test
	public void testConstructor(){
		SimCashDispenser dispenser = new SimCashDispenser();
		assertNotNull(dispenser);
	}
	
	@Test
	public void testAnimateDispensingCash(){
		SimCashDispenser dispenser = new SimCashDispenser();
		Money money = new Money(100);
		
		dispenser.animateDispensingCash(money);
		assertEquals("$100.00", dispenser.getLabel());
	}

}
