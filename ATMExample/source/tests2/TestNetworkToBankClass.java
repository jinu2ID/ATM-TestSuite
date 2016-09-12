package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.Log;
import atm.physical.NetworkToBank;
import banking.Balances;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import simulation.Simulation;

public class TestNetworkToBankClass {

	@Test
	public void testConstructor(){
		
		Log log = new Log();
		NetworkToBank newNTB = new NetworkToBank(log, null);
		
		assertNotNull(newNTB);
	}
	
	@Test
	public void testOpenConnection(){
		
		Log log = new Log();
		NetworkToBank newNTB = new NetworkToBank(log, null);
		newNTB.openConnection();
	}
	
	@Test
	public void testCloseConnection(){
		
		Log log = new Log();
		NetworkToBank newNTB = new NetworkToBank(log, null);
		newNTB.closeConnection();
	}
	
	@Test
	public void testSendMessage(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		MockSimulation newSimulation = new MockSimulation(newATM);
		Log log = newATM.getLog();
		NetworkToBank newNTB = new NetworkToBank(log, null);
		
		Money testMoney = new Money(100);
		Card testCard = new Card(1);
		Message testMessage = new Message(1,testCard, 1, 1, 1, 1, testMoney);
		Balances bal = new Balances();
		
		Status result = newNTB.sendMessage(testMessage, bal);
		assertEquals("testSuccess", result.toString());
		
	}
	
	
}
