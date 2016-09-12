package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.OperatorPanel;
import banking.Money;
import simulation.Simulation;

public class TestOperatorPanel {

	@Test
	public void testConstructor(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		OperatorPanel panel = new OperatorPanel(newATM);
		
		assertNotNull(panel);
	}
	
	@Test
	public void testGetInitialCash(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		OperatorPanel panel = newATM.getOperatorPanel();
		newATM.setBills("5");
		
		Money testMoney = panel.getInitialCash();
		assertEquals("$100.00", testMoney.toString());
	}
	
	
	@Test
	public void testSetBills(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		OperatorPanel panel = newATM.getOperatorPanel();
		panel.setBills("5");
		
		assertEquals("5", Simulation.getInstance().getBillsPanelBills());
	}
	
	@Test
	public void testGetNFECount(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		OperatorPanel panel = newATM.getOperatorPanel();
		
		assertEquals(0, panel.getNFECount());
	}
	
	@Test
	public void testGetCard(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		OperatorPanel panel = newATM.getOperatorPanel();
		assertEquals("ATM", panel.getCard());
	}
	
	
}
