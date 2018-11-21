package ar.fiuba.tdd.tp2.offer_validator_client;

public class Rule {
    String code, description, type, field, value;

    public Rule(String code, String description, String type, String field, String value) {
        this.code = code;
        this.description = description;
        this.type = type;
        this.field = field;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getField() {
        return field;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
