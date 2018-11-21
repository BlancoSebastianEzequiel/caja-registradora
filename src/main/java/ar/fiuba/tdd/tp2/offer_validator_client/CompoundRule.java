package ar.fiuba.tdd.tp2.offer_validator_client;

public class CompoundRule extends Rule {
    private String type;
    private String code;
    private Object rules;

    public CompoundRule(String type, String code, Object rules) {
        this.type = type;
        this.code = code;
        this.rules = rules;
    }

    public String getType() {
        return this.type;
    }

    public String getCode() {
        return this.code;
    }

    public Object getRules() {
        return this.rules;
    }
}
