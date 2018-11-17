package ar.fiuba.tdd.tp2;

public final class Close extends CashRegisterState {

	@Override
	public void open(CashRegister aCashRegister, User user) {
		// TODO Auto-generated method stub
		user.canOpen();
		aCashRegister.changeState(new Open());
	}

	@Override
	public void close(CashRegister aCashRegister, User user) {
		// TODO Auto-generated method stub
		throw new InvalidCashRegisterOperationException();
	}

	@Override
	public void login(User anUser) {
		throw new InvalidCashRegisterOperationException();
	}

	@Override
	public void logout(User anUser) {
		throw new InvalidCashRegisterOperationException();
	}

	@Override
	public Boolean isOpen() {
		return false;
	}

	@Override
	public Boolean isUserSignedIn() {
		return false;
	}
}
