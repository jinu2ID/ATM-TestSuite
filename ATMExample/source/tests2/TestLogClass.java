package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.Log;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import simulation.Simulation;

public class TestLogClass {

	@Test
	public void testConstructor(){
		
		Log log = new Log();
		assertNotNull(log);
	}
	
	@Test
	public void testLogSend(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		Log theLog = newATM.getLog();
		Money testMoney = new Money(100);
		Card testCard = new Card(1);
		Message testMessage = new Message(1,testCard, 1, 1, 1, 1, testMoney);
		
		theLog.logSend(testMessage);
		assertEquals("Message:   INIT_DEP CARD# 1 TRANS# 1 FROM  1 TO  1 $100.00\n", newATM.getLogString());
		
	}
	
	public class testStatus extends Status{

		public testStatus(String _text){
			text = _text;
		}
		public String toString()
		{
			return text;
		}
		@Override
		public boolean isSuccess() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isInvalidPIN() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return null;
		}
		
		String text;
		
	}
	
	@Test
	public void testLogResponse(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		Log theLog = newATM.getLog();
		Status status = new testStatus("Test");
		theLog.logResponse(status);
		assertEquals("Response:  Test\n", newATM.getLogString());
		
	}
	
	@Test
	public void testLogCashDispensed(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		Log theLog = newATM.getLog();
		Money testMoney = new Money(100);
		theLog.logCashDispensed(testMoney);
		assertEquals("Dispensed: $100.00\n", newATM.getLogString());
		
	}
	
	@Test
	public void testLogEnvelopeAccepted(){
		ATM newATM = new ATM(1, "testPlace", "testBank", null);
		Simulation theSimulation = new Simulation(newATM);
		Log theLog = newATM.getLog();
		
		theLog.logEnvelopeAccepted();
		assertEquals("Envelope:  received\n", newATM.getLogString());
	}
}
