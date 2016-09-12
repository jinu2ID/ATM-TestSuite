package tests2;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import java.util.Enumeration;

import atm.ATM;
import atm.physical.ReceiptPrinter;
import atm.transaction.Deposit;
import banking.Balances;
import banking.Card;
import banking.Receipt;
import simulation.Simulation;

public class TestReceiptClass {

	@Test
	public void testConstructor(){
		
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		ReceiptPrinter printer = newATM.getReceiptPrinter();
		Deposit testTransaction = new Deposit(newATM, null, null, 0);
		
		Receipt receipt = new Receipt(newATM, new Card(1234), testTransaction, new Balances()){ 
		{}};
		
		assertNotNull(receipt);
	}
	
	@Test
	public void testGetLines(){
		
		ATM newATM = new ATM(1,"testPlace","testBank",null);
		Simulation newSimulation = new Simulation(newATM);
		ReceiptPrinter printer = newATM.getReceiptPrinter();
		Deposit testTransaction = new Deposit(newATM, null, null, 0);
		
		Receipt receipt = new Receipt(newATM, new Card(1234), testTransaction, new Balances()){ 
		{}};
		
		Enumeration lines = receipt.getLines();
	}
}
