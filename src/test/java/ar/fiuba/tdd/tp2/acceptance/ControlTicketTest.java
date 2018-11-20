package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.Cashier;
import ar.fiuba.tdd.tp2.ControlTicket;
import ar.fiuba.tdd.tp2.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ControlTicketTest {

    @Before
    public void setUp() {
        ControlTicket.getInstance().reset();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void logOpenedCashRegister() {
        ControlTicket.getInstance().openCashRegister();
        String msg = ControlTicket.getInstance().getLoggedData();
        assertTrue("Failed", msg.contains("Open cash register at "));
    }

    @Test
    public void logCloseCashRegister() {
        User user = new User("cashier", "123456", new Cashier());
        ControlTicket.getInstance().closeCashRegister(user);
        String msg = ControlTicket.getInstance().getLoggedData();
        String expected = "operated by cashier\nClose cash register at ";
        assertTrue("Failed", msg.contains(expected));
    }
}
