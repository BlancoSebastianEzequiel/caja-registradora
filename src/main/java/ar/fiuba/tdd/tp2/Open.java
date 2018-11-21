package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.exceptions.CanNotOpenOpenedCashRegister;

import java.util.List;

public final class Open extends CashRegisterState {
	
	@Override
	public void open(CashRegister aCashRegister, User user) {
		throw new CanNotOpenOpenedCashRegister();
	}

	@Override
	public void close(CashRegister aCashRegister, User user) {
		user.canClose();
		aCashRegister.changeState(new Close());
	}

	@Override
	public User login(String username, String password, Users users) {
		return users.getUser(username, password);
	}

	@Override
	public Boolean isOpen() {
		return true;
	}

	@Override
	public Boolean isUserSignedIn(List<User> usersList) {
		for (User anUser: usersList) {
			if (anUser.IsUserLoggedIn()) {
				return true;
			}
		}
		return false;
	}

	public Sale initSale() {
		return new Sale();
	}

	public void addItemToCurrentSale(Sale sale, String item) {
		sale.addItem(item);
	}

}
