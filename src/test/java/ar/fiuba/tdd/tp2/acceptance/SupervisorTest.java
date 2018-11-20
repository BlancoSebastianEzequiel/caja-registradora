package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.CashRegisterInterface;
import ar.fiuba.tdd.tp2.InvalidCashRegisterOperationException;
import ar.fiuba.tdd.tp2.exceptions.CanNotCloseClosedCashRegister;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SupervisorTest {

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

    @Test
    public void userOpenCashRegisterWithValidSupervisorRole() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        cashRegister.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", cashRegister.isOpen());
    }

    @Test
    public void userOpenCashRegisterWithInvalidSupervisorUser() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "badpass";
        cashRegister.open(supervisorUsername, supervisorPassword);
        assertFalse("La caja esta abierta a pesar del password inválido", cashRegister.isOpen());
    }

    @Test
    public void supervisorCloseAnOpenedCashRegister() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        cashRegister.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", cashRegister.isOpen());
        cashRegister.close(supervisorUsername, supervisorPassword);
        assertFalse("La caja no pudo cerrarse", cashRegister.isOpen());
    }

    @Test(expected = CanNotCloseClosedCashRegister.class)
    public void supervisorInitSaleInCashRegister() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        cashRegister.close(supervisorUsername, supervisorPassword);
    }

}
