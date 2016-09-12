package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.CustomerConsole;
import atm.physical.CustomerConsole.Cancelled;
import atm.physical.EnvelopeAcceptor;
import atm.physical.Log;
import simulation.Simulation;

public class TestEnvelopeAcceptorClass {

	@Test
	public void testConstructor(){
		
		Log log = new Log();
		EnvelopeAcceptor acceptor = new EnvelopeAcceptor(log);
		assertNotNull(acceptor);
	}
	
	@Test
	public void testAcceptEnvelope() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		EnvelopeAcceptor acceptor = new EnvelopeAcceptor(newATM.getLog());
		MockSimulation newSimulation = new MockSimulation(newATM);
		newSimulation.envelopeInserted = true;
		
		acceptor.acceptEnvelope();
	}
	
	@Test(expected = Cancelled.class)
	public void testAcceptEnvelope_Cancel() throws Cancelled{
		
		ATM newATM = new ATM(1,"testPlace", "testBank", null);
		EnvelopeAcceptor acceptor = new EnvelopeAcceptor(newATM.getLog());
		MockSimulation newSimulation = new MockSimulation(newATM);
		newSimulation.envelopeInserted = false;
		
		acceptor.acceptEnvelope();
	}
}
