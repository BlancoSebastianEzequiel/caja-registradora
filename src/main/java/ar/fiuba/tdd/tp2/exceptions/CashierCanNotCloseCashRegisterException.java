package ar.fiuba.tdd.tp2.exceptions;

public class CashierCanNotCloseCashRegisterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "A cashier can not close a cash register";
    }
}
