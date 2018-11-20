package ar.fiuba.tdd.tp2.exceptions;

public class UserDoesNotExist extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public String print() {
        return "User does not exist";
    }
}
