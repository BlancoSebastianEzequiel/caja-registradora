package ar.fiuba.tdd.tp2;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CashRegister implements CashRegisterInterface {

	private CashRegisterState state;
	private Users users;
    private JsonConverter offers;
    private JsonConverter rules;
    private List<User> usersList;
    private Integer totalCash;
    private Sale currentSale;
	
    public CashRegister(String usersFile, String offersFile, String rulesFile) throws IOException, ParseException {
        this.state = new Close();
        this.users = new Users(usersFile);
        this.offers = new JsonConverter(offersFile);
        this.rules = new JsonConverter(rulesFile);
        this.totalCash = 0;
        this.usersList = new ArrayList<>();
    }
    
    void changeState(CashRegisterState newState) {
        this.state = newState;
    }

    public void open(String username, String password) {
        try {
            this.state.open(this, this.users.getUser(username, password));
        } catch (UserDoesNotExist e) {
            //
        }
    }

    public Boolean isOpen() {
        return this.state.isOpen();
    }

    public Boolean isUserSignedIn() {
        return this.state.isUserSignedIn(this.usersList);
    }

    public void close(String username, String password) {
        try {
            ControlTicket.getInstance().logCashRegisterTotalCash(this.totalCash);
            ControlTicket.getInstance().closeCashRegister(this.getCashier());
            this.state.close(this, this.users.getUser(username, password));
        } catch (UserDoesNotExist e) {
            System.out.println("here");
        }

    }
    public void login(String username, String password) {
        this.addUser(this.state.login(username, password, this.users));
    }

    private void addUser(User anUser) {
        if (anUser == null) return;
        anUser.logIn();
        this.usersList.add(anUser);
    }

    public void logout() {
        List<User> toRemove = new ArrayList<>();
        for (User anUser: this.usersList) {
            anUser.logOut();
            toRemove.add(anUser);
        }
        this.usersList.removeAll(toRemove);
    }

    public void initSale() {
        this.currentSale = this.state.initSale();
    }

    public void finishSale() {
        // TODO: implementar issue #5 y #6 donde se crea la compra para obtener estos datos
        ControlTicket.getInstance().logShipment(null, null, null);
    }

    public void addItemToCurrentSale(String item) {
        this.state.addItemToCurrentSale(this.currentSale, item);
    }

    public User getCashier() {
        for (User anUser: this.usersList) {
            if (anUser.isCashier()) {
                return anUser;
            }
        }
        return null;
    }

}
