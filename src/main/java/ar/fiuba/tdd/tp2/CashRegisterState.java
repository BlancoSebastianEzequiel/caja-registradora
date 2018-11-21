package ar.fiuba.tdd.tp2;

import java.util.List;

public abstract class CashRegisterState {
	public abstract void open(CashRegister aCashRegister, User user);
	public abstract void close(CashRegister aCashRegister, User user);
	public abstract User login(String username, String password, Users users);
	public abstract Boolean isOpen();
	public abstract Boolean isUserSignedIn(List<User> usersList);
	public abstract Sale initSale(Adapter adapter);
	public abstract void canFinishSale();
	public abstract void canAddItemToCurrentSale();
}
