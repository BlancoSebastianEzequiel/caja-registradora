package ar.fiuba.tdd.tp2.offer_validator_client;

public class Discount {
    String type;
    Integer value;

    public Discount(String type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public Integer getValue() {
        return value;
    }
}