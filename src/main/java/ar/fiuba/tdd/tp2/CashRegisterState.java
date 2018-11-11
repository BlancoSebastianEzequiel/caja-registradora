package ar.fiuba.tdd.tp2;

public abstract class CashRegisterState {
	public abstract void open(CashRegister aCashRegister, User user);
	public abstract void close(CashRegister aCashRegister, User user);
	public abstract void login(User anUser);
	public abstract void logout(User anUser);
	public abstract Boolean isOpen();
	public abstract Boolean isUserSignedIn();
}
