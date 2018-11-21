package ar.fiuba.tdd.tp2.acceptance;

import ar.fiuba.tdd.tp2.CashRegister;
import ar.fiuba.tdd.tp2.CashRegisterInterface;
import ar.fiuba.tdd.tp2.exceptions.InvalidCashRegisterOperationException;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SaleTest {
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

    @Test(expected = InvalidCashRegisterOperationException.class)
    public void addItemClosedCashRegisterTest() {
        cashRegister.addItemToCurrentSale("AAR001");
    }

    @Test
    public void completeSaleOpenCashRegisterTest() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        String username = "operator";
        String password = "123456";
        cashRegister.open(supervisorUsername, supervisorPassword);
        cashRegister.login(username, password);

        cashRegister.initSale();

        cashRegister.addItemToCurrentSale("AAR001");
        cashRegister.addItemToCurrentSale("AAR002");
        cashRegister.addItemToCurrentSale("AAR003");
        cashRegister.addItemToCurrentSale("AAR004");
        cashRegister.addItemToCurrentSale("AAR005");

        cashRegister.finishSale();
    }

    @Test(expected = InvalidCashRegisterOperationException.class)
    public void operatorInitSaleInClosedCashRegisterTest() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        String username = "operator";
        String password = "123456";
        cashRegister.login(username, password);
        cashRegister.open(supervisorUsername, supervisorPassword);
        assertFalse(cashRegister.isUserSignedIn());
        cashRegister.login(username, password);
        assertTrue(cashRegister.isUserSignedIn());
        cashRegister.close(supervisorUsername, supervisorPassword);
        cashRegister.initSale();
    }

    @Test
    public void operatorInitSaleInOpenCashRegisterTest() {
        String supervisorUsername = "supervisor";
        String supervisorPassword = "123456";
        String username = "operator";
        String password = "123456";
        cashRegister.open(supervisorUsername, supervisorPassword);
        assertFalse(cashRegister.isUserSignedIn());
        cashRegister.login(username, password);
        assertTrue(cashRegister.isUserSignedIn());

        cashRegister.initSale();
    }


}
