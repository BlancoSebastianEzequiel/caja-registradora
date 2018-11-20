package ar.fiuba.tdd.tp2;
public interface CashRegisterInterface {
    /**
     * Open the cash register
     * Only a Valid Supervisor can open it
     * @param username
     * @param password
     */
    void open(String username, String password);
    Boolean isOpen();
    Boolean isUserSignedIn();
    void close(String username, String password);
    void login(String username, String password);
    void logout();
    void initSale();
    void finishSale();
    void addItemToCurrentSale(String item);
    String getControlTicket();
    String getSummaryTicket();
}
