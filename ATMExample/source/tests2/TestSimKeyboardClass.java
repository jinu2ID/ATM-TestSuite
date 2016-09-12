package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import simulation.SimDisplay;
import simulation.SimEnvelopeAcceptor;
import simulation.SimKeyboard;

public class TestSimKeyboardClass {
	
	@Test
	public void testConstructor(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		assertNotNull(keyboard);
	}
	
	@Test
	public void testReadInput(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		keyboard.setCurrentInput("test");
		assertEquals("test", keyboard.readInput(0,0));
	}
	
	@Test
	public void testDigitKeyPressed(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		keyboard.digitKeyPressed(1);
	}
	
	@Test
	public void testDigitKeyPressed_PIN_Mode(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		keyboard.setMode(1);
		keyboard.digitKeyPressed(1234);
		boolean empty = display.getDisplay().isEmpty();
		assertFalse(empty);
	}
	
	@Test
	public void testDigitKeyPressed_Amount_Mode(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		
		// length == 1
		keyboard.setMode(2);
		keyboard.digitKeyPressed(1);
		boolean empty = display.getDisplay().isEmpty();
		assertFalse(empty);
		
		// length == 2
		keyboard.setCurrentInput("");
		keyboard.digitKeyPressed(12);
		empty = display.getDisplay().isEmpty();
		assertFalse(empty);
		
		// length > 2
		keyboard.setCurrentInput("");
		keyboard.digitKeyPressed(123);
		empty = display.getDisplay().isEmpty();
		assertFalse(empty);
	}
	
	@Test
	public void testDigitKeyPressed_Menu_Mode(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		
		keyboard.setMode(3);
		keyboard.digitKeyPressed(1);
		boolean empty = display.getDisplay().isEmpty();
		assertFalse(empty);
		
		// set max value
		keyboard.setMode(3);
		keyboard.setMaxValue(2);
		keyboard.digitKeyPressed(1);
		empty = display.getDisplay().isEmpty();
		assertFalse(empty);
	}
	
	@Test
	public void testCancelKeyPressed(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		keyboard.cancelKeyPressed();
		assertTrue(keyboard.getCancelled());
	}
	
	@Test
	public void testGetCurrentInput(){
		SimDisplay display = new SimDisplay();
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		SimKeyboard keyboard = new SimKeyboard(display, acceptor);
		keyboard.setCurrentInput("test");
		assertEquals("test", keyboard.getCurrentInput());
	}
	

}
