package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import simulation.SimOperatorPanel;
import simulation.Simulation;

public class TestSimOperatorPanelClass {
	
	@Test
	public void testConstructor(){
		ATM newATM = new ATM(1, "","",null);
		Simulation newSimulation = new Simulation(newATM);
		SimOperatorPanel panel = new SimOperatorPanel(newSimulation);
		assertNotNull(panel);
	}

}
