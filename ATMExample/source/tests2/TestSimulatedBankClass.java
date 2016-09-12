package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Balances;
import banking.Card;
import banking.Message;
import banking.Money;
import banking.Status;
import simulation.SimulatedBank;

public class TestSimulatedBankClass {
	
	@Test
	public void testHandlMessage_InvalidCard(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(0);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,1,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid card", status.toString());
	}
	
	@Test
	public void testHandlMessage_InvalidCard_PINLength(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(12);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,1,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid card", status.toString());
	}
	
	@Test
	public void testHandlMessage_InvalidPin(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,1,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("INVALID PIN", status.toString());
	}
	
	
	@Test
	public void testHandlMessage_Withdrawal(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("SUCCESS", status.toString());
		
	}
	
	@Test
	public void testHandlMessage_InitiateDeposit(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(1, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("SUCCESS", status.toString());
		
	}

	@Test
	public void testHandlMessage_CompleteDeposit(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(2, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("SUCCESS", status.toString());
		
	}
	
	@Test
	public void testHandlMessage_Transfer(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(3, card,42,1,1,0,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("SUCCESS", status.toString());
		
	}
	
	@Test
	public void testHandlMessage_Inquiry(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(4, card,42,1,1,0,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("SUCCESS", status.toString());
		
	}
	
	@Test
	public void testHandlMessage_Null(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(5, card,42,1,1,0,money);
		Status status = bank.handleMessage(message,bal);
		assertNull(status);
		
	}
	
	@Test
	public void testWithdrawal_InvalidAccount(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,42,1,2,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid account type", status.toString());
		
	}
	
	@Test
	public void testWithdrawal_Limit(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(1000);
		Balances bal = new Balances();
		Message message = new Message(0, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Daily withdrawal limit exceeded", status.toString());
		
	}
	
	@Test
	public void testWithdrawal_InsufficientBalance(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(200);
		Balances bal = new Balances();
		Message message = new Message(0, card,42,1,0,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Insufficient available balance", status.toString());
		
	}
	
	@Test
	public void testInitiateDeposit_InvalidAccount(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(1, card,42,1,1,2,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid account type", status.toString());
		
	}
	
	@Test
	public void testCompleteDeposit_InvalidAccount(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(2, card,42,1,1,2,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid account type", status.toString());
		
	}
	
	@Test
	public void testTransfer_InvalidFromAccount(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(3, card,42,1,2,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid from account type", status.toString());
		
	}
	
	@Test
	public void testTransfer_InvalidToAccount(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(3, card,42,1,1,2,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid to account type", status.toString());
		
	}
	
	@Test
	public void testTransfer_SameAccounts(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(3, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Can't transfer money from\n" 
		+"an account to itself", status.toString());
		
	}
	
	@Test
	public void testTransfer_InsufficientBalance(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(200);
		Balances bal = new Balances();
		Message message = new Message(3, card,42,1,0,1,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Insufficient available balance", status.toString());
		
	}
	
	@Test
	public void testInquiry_InvalidAccount(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(4, card,42,1,2,2,money);
		Status status = bank.handleMessage(message,bal);
		assertEquals("FAILURE Invalid account type", status.toString());
		
	}

	@Test
	public void testSuccess_isInvalidPin(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertFalse(status.isInvalidPIN());
		
	}
	
	@Test
	public void testSuccess_getMessage(){
		SimulatedBank bank = new SimulatedBank();
		Card card = new Card(1);
		Money money = new Money(100);
		Balances bal = new Balances();
		Message message = new Message(0, card,42,1,1,1,money);
		Status status = bank.handleMessage(message,bal);
		assertNull(status.getMessage());
		
	}
}
