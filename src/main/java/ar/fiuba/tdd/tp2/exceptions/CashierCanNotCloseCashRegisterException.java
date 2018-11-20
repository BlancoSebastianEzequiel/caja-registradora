package ar.fiuba.tdd.tp2.exceptions;

public class CashierCanNotCloseCashRegisterException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public String print() {
        return "A cashier can not close a cash register";
    }
}
