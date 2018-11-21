//package ar.fiuba.tdd.tp2.acceptance;
//
//import ar.fiuba.tdd.tp2.acceptance.driver.CashRegisterTestDriver;
//import ar.fiuba.tdd.tp2.acceptance.driver.InvalidOperationException;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class SaleTest {
//    private CashRegisterTestDriver testDriver;
//
//    @Before
//    public void setUp() {
//        throw new RuntimeException("not implemented yet!");
//    }
//
//    @After
//    public void tearDown() {
//        String supervisorUsername = "supervisor";
//        String supervisorPassword = "123456";
//        if(testDriver.isUserSignedIn())
//            testDriver.logout();
//        if(testDriver.isOpen())
//            testDriver.close(supervisorUsername, supervisorPassword);
//    }
//
//    @Test(expected = InvalidOperationException.class)
//    public void addItemClosedCashRegisterTest() {
//        testDriver.addItemToCurrentSale("test_item");
//    }
//
//    @Test
//    public void completeSaleOpenCashRegisterTest() {
//        String supervisorUsername = "supervisor";
//        String supervisorPassword = "123456";
//        String username = "operator";
//        String password = "123456";
//        testDriver.open(supervisorUsername, supervisorPassword);
//        testDriver.login(username, password);
//
//        testDriver.initSale();
//
//        testDriver.addItemToCurrentSale("test_item");
//        testDriver.addItemToCurrentSale("test_item_2");
//        testDriver.addItemToCurrentSale("test_item_3");
//        testDriver.addItemToCurrentSale("test_item_4");
//        testDriver.addItemToCurrentSale("test_item_1");
//
//        testDriver.finishSale();
//    }
//
//    @Test(expected = InvalidOperationException.class)
//    public void operatorInitSaleInClosedCashRegisterTest() {
//        String supervisorUsername = "supervisor";
//        String supervisorPassword = "123456";
//        String username = "operator";
//        String password = "123456";
//        testDriver.login(username, password);
//        testDriver.open(supervisorUsername, supervisorPassword);
//        assertFalse(testDriver.isUserSignedIn());
//        testDriver.login(username, password);
//        assertTrue(testDriver.isUserSignedIn());
//        testDriver.close(supervisorUsername, supervisorPassword);
//
//        testDriver.initSale();
//    }
//
//    @Test
//    public void operatorInitSaleInOpenCashRegisterTest() {
//        String supervisorUsername = "supervisor";
//        String supervisorPassword = "123456";
//        String username = "operator";
//        String password = "123456";
//        testDriver.login(username, password);
//        testDriver.open(supervisorUsername, supervisorPassword);
//        assertFalse(testDriver.isUserSignedIn());
//        testDriver.login(username, password);
//        assertTrue(testDriver.isUserSignedIn());
//
//        testDriver.initSale();
//    }
//
//
//}
