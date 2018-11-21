package ar.fiuba.tdd.tp2.offer_validator_client;

public class ProcessSale {
    String state;
    Sale sale;

    public ProcessSale(String state, Sale sale) {
        this.state = state;
        this.sale = sale;
    }

    public Sale getSale() {
        return sale;
    }

    public String getState() {
        return state;
    }
}
