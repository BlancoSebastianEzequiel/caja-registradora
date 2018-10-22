package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.acceptance.driver.CashRegisterTestDriver;
import ar.fiuba.tdd.tp2.acceptance.driver.InvalidOperationException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SupervisorTest {

    private CashRegisterTestDriver testDriver;

    @Before
    public void setUp() {
        throw new RuntimeException("not implemented yet!");
    }

    @Test
    public void openCashRegisterWithValidSupervisorRole() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        testDriver.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", testDriver.isOpen());
    }

    @Test(expected = InvalidOperationException.class)
    public void openCashRegisterWithInvalidSupervisorRole() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "badpass";
        testDriver.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", testDriver.isOpen());
    }


    @Test
    public void closeCashRegister() {
        testDriver.close();
        assertFalse("La caja no pudo cerrarse", testDriver.isOpen());
    }

    @Test
    public void loginOperatorInCashRegister() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        testDriver.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", testDriver.isOpen());
        String username = "cajero";
        String password = "123456";
        testDriver.login(username, supervisorUsername);
        assertTrue("La caja no esta logeuada por el operador", testDriver.isUserSignedIn());
    }

}
