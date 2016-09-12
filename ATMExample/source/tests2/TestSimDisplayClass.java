package tests2;

import static org.junit.Assert.*;

import java.awt.Insets;

import org.junit.Test;

import simulation.SimDisplay;

public class TestSimDisplayClass {

	@Test
	public void testConstructor(){
		SimDisplay display = new SimDisplay();
		assertNotNull(display);
	}
	
	@Test
	public void testClearDisplay(){
		SimDisplay display = new SimDisplay();
		display.clearDisplay();
		
		assertEquals("",display.getDisplay());
	}
	
	@Test
	public void testDisplay(){
		SimDisplay display = new SimDisplay();
		display.display("TEST");
		
		System.out.println(display.getDisplay());
		assertEquals("TEST                                     "
				+ "                                            "
				+ "                                            "
				+ "                                            "
				+ "                                            "
				+ "                                            "
				+ "                                            "
				+ "                                            "
				+ "               ",display.getDisplay());
	}
	
	@Test
	public void testGetInsets(){
		SimDisplay display = new SimDisplay();
		Insets inset = display.getInsets();
		
		assertNotNull(inset);
	}
	

}
