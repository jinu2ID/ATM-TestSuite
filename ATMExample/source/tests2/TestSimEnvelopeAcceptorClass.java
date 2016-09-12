package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import simulation.SimEnvelopeAcceptor;

public class TestSimEnvelopeAcceptorClass {
	
	@Test
	public void testConstructor(){
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		assertNotNull(acceptor);
	}
	
	@Test
	public void testAcceptEnvelope(){
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		acceptor.acceptEnvelope();
	}

	@Test
	public void testSetEnvelopeInserted(){
		SimEnvelopeAcceptor acceptor = new SimEnvelopeAcceptor();
		acceptor.setEnvelopeInserted(true);
		assertTrue(acceptor.getEnvelopeInserted());
		
	}
}
