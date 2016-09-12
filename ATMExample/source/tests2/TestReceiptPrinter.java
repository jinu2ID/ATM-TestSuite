package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import atm.ATM;
import atm.physical.ReceiptPrinter;
import atm.transaction.Deposit;
import banking.AccountInformation;
import banking.Balances;
import banking.Card;
import banking.Receipt;
import simulation.Simulation;

public class TestReceiptPrinter {

	@Test
	public void testConstructor(){
		ReceiptPrinter printer = new ReceiptPrinter();
		assertNotNull(printer);
	}
	
	@Test
	public void printReceipt(){
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		ReceiptPrinter printer = newATM.getReceiptPrinter();
		Deposit testTransaction = new Deposit(newATM, null, null, 0);
		
		Receipt receipt = new Receipt(newATM, new Card(1234), testTransaction, new Balances()){ 
		{
  
                detailsPortion = new String[1];
                detailsPortion[0] = "Test";
            }
		};
            
		printer.printReceipt(receipt);
		boolean empty = newATM.getReceipt().isEmpty();
		assertFalse(empty);
	}
}

