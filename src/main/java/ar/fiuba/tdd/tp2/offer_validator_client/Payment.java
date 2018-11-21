package ar.fiuba.tdd.tp2.offer_validator_client;

public class Payment {
    String method, bank;

    public  Payment(String method, String bank) {
        this.method = method;
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public String getMethod() {
        return method;
    }
}
