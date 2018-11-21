package ar.fiuba.tdd.tp2.offer_validator_client;

import java.util.List;

public class OfferRule {
    String type, code;
    List<String> rules;

    public OfferRule(String type, String code, List<String> rules) {
        this.type = type;
        this.code = code;
        this.rules = rules;
    }

    public String getType() {
        return type;
    }

    public String getCode() {
        return code;
    }

    public List<String> getRules() {
        return rules;
    }
}
