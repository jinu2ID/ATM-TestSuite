package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import banking.Balances;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import simulation.SimulatedBank;
import simulation.Simulation;

public class TestSimulationClass {

	@Test
	public void testConstructor(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		assertNotNull(newSimulation);
	}
	
	@Test
	public void testGetInstance(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		assertNotNull(Simulation.getInstance());
	}
	
	@Test
	public void testGetInitialCash(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newATM.setBills("5");
		Money money = newSimulation.getInitialCash();
		assertEquals("$100.00",money.toString());
	}
	
	@Test
	public void testGetBillsPanelBills(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newATM.setBills("5");
		assertEquals("5",newSimulation.getBillsPanelBills());
	}
	
	@Test
	public void testGetNFECount(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newATM.setBills("5");
		newSimulation.getInitialCash();
		assertEquals(0,newSimulation.getNFECount());
	}
	
	@Test
	public void testSetCardNumberField(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.setCardNumberField("1234");
		assertEquals("1234",newSimulation.getCardNumberField());
	}
	
	@Test
	public void testGetCard(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		assertEquals("ATM",newSimulation.getCard());
	}
	
	@Test
	public void testReadCard(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.setCardNumberField("1234");
		assertEquals(1234, newSimulation.readCard().getNumber());
	}
	
	@Test
	public void testEjectCard(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newATM.switchOn();
		newATM.setBills("5");
		newSimulation.setCardNumberField("1234");
		newSimulation.retainCard();
		assertEquals("$XXX.XX",newATM.getLabel());
	}
	
	@Test
	public void testClearDisplay(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.clearDisplay();
		assertEquals("",newSimulation.getDisplay());
	}
	
	@Test
	public void testDisplay(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.display("test");
		boolean empty = newSimulation.getDisplay().isEmpty();
		assertFalse(empty);
	}
	
	@Test
	public void testReadInput(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.setCurrentInput("1");
		String input = newSimulation.readInput(0, 0);
		assertEquals("1",input);
	}
	
	@Test
	public void testGetCurrentInput(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.setCurrentInput("1234");
		assertEquals("1234",newSimulation.getCurrentInput());
	}
	
	@Test
	public void testCancelKeyPressed(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.cancelKeyPressed();
		assertEquals(true, newSimulation.getCancelled());
	}
	
	@Test
	public void testSendMessage(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(1, card,1,1,1,1,money);
		Balances balance = new Balances();
		Status status = newSimulation.sendMessage(message, balance);
		assertEquals("FAILURE Invalid card",status.toString());
	}
	
	@Test
	public void testSwitchChanged(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.switchChanged(true);
		assertEquals(true, newATM.getSwitchOn());
		newSimulation.switchChanged(false);
		assertEquals(false, newATM.getSwitchOn());
	}
	
	@Test
	public void testCardInserted(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		newSimulation.cardInserted();
		assertTrue(newATM.getCardInserted());
	}
	
	@Test
	public void testGetSimulatedBank(){
		ATM newATM = new ATM(1,"","",null);
		Simulation newSimulation = new Simulation(newATM);
		SimulatedBank bank = newSimulation.getSimulatedBank();
		assertNotNull(bank);
	}
	
}
