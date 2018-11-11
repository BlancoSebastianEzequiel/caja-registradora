package ar.fiuba.tdd.tp2;

public class CashRegister {

	private CashRegisterState state;
	
    public CashRegister() {
    	this.state = new Close();
    }
    
    public void changeState(CashRegisterState newState) {
    	this.state = newState;
    }
}
