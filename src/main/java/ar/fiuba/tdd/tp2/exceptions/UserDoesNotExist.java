package ar.fiuba.tdd.tp2.exceptions;

public class UserDoesNotExist extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "User does not exist";
    }
}
