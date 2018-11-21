package ar.fiuba.tdd.tp2.offer_validator_client;

public class Discount {
    String type;
    String value;

    public Discount(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}