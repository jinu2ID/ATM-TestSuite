package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.CustomerConsole;
import atm.physical.CustomerConsole.Cancelled;
import banking.Money;
import simulation.Simulation;

public class TestCustomerConsoleClass {

	@Test
	public void testConstructor(){
		CustomerConsole newConsole = new CustomerConsole();
		assertNotNull(newConsole);
	}
	
	@Test
	public void testDisplay(){
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		Simulation newSimulation = new Simulation(newATM);
		
		newConsole.display("test");
		
		assertEquals("test", newATM.getDisplay());
	}
	
	@Test
	public void testGetDisplay(){
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		Simulation newSimulation = new Simulation(newATM);
		
		newConsole.display("test");
		
		assertEquals("test", newATM.getDisplay());
	}
	
	@Test
	public void testReadPIN() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		Simulation newSimulation = new Simulation(newATM);
		
		newATM.setCurrentInput("1234");
		
		assertEquals(1234, newConsole.readPIN("TEST"));
		
	}
	
	@Test(expected = Cancelled.class)
	public void testReadPIN_Null() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		MockSimulation newSimulation = new MockSimulation(newATM);
		
		int pin = newConsole.readPIN("TEST");
		
	}
	
	@Test
	public void testSetCurrentInput(){
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		Simulation newSimulation = new Simulation(newATM);
		
		newATM.setCurrentInput("1234");
		
		assertEquals("1234", Simulation.getInstance().getCurrentInput());
		
	}
	
	@Test
	public void testReadMenuChoice() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		Simulation newSimulation = new Simulation(newATM);
		
		newATM.setCurrentInput("1");
		String[] menu = {"1"};
		
		assertEquals(0, newConsole.readMenuChoice("TEST", menu));
	}
	
	@Test(expected = Cancelled.class)
	public void testReadMenuChoice_Null() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		MockSimulation newSimulation = new MockSimulation(newATM);
		String[] menu = {"1"};
		
		int choice = newConsole.readMenuChoice("TEST", menu);
	}
	
	@Test
	public void testReadAmount() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		Simulation newSimulation = new Simulation(newATM);
		
		newATM.setCurrentInput("10000");
		
		assertEquals("$100.00", newConsole.readAmount("test").toString());
	}
	
	@Test(expected = Cancelled.class)
	public void testReadAmount_Null() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		CustomerConsole newConsole = new CustomerConsole();
		MockSimulation newSimulation = new MockSimulation(newATM);
		
		Money money = newConsole.readAmount("test");
	}
	
	@Test
	public void testCancelledConstructor(){
		Cancelled cancel = new Cancelled();
		assertNotNull(cancel);
	}
	
	
}
