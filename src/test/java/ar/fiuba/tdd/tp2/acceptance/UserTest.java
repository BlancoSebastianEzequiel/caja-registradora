package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.*;
import ar.fiuba.tdd.tp2.exceptions.CashierCanNotCloseCashRegisterException;
import ar.fiuba.tdd.tp2.exceptions.CashierCanNotOpenCashRegisterException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;


public class UserTest {
	private User supervisor;
	private User cashier;

    @Before
    public void setUp() {
    	this.supervisor = new User("supervisor", "123456", new Supervisor());
    	this.cashier = new User("cashier", "023456", new Cashier());
    }

    @After
    public void tearDown() {
    }

    /**
     * An operator is not able to open a cash register
     */
    @Test(expected = CashierCanNotOpenCashRegisterException.class)
    public void operatorCanOpenACashRegister() {
        this.cashier.canOpen();
    }

    /**
     * An operator is not able to close a cash register
     */
    @Test(expected = CashierCanNotCloseCashRegisterException.class)
    public void operatorCannotCloseACashRegister() {
        this.cashier.canClose();
    }
    
    /**
     * A supervisor is able to open a cash register
     */
    @Test
    public void supervisorCanOpenACashRegister() {
        this.supervisor.canOpen();
    }

    /**
     * A supervisor is able to close a cash register
     */
    @Test
    public void supervisorCanCloseACashRegister() {
        this.supervisor.canClose();
    }
}
