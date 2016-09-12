package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.CardReader;
import simulation.Simulation;

public class TestCardReaderClass {

	@Test
	public void testConstructor(){
	
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		CardReader reader = new CardReader(newATM);
		
		assertNotNull(reader);
	}
	
	@Test
	public void testReadCard(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		MockSimulation newSimulation = new MockSimulation(newATM);
		CardReader reader = new CardReader(newATM);
		
		assertNotNull(reader.readCard());
	}
	
	@Test
	public void testSetCardNumberField(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		CardReader reader = new CardReader(newATM);
		
		reader.setCardNumberField("1234");
		
		assertEquals("1234", Simulation.getInstance().getCardNumberField());
	}
	
	@Test
	public void testEjectCard(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		MockSimulation theSimulation = new MockSimulation(newATM);
		CardReader reader = new CardReader(newATM);
		
		reader.ejectCard();
	}
	
	@Test
	public void testRetainCard(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		MockSimulation theSimulation = new MockSimulation(newATM);
		CardReader reader = new CardReader(newATM);
		
		reader.retainCard();
	}
	
	
}
