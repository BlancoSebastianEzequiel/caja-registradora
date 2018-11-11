package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.acceptance.driver.InvalidOperationException;

public class Supervisor extends Role {

	@Override
	public void canOpen() {
	}
	@Override
	public void canClose() {
	}
	@Override
	public void canLogIn() {
		throw new InvalidOperationException();
	}
	@Override
	public void canLogOut() {
		throw new InvalidOperationException();
	}
}
