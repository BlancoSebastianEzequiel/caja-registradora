package ar.fiuba.tdd.tp2.offer_validator_client;

public class AtomicRule extends Rule {
    String code, description, type, field;
    Object value;

    public AtomicRule(String code, String description, String type, String field, Object value) {
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

    public Object getValue() {
        return value;
    }
}
