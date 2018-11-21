package ar.fiuba.tdd.tp2;

public abstract class Role {
	private WorkingHours workingHours;
	public abstract void canOpen();
	public abstract void canClose();
	public abstract Boolean isCashier();
}
