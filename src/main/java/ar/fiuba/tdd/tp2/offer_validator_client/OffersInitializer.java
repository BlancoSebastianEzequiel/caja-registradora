package ar.fiuba.tdd.tp2.offer_validator_client;

import java.util.List;

public class OffersInitializer {
    List<Offer> offers;
    List<Rule> rules;

    public OffersInitializer(List<Offer> offers, List<Rule> rules) {
        this.offers = offers;
        this.rules = rules;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public List<Rule> getRules() {
        return rules;
    }
}
