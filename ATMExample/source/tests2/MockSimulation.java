package tests2;

import atm.ATM;
import banking.Balances;
import banking.Card;
import banking.Message;
import banking.Status;
import simulation.Simulation;

public class MockSimulation extends Simulation{

	public MockSimulation(ATM atm) {
		super(atm);
		// TODO Auto-generated constructor stub
	}
	
	public Card readCard(){
		return new Card(1234);
	}

	public void ejectCard(){
		
	}
	
	public void retainCard(){
		
	}
	
	public void dispenseCash(){
		
	}
	
	public void clearDisplay(){
	}
	
	public void display(String message){
	}
	
	public String readInput(int mode, int maxValue){
		return null;
	}
	
	public boolean acceptEnvelope(){
		if (envelopeInserted)
			return true;
		else
			return false;
	}
	
	public Status sendMessage(Message message, Balances balance){
		return new testSuccess();
	}
	
	public class testSuccess extends Status{

		public String toString(){
			return "testSuccess";
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
		
	}
	
	public boolean envelopeInserted; 
}
