package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.CardReader;
import atm.physical.CashDispenser;
import atm.physical.CustomerConsole;
import atm.physical.EnvelopeAcceptor;
import simulation.Simulation;

public class TestATMClass {

	@Test
	public void testATMConstructor(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		
		assertNotNull(newATM);
	}

	@Test
	public void testRun(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		Thread atm = new Thread(newATM);
		atm.start();
		newATM.switchOn();
		newATM.setBills("5");
		
		try {
			atm.join(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void testSwitchOn(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		newATM.switchOn();
		
		assertTrue(newATM.getSwitchOn());
		
	}
	
	@Test
	public void testSwitchOff(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		newATM.switchOn();
		
		newATM.switchOff();
		
		assertFalse(newATM.getSwitchOn());
		
	}
	
	@Test
	public void testCardInserted(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		assertFalse(newATM.getCardInserted());
		
		newATM.cardInserted();
		assertTrue(newATM.getCardInserted());
		
	}
	
	@Test
	public void testSetCardNumberField(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		newATM.setCardNumberField("1234");
		
		assertEquals("1234", Simulation.getInstance().getCardNumberField());
		
	}
	
	@Test
	public void testSetCurrentInput(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		newATM.setCurrentInput("1");
		
		assertEquals("1", Simulation.getInstance().getCurrentInput());
	}
	
	@Test
	public void testGetID(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		int id = newATM.getID();
		
		assertEquals(1, id);
	}
	
	@Test
	public void testGetPlace(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		String place = newATM.getPlace();
		
		assertEquals("testPlace", place);
	}
	
	@Test
	public void testGetBankName(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		String bankName = newATM.getBankName();
		
		assertEquals("testBank", bankName);
		
	}
	
	@Test
	public void testGetCardReader(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CardReader newReader = newATM.getCardReader();
		
		assertNotNull(newReader);
	}
	
	@Test
	public void testGetCashDispenser(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CashDispenser newDispenser = newATM.getCashDispenser();
		
		assertNotNull(newDispenser);
	}
	
	@Test
	public void testGetCustomerConsole(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CustomerConsole newConsole = newATM.getCustomerConsole();
		
		assertNotNull(newConsole);
	}
	
	@Test
	public void testGetEnvelopeAcceptor(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		EnvelopeAcceptor newAcceptor = newATM.getEnvelopeAcceptor();
		
		assertNotNull(newAcceptor);
	}
	
	@Test
	public void testEnvelopeAcceptorIsVisible
	(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		
		assertFalse(newATM.envelopeAcceptorIsVisible());
	}
	
	@Test
	public void testEnvelopeAcceptorIsVisibleFalse(){
	
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		Simulation.getInstance().acceptEnvelope();
		
		assertFalse(newATM.envelopeAcceptorIsVisible());
		
	}
	
	@Test
	public void testGetEnvelopeAcceptorLabel(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getEnvelopeAcceptorLabel());
	}
	
	@Test
	public void testSetEnvelopeInsert(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		Simulation.getInstance().acceptEnvelope();
		
		newATM.setEnvelopeInsert(true);
		
		assertTrue(Simulation.getInstance().getEnvelopeInserted());
	}
	
	@Test
	public void testGetLog(){

		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getLog());
	}
	
	@Test
	public void testGetLogString(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getLogString());
		
	}
	
	@Test
	public void testGetNetworkToBank(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getNetworkToBank());
	}
	
	@Test
	public void testGetOperatorPanel(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getOperatorPanel());
		
	}
	
	@Test
	public void testGetReceiptPrinter(){
	
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getReceiptPrinter());
	}
	
	@Test
	public void testGetReciept(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getReceipt());
	}
	
	@Test
	public void testGetState(){
	
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertEquals(0, newATM.getState());
	}
	
	@Test
	public void testGetSwitchOn(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertFalse(newATM.getSwitchOn());
	}
	
	@Test
	public void testGetCardInserted(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertFalse(newATM.getCardInserted());
	}
	
	@Test
	public void testSetBills(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		newATM.setBills("5");
		assertEquals("5",(Simulation.getInstance().getBillsPanelBills()));
		
	}
	
	@Test 
	public void testGetNFECount(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertEquals(0, newATM.getNFECount());
	}
	
	@Test
	public void testGetCard(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getCard());
	}
	
	@Test
	public void testGetDisplay(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getDisplay());
	}
	
	@Test
	public void testGetLabel(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getLabel());
	}
	
	@Test
	public void testUpdateSessionState(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		newATM.updateSessionState(1);
		assertEquals(1, newATM.sessionState);
	}
	
	@Test
	public void testUpdateTransactionState(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		newATM.updateTransactionState(1);
		assertEquals(1, newATM.transactionState);
	}
	
	@Test
	public void testUpdatePinInvalidCount(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertEquals(0, newATM.pinInvalidCount);
		newATM.updatePinInvalidCount(1);
		assertEquals(1, newATM.pinInvalidCount);
	}
	
	@Test
	public void testUpdateCardRetained(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertFalse(newATM.isCardRetained);
		newATM.updateCardRetained(true);
		assertTrue(newATM.isCardRetained);
	}
	
	@Test
	public void testCancelKeyPress(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		newATM.cancelKeyPressed();
		assertTrue(Simulation.getInstance().getCancelled());
	}
	
	@Test
	public void testGetCOH(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		
		assertNotNull(newATM.getCOH());
	}
}
