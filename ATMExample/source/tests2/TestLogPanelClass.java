package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import simulation.GUI;
import simulation.LogPanel;
import simulation.SimCardReader;
import simulation.SimCashDispenser;
import simulation.SimDisplay;
import simulation.SimEnvelopeAcceptor;
import simulation.SimKeyboard;
import simulation.SimOperatorPanel;
import simulation.SimReceiptPrinter;
import simulation.Simulation;

public class TestLogPanelClass {

	@Test
	public void testConstructor(){
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
		
		LogPanel panel = new LogPanel(gui);
		assertNotNull(panel);
	}
	
	@Test
	public void testPrintln(){
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
		
		LogPanel panel = new LogPanel(gui);
		
		panel.println("test");
		
		assertEquals("test\n", panel.getLog());
	}
}
