package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import simulation.CardPanel;

public class TestCardPanelClass {
	
	@Test
	public void testConstructor(){
		CardPanel panel = new CardPanel();
		assertNotNull(panel);
	}

	@Test
	public void testReadCardNumber(){
		CardPanel panel = new CardPanel();
		panel.setCardNumberField("1234");
		assertEquals(1234, panel.readCardNumber());
		
	}
	
	@Test
	public void testReadCardNumber_Negative(){
		CardPanel panel = new CardPanel();
		panel.setCardNumberField("-1");
		assertEquals(-1, panel.readCardNumber());
		
	}
	
	@Test
	public void testReadCardNumber_NonNumeric(){
		CardPanel panel = new CardPanel();
		panel.setCardNumberField("A");
		assertEquals(-1, panel.readCardNumber());
		
	}
	
	@Test
	public void testGetCardNumberField(){
		CardPanel panel = new CardPanel();
		panel.setCardNumberField("1234");
		assertEquals("1234", panel.getCardNumberField());
	}
}
