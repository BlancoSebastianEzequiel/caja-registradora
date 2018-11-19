package ar.fiuba.tdd.tp2;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CashRegister implements CashRegisterInterface {

	private CashRegisterState state;
	private Users users;
    private JsonConverter offers;
    private JsonConverter rules;
    private User user;
    private Integer totalCash;
	
    public CashRegister(String usersFile, String offersFile, String rulesFile) throws IOException, ParseException {
        this.state = new Close();
        this.users = new Users(usersFile);
        this.offers = new JsonConverter(offersFile);
        this.rules = new JsonConverter(rulesFile);
        this.totalCash = 0;
    }
    
    public void changeState(CashRegisterState newState) {
        this.state = newState;
    }

    public void open(String username, String password) {
        ControlTicket.getInstance().openCashRegister();
        this.state.open(this, this.users.getUser(username, password));
    }

    public Boolean isOpen() {
        return this.state.isOpen();
    }

    public Boolean isUserSignedIn() {
        return this.state.isUserSignedIn();
    }

    public void close(String username, String password) {
        ControlTicket.getInstance().logCashRegisterTotalCash(this.totalCash);
        ControlTicket.getInstance().closeCashRegister(this.user);
        this.state.close(this, this.users.getUser(username, password));

    }
    public void login(String username, String password) {
        this.user = this.users.getUser(username, password);
        this.state.login(user);
    }

    public void logout() {
        this.state.logout(this.user);
    }

    public void initSale() {}

    public void finishSale() {
        // TODO: implementar issue #5 y #6 donde se crea la compra para obtener estos datos
        ControlTicket.getInstance().logShipment(null, null, null);
    }

    public void addItemToCurrentSale(String item) {}
}
