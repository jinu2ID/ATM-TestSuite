package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import banking.Money;
import simulation.GUI;
import simulation.SimCardReader;
import simulation.SimCashDispenser;
import simulation.SimDisplay;
import simulation.SimEnvelopeAcceptor;
import simulation.SimKeyboard;
import simulation.SimOperatorPanel;
import simulation.SimReceiptPrinter;
import simulation.Simulation;

public class TestGUIClass {

	@Test
	public void testConstruct(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimOperatorPanel simPanel = new SimOperatorPanel(newSimulation);
		SimCardReader cardReader = new SimCardReader(newSimulation);
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		SimCashDispenser dispenser = new SimCashDispenser();
		SimReceiptPrinter printer = new SimReceiptPrinter();
		
		GUI gui = new GUI(simPanel, cardReader, display, keyboard, dispenser, acceptor, printer);
		
		assertNotNull(gui);
	}
	
	@Test
	public void testGetInitialCash(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimOperatorPanel simPanel = new SimOperatorPanel(newSimulation);
		SimCardReader cardReader = new SimCardReader(newSimulation);
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		SimCashDispenser dispenser = new SimCashDispenser();
		SimReceiptPrinter printer = new SimReceiptPrinter();
		
		GUI gui = new GUI(simPanel, cardReader, display, keyboard, dispenser, acceptor, printer);
		
		gui.setBills("5");
		Money money = gui.getInitialCash();
		assertEquals("$100.00", money.toString());
		
	}
	
	@Test
	public void testGetBillsPanelsBills(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimOperatorPanel simPanel = new SimOperatorPanel(newSimulation);
		SimCardReader cardReader = new SimCardReader(newSimulation);
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		SimCashDispenser dispenser = new SimCashDispenser();
		SimReceiptPrinter printer = new SimReceiptPrinter();
		
		GUI gui = new GUI(simPanel, cardReader, display, keyboard, dispenser, acceptor, printer);
		
		gui.setBills("5");
		String bills = gui.getBillsPanelBills();
		assertEquals("5", bills);
		
	}
	
	@Test
	public void testGetNFECount(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimOperatorPanel simPanel = new SimOperatorPanel(newSimulation);
		SimCardReader cardReader = new SimCardReader(newSimulation);
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		SimCashDispenser dispenser = new SimCashDispenser();
		SimReceiptPrinter printer = new SimReceiptPrinter();
		
		GUI gui = new GUI(simPanel, cardReader, display, keyboard, dispenser, acceptor, printer);
		assertEquals(0, gui.getNFECount());
		
	}
	
	@Test
	public void testSetCardNumberField(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimOperatorPanel simPanel = new SimOperatorPanel(newSimulation);
		SimCardReader cardReader = new SimCardReader(newSimulation);
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		SimCashDispenser dispenser = new SimCashDispenser();
		SimReceiptPrinter printer = new SimReceiptPrinter();
		
		GUI gui = new GUI(simPanel, cardReader, display, keyboard, dispenser, acceptor, printer);
		
		gui.setBills("5");
		gui.setCardNumberField("1234");
		assertEquals("1234", gui.getCardNumberField());
		
	}
	
	
}
