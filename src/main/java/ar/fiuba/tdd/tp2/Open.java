package ar.fiuba.tdd.tp2;

public final class Open extends CashRegisterState {
	
	private Boolean isSignedIn;
	
	@Override
	public void open(CashRegister aCashRegister, User user) {
		// TODO Auto-generated method stub
		throw new InvalidCashRegisterOperationException();
	}

	@Override
	public void close(CashRegister aCashRegister, User user) {
		// TODO Auto-generated method stub
		user.canClose();
		aCashRegister.changeState(this);
	}

	@Override
	public void login(User anUser) {
		anUser.canLogIn();
		// TODO Auto-generated method stub
	}

	@Override
	public void logout(User anUser) {
		anUser.canLogOut();
		// TODO Auto-generated method stub
	}

	@Override
	public Boolean isOpen() {
		return true;
	}

	@Override
	public Boolean isUserSignedIn() {
		return this.isSignedIn;
	}

}
