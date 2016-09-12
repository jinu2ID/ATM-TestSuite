package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import simulation.SimCardReader;
import simulation.Simulation;

public class TestSimCardReaderClass {
	
	@Test
	public void testConstructor(){
		ATM newATM = new ATM(1, "testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimCardReader reader = new SimCardReader(newSimulation);
		
		assertNotNull(reader);
	}
	
	@Test
	public void testAnimateInsertion(){
		ATM newATM = new ATM(1, "testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimCardReader reader = new SimCardReader(newSimulation);
		newATM.setBills("5");
		newATM.switchOn();
		
		reader.animateInsertion();
		
	}
	
	
	@Test
	public void testAnimateRetention(){
		ATM newATM = new ATM(1, "testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		SimCardReader reader = new SimCardReader(newSimulation);
		
		reader.animateRetention();
		
	}

}
