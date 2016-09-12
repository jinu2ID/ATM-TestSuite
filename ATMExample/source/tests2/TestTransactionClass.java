package tests2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import atm.ATM;
import atm.transaction.Deposit;
import atm.transaction.Inquiry;
import atm.transaction.Transfer;
import atm.transaction.Withdrawal;

public class TestTransactionClass {

	@Test
	public void testDepositConstructor(){
		
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Deposit deposit = new Deposit(newATM,null,null,1);
		
		assertNotNull(deposit);
	}
	
	@Test
	public void testInquiryConstructor(){
		
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Inquiry inquiry = new Inquiry(newATM,null,null,1);
		
		assertNotNull(inquiry);
	}
	
	@Test
	public void testTransferConstructor(){
		
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Transfer transfer = new Transfer(newATM,null,null,1);
		
		assertNotNull(transfer);
	}
	
	@Test
	public void testWithdrawalConstructor(){
		
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Withdrawal withdrawal = new Withdrawal(newATM,null,null,1);
		
		assertNotNull(withdrawal);
	}
	
	
}
