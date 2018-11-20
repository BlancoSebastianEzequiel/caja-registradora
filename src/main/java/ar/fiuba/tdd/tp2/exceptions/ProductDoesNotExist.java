package ar.fiuba.tdd.tp2.exceptions;

public class ProductDoesNotExist  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public String print() {
        return "Product does not exist";
    }
}
