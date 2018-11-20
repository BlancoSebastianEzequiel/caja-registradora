package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.exceptions.CanNotCloseClosedCashRegister;
import ar.fiuba.tdd.tp2.exceptions.InvalidCashRegisterOperationException;

import java.util.List;

public final class Close extends CashRegisterState {

	@Override
	public void open(CashRegister aCashRegister, User user) {
		user.canOpen();
		aCashRegister.changeState(new Open());
        ControlTicket.getInstance().openCashRegister();
	}

	@Override
	public void close(CashRegister aCashRegister, User user) {
		throw new CanNotCloseClosedCashRegister();
	}

	@Override
	public User login(String username, String password, Users users) {
		User newUser = users.getUser(username, password);
		if (newUser.isCashier()) {
			throw new InvalidCashRegisterOperationException();
		}
		return newUser;
	}

	@Override
	public Boolean isOpen() {
		return false;
	}

	@Override
	public Boolean isUserSignedIn(List<User> usersList) {
		return false;
	}

	public Sale initSale() {
		throw new InvalidCashRegisterOperationException();
	}

    public void addItemToCurrentSale(Sale sale, String item) {
        throw new InvalidCashRegisterOperationException();
    }
}
