package ar.fiuba.tdd.tp2.offer_validator_client;

public class Offer {
    String description, code;
    OfferRule rule;
    Discount discount;

    public Offer(String description, String code, OfferRule rule, Discount discount) {
        this.description = description;
        this.code = code;
        this.rule = rule;
        this.discount = discount;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Discount getDiscount() {
        return discount;
    }

    public OfferRule getRule() {
        return rule;
    }
}
