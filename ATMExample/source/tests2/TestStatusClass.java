package tests2;

import static org.junit.Assert.*;

import org.junit.Test;

import banking.Status;

public class TestStatusClass {
	
	public class testStatus extends Status{

		@Override
		public boolean isSuccess() {
			if (success)
				return true;
			else
				return false;
		}

		@Override
		public boolean isInvalidPIN() {
			if (invalidPIN)
				return true;
			else
				return false;
		}

		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return null;
		}
		
		public boolean success = false;
		public boolean invalidPIN = false;
		
	}
	
	@Test
	public void testConstructor(){
		testStatus status = new testStatus();
		assertNotNull(status);
	}
	
	@Test
	public void testToString_Success(){
		testStatus status = new testStatus();
		status.success = true;
		assertEquals("SUCCESS", status.toString());
	}

	@Test
	public void testToString_InvalidPIN(){
		testStatus status = new testStatus();
		status.invalidPIN = true;
		assertEquals("INVALID PIN", status.toString());
	}
	
	@Test
	public void testToString_Failure(){
		testStatus status = new testStatus();
		assertEquals("FAILURE "+null, status.toString());
	}
}
