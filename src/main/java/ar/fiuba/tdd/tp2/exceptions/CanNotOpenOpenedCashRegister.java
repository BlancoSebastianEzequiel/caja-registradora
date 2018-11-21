package ar.fiuba.tdd.tp2.exceptions;

public class CanNotOpenOpenedCashRegister extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Can not open an opened cash register";
    }
}
