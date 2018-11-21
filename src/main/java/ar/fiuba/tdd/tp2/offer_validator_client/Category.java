package ar.fiuba.tdd.tp2.offer_validator_client;

public class Category {
    String code, name;

    public Category(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
