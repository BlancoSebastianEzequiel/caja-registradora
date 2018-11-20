package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.User;
import ar.fiuba.tdd.tp2.Cashier;
import ar.fiuba.tdd.tp2.Supervisor;
import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.CashRegisterState;
import ar.fiuba.tdd.tp2.Open;
import ar.fiuba.tdd.tp2.Close;
import ar.fiuba.tdd.tp2.exceptions.CanNotCloseClosedCashRegister;
import ar.fiuba.tdd.tp2.exceptions.CanNotOpenOpenedCashRegister;
import ar.fiuba.tdd.tp2.exceptions.CashierCanNotCloseCashRegisterException;
import ar.fiuba.tdd.tp2.exceptions.CashierCanNotOpenCashRegisterException;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

import java.io.IOException;


public class CashRegisterStateTest {
	private CashRegisterState open;
	private CashRegisterState close;
	private User cashier;
	private User supervisor;
	private CashRegister cashRegister; 

    @Before
    public void setUp() throws IOException, ParseException {
    	this.cashRegister = new CashRegister("users.json", "offers.json", "rules.json");
    	this.open = new Open();
    	this.close = new Close();
    	this.supervisor = new User("supervisor", "123456", new Supervisor());
    	this.cashier = new User("cashier", "023456", new Cashier());
    }

    @After
    public void tearDown() {
    }

    @Test(expected = CanNotOpenOpenedCashRegister.class)
    public void cannotOpenAnOpenedCashRegister() {
        this.open.open(this.cashRegister, this.supervisor);
    }

    @Test(expected = CanNotCloseClosedCashRegister.class)
    public void cannotCloseAClosedCashRegister() {
        this.close.close(this.cashRegister, this.supervisor);
    }
    
    /**
     * A supervisor is able to open a cash register
     */
    @Test
    public void supervisorCanOpenACashRegister() {
        this.close.open(this.cashRegister, this.supervisor);
    }

    /**
     * A supervisor is able to close a cash register
     */
    @Test
    public void supervisorCanCloseACashRegister() {
    	this.open.close(this.cashRegister, this.supervisor);
    }
    
    /**
     * A cashier is not able to close a cash register
     */
    @Test(expected = CashierCanNotCloseCashRegisterException.class)
    public void cashierCannotCloseACashRegister() {
    	this.open.close(this.cashRegister, this.cashier);
    }
    
    /**
     * A cashier is not able to open a cash register
     */
    @Test(expected = CashierCanNotOpenCashRegisterException.class)
    public void cashierCannotOpenACashRegister() {
    	this.close.open(this.cashRegister, this.cashier);
    }
}
