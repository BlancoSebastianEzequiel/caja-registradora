package ar.fiuba.tdd.tp2;
import ar.fiuba.tdd.tp2.acceptance.driver.InvalidOperationException;

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
