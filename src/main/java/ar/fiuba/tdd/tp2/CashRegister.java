package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.exceptions.UserDoesNotExist;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CashRegister implements CashRegisterInterface {

	private CashRegisterState state;
	private Users users;
    private Offers offers;
    private Rules rules;
    private List<User> usersList;
    private Double totalCash;
    private Sale currentSale;
    private PurchaseSummaryTicket purchaseSummaryTicket;
    private Adapter adapter;
	
    public CashRegister(String usersFile, String offersFile, String rulesFile) throws IOException, ParseException {
        this.state = new Close();
        this.users = new Users(usersFile);
        this.offers = new Offers(offersFile);
        this.rules = new Rules(rulesFile);
        this.totalCash = 0.0;
        this.usersList = new ArrayList<>();
        this.adapter = new Adapter(this.rules, this.offers);
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
            //
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
        this.currentSale = this.state.initSale(this.adapter);
    }

    public void finishSale(String method, String bank) {
        this.state.canFinishSale();
        this.currentSale.finishSale(method, bank);
        this.totalCash += this.currentSale.getTotal();
        double discount = this.currentSale.getTotalDiscount();
        ControlTicket.getInstance().logShipment(this.totalCash, discount, "CASH");
    }

    public void addItemToCurrentSale(String item) {
        this.state.canAddItemToCurrentSale();
        this.currentSale.addItem(item);
    }

    @Override
    public String getControlTicket() {
        return ControlTicket.getInstance().getLoggedData();
    }

    @Override
    public String getSummaryTicket() {
        if(this.currentSale == null) {
            return "Sorry!: We do not have a summary ticket";
        }
        return this.currentSale.getSummaryTicket();
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
