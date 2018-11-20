package ar.fiuba.tdd.tp2;

public class Supervisor extends Role {

	@Override
	public void canOpen() {}

	@Override
	public void canClose() {}

	public Boolean isCashier() {
		return false;
	}
}
