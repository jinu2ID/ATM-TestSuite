package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.CardReader;
import atm.physical.CashDispenser;
import banking.Money;

public class TestCashDispenserClass {

	@Test
	public void testConstructor(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser dispenser = new CashDispenser(newATM.getLog());
		
		assertNotNull(dispenser);
	}
	
	@Test
	public void testSetInitialCash(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser dispenser = new CashDispenser(newATM.getLog());
		Money newMoney = new Money(100);
		dispenser.setInitialCash(newMoney);
		
		assertEquals(newMoney, dispenser.getCOH());
	}
	
	@Test
	public void testCheckCashOnHand(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser dispenser = new CashDispenser(newATM.getLog());
		Money newMoney = new Money(100);
		dispenser.setInitialCash(newMoney);
		
		Money withdraw = new Money(90);
		assertTrue(dispenser.checkCashOnHand(withdraw));
		
	}
	
	@Test
	public void testCheckCashOnHandFalse(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser dispenser = new CashDispenser(newATM.getLog());
		Money newMoney = new Money(100);
		dispenser.setInitialCash(newMoney);
		
		Money withdraw = new Money(200);
		assertFalse(dispenser.checkCashOnHand(withdraw));
		
	}
	
	@Test
	public void testDispenseCash(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		MockSimulation newSimulation = new MockSimulation(newATM);
		CashDispenser dispenser = new CashDispenser(newATM.getLog());
		Money newMoney = new Money(100);
		dispenser.setInitialCash(newMoney);
		Money withdraw = new Money(50);
		
		dispenser.dispenseCash(withdraw);
	}
	
	@Test
	public void testGetCOH(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser dispenser = new CashDispenser(newATM.getLog());
		Money newMoney = new Money(100);
		dispenser.setInitialCash(newMoney);
		
		assertEquals(newMoney, dispenser.getCOH());
	}
}
