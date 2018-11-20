package ar.fiuba.tdd.tp2.exceptions;

public class CanNotOpenOpenedCashRegister extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public String print() {
        return "Can not open a opened cash register";
    }
}
