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
//public class OperatorTest {
//
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
//    /**
//     * An operator can login in an open cash register
//     */
//    @Test
//    public void operatorDoLoginInCashRegister() {
//        String supervisorUsername = "operator";
//        String supervisorPassword = "123456";
//        testDriver.open(supervisorUsername, supervisorPassword);
//        assertTrue("La caja no esta abierta por el supervisor", testDriver.isOpen());
//        String username = "cajero";
//        String password = "123456";
//        testDriver.login(username, password);
//        assertTrue("La caja no esta logueada por el operador", testDriver.isUserSignedIn());
//    }
//
//
//    /**
//     * An Operator cant open the cash register
//     */
//    @Test(expected = InvalidOperationException.class)
//    public void operatorCantOpenACashRegister() {
//        String username = "operator";
//        String password = "123456";
//        testDriver.open(username, password);
//    }
//
//    /**
//     * An operator cant login in a closed cash register
//     */
//    @Test(expected = InvalidOperationException.class)
//    public void operatorCantLoginInAClosedCashRegister() {
//        String username = "operator";
//        String password = "123456";
//        testDriver.login(username, password);
//    }
//
//}
