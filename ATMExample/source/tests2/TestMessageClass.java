package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Card;
import banking.Message;
import banking.Money;

public class TestMessageClass {
	
	@Test
	public void testConstructor(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(1, card,1,1,1,1,money);
		
		assertNotNull(message);
	}
	
	@Test
	public void testToString_Withdrawal(){
		
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(0, card,1,1,1,1,money);
		
		String result = message.toString();
		
		assertEquals("WITHDRAW CARD# 1234 TRANS# 1 FROM  1 TO  1 $100.00",result);
	}

	@Test
	public void testToString_InitDeposit(){
		
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(1, card,1,1,1,1,money);
		
		String result = message.toString();
		
		assertEquals("INIT_DEP CARD# 1234 TRANS# 1 FROM  1 TO  1 $100.00",result);
	}
	
	@Test
	public void testToString_CompDeposit(){
		
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(2, card,1,1,1,1,money);
		
		String result = message.toString();
		
		assertEquals("COMP_DEP CARD# 1234 TRANS# 1 FROM  1 TO  1 $100.00",result);
	}
	
	@Test
	public void testToString_Transfer(){
		
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(3, card,1,1,1,1,money);
		
		String result = message.toString();
		
		assertEquals("TRANSFER CARD# 1234 TRANS# 1 FROM  1 TO  1 $100.00",result);
	}
	
	@Test
	public void testToString_Inquiry(){
		
		Card card = new Card(1234);
		Money money = new Money(0);
		Message message = new Message(4, card,1,1,1,1,money);
		
		String result = message.toString();
		
		assertEquals("INQUIRY  CARD# 1234 TRANS# 1 FROM  1 TO  1 NO AMOUNT",result);
	}
	
	@Test
	public void testToString_NoFromToAmount(){
		
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(1, card,1,1,-1,-1,money);
		
		String result = message.toString();
		
		assertEquals("INIT_DEP CARD# 1234 TRANS# 1 NO FROM NO TO $100.00",result);
	}
	
	@Test
	public void testSetPIN(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(1, card,1,1,1,1,money);
		
		message.setPIN(2);
		assertEquals(2, message.getPIN());
	}
	
	@Test
	public void testGetMessageCode(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(4, card,1,1,1,1,money);
		
		assertEquals(4, message.getMessageCode());
	}
	
	@Test
	public void testGetCard(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(4, card,1,1,1,1,money);
		
		assertEquals(1234, message.getCard().getNumber());
	}
	
	@Test
	public void testGetSerialNumber(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(4, card,1,9,1,1,money);
		
		assertEquals(9, message.getSerialNumber());
	}
	
	@Test
	public void testGetFromAccount(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(4, card,1,1,2,1,money);
		
		assertEquals(2, message.getFromAccount());
	}
	
	@Test
	public void testGetToAccount(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(4, card,1,1,1,2,money);
		
		assertEquals(2, message.getToAccount());
	}
	
	@Test
	public void testGetAmount(){
		Card card = new Card(1234);
		Money money = new Money(100);
		Message message = new Message(4, card,1,1,2,1,money);
		
		assertEquals("$100.00", message.getAmount().toString());
	}
	
}
