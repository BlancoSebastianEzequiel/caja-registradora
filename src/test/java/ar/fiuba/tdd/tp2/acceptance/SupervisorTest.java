package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.acceptance.driver.CashRegisterTestDriver;
import ar.fiuba.tdd.tp2.acceptance.driver.InvalidOperationException;
import org.junit.After;
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
        throw new RuntimeException("not implemented yet!, You should implement the driver, build the setup an check all tests!");
    }

    @After
    public void tearDown() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        if(testDriver.isUserSignedIn())
            testDriver.logout();
        if(testDriver.isOpen())
            testDriver.close(supervisorUsername, supervisorPassword);
    }

    @Test
    public void userOpenCashRegisterWithValidSupervisorRole() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        testDriver.open(supervisorUsername, supervisorPassword);
        assertTrue("La caja no esta abierta por el supervisor", testDriver.isOpen());
    }

    @Test
    public void userOpenCashRegisterWithInvalidSupervisorUser() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "badpass";
        testDriver.open(supervisorUsername, supervisorPassword);
        assertFalse("La caja esta abierta a pesar del password inválido", testDriver.isOpen());
    }

    @Test(expected = InvalidOperationException.class)
    public void supervisorInitSaleInCashRegister() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        testDriver.close(supervisorUsername, supervisorPassword);
        assertFalse("La caja no pudo cerrarse", testDriver.isOpen());
    }

}
