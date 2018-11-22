package ar.fiuba.tdd.tp2.exceptions;

public class InvalidCashRegisterOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Invalid cash register operation";
	}
}
