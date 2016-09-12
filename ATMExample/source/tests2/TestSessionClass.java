package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.Session;
import simulation.Simulation;

public class TestSessionClass {
	
	@Test
	public void testSessionConstructor(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Session newSession = new Session(newATM);
		
		assertNotNull(newSession);
	}
	
	@Test
	public void testSetPIN(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Session newSession = new Session(newATM);
		
		newSession.setPIN(1234);
		
		assertEquals(1234, newSession.getPIN());
		
	}
	
	@Test
	public void testGetATM(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Session newSession = new Session(newATM);
		
		assertNotNull(newSession.getATM());
	}
	
	@Test
	public void testGetState(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Session newSession = new Session(newATM);
		
		assertEquals(1, newSession.getState());
	}
	
	@Test
	public void testGetPIN(){
		
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Session newSession = new Session(newATM);
		
		newSession.setPIN(1234);
		assertEquals(1234, newSession.getPIN());
	}

}
