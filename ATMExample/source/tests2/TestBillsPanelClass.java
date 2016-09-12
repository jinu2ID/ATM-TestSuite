package tests2;

import static org.junit.Assert.*;

import java.awt.Panel;

import org.junit.Test;

import simulation.BillsPanel;

public class TestBillsPanelClass {
	
	@Test
	public void testConstructor(){
		BillsPanel panel = new BillsPanel();
		assertNotNull(panel);
	}
	
	@Test
	public void testReadBills(){
		BillsPanel panel = new BillsPanel();
		panel.setBills("5");
		int bills = panel.readBills();
		assertEquals(5, bills);
	}
	
}
