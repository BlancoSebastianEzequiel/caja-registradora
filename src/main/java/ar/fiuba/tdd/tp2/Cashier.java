package ar.fiuba.tdd.tp2;

public class Cashier extends Role {

	@Override
	public void canOpen() {
		throw new InvalidOperationException();
	}

	@Override
	public void canClose() {
		throw new InvalidOperationException();
	}

	@Override
	public void canLogIn() {}

	@Override
	public void canLogOut() {}
}
