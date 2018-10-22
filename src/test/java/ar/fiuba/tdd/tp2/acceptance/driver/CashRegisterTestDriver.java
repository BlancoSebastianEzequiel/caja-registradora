package ar.fiuba.tdd.tp2.acceptance.driver;

public interface CashRegisterTestDriver {


    /**
     * Open the cash register
     * Only a Valid Supervisor can open it
     * @param username
     * @param password
     */
    void open(String username, String password);

    Boolean isOpen();

    Boolean isUserSignedIn();

    void close();

    void login(String username, String password);

    void logout();

    void initSale();

    void addItemToCurrentSale(String item);

}
