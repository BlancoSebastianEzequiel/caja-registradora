package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.CashRegisterInterface;
import ar.fiuba.tdd.tp2.InvalidCashRegisterOperationException;
import ar.fiuba.tdd.tp2.exceptions.CashierCanNotOpenCashRegisterException;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class OperatorTest {

    private CashRegisterInterface cashRegister;

    @Before
    public void setUp() throws IOException, ParseException {
        this.cashRegister = new CashRegister("users.json", "offers.json", "rules.json");
    }

    @After
    public void tearDown() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        if(cashRegister.isUserSignedIn())
            cashRegister.logout();
        if(cashRegister.isOpen())
            cashRegister.close(supervisorUsername, supervisorPassword);
    }

    /**
     * An operator can login in an open cash register
     */
    @Test
    public void operatorDoLoginInCashRegister() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        cashRegister.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", cashRegister.isOpen());
        String username = "cajero";
        String password = "123456";
        cashRegister.login(username, password);
        assertTrue("La caja no esta logueada por el operador", cashRegister.isUserSignedIn());
    }


    /**
     * An Operator cant open the cash register
     */
    @Test(expected = CashierCanNotOpenCashRegisterException.class)
    public void operatorCantOpenACashRegister() {
        String username = "operator";
        String password = "123456";
        cashRegister.open(username, password);
    }

    /**
     * An operator cant login in a closed cash register
     */
    @Test(expected = InvalidCashRegisterOperationException.class)
    public void operatorCantLoginInAClosedCashRegister() {
        String username = "operator";
        String password = "123456";
        cashRegister.login(username, password);
    }

}
