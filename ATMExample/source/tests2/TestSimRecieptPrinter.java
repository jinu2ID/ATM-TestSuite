package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import simulation.SimReceiptPrinter;

public class TestSimRecieptPrinter {

	@Test
	public void testConstructor(){
		SimReceiptPrinter printer = new SimReceiptPrinter();
		assertNotNull(printer);
	}
	
	@Test
	public void testPrintln(){
		SimReceiptPrinter printer = new SimReceiptPrinter();
		printer.println("test");
		assertEquals("test\n", printer.getReceipt());
	}
}
