package ar.fiuba.tdd.tp2.offer_validator_client;

public class SaleResult {
    String description, offer_code;
    double discount;

    public SaleResult(String description, String offer_code, double discount) {
        this.description = description;
        this.offer_code = offer_code;
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public double getDiscount() {
        return discount;
    }

    public String getOffer_code() {
        return offer_code;
    }
}
