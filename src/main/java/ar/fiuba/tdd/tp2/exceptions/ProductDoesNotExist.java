package ar.fiuba.tdd.tp2.exceptions;

public class ProductDoesNotExist  extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Product does not exist";
    }
}
