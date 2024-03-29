package ar.fiuba.tdd.tp2.exceptions;

public class CanNotCloseClosedCashRegister extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Can not close a closed cash register";
    }
}
