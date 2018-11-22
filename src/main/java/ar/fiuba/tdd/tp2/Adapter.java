package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.*;
import ar.fiuba.tdd.tp2.offer_validator_client.CompoundRule;
import ar.fiuba.tdd.tp2.offer_validator_client.Offer;
import ar.fiuba.tdd.tp2.offer_validator_client.Product;
import ar.fiuba.tdd.tp2.offer_validator_client.PurchaseDate;
import ar.fiuba.tdd.tp2.offer_validator_client.AtomicRule;
import ar.fiuba.tdd.tp2.offer_validator_client.Sale;
import ar.fiuba.tdd.tp2.offer_validator_client.Rule;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Adapter {

    private Controller controller;

    public Adapter(ar.fiuba.tdd.tp2.Rules rules, ar.fiuba.tdd.tp2.Offers offers) {
        this.controller = new Controller();
        controller.initializeOffers(new OffersInitializer(this.getOffers(offers), this.getRules(rules)));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<SaleResult> getDiscount(List<ar.fiuba.tdd.tp2.Product> products, ar.fiuba.tdd.tp2.PurchaseDate purchaseDate, String method, String bank) throws InterruptedException {
        controller.processSale(new ProcessSale("hols", this.getSale(products, purchaseDate, method, bank)));
        Thread.sleep(10000);
        if (controller.getResults() == null) {
            throw new RuntimeException("ERROR: could not receive response from clojure");
        }
        return controller.getResults();
    }

    private Sale getSale(List<ar.fiuba.tdd.tp2.Product> products, ar.fiuba.tdd.tp2.PurchaseDate purchaseDate, String method, String bank) {
        Payment payment = new Payment(method, bank);
        return new Sale(this.getProducts(products), payment, this.getPurchaseDate(purchaseDate));
    }

    private List<Product>getProducts(List<ar.fiuba.tdd.tp2.Product> products) {
        List<Product> productClient = new ArrayList<>();
        for (ar.fiuba.tdd.tp2.Product aProduct: products) {
            Brand brand = new Brand(aProduct.getBrandCode(), aProduct.getBrandName());
            Category category = new Category(aProduct.getCategoryCode(), aProduct.getCategoryName());
            productClient.add(new Product(
                    aProduct.getName(),
                    aProduct.getCode(),
                    brand,
                    category,
                    aProduct.getPrice(),
                    aProduct.getIvaPorcentage()
            ));
        }
        return productClient;
    }

    private PurchaseDate getPurchaseDate(ar.fiuba.tdd.tp2.PurchaseDate purchaseDate) {
        return new PurchaseDate(
                purchaseDate.getYear(),
                purchaseDate.getDayNumber(),
                purchaseDate.getWeekNumber(),
                purchaseDate.getMonth(),
                purchaseDate.getWeekDay());
    }

    private List<Offer> getOffers(ar.fiuba.tdd.tp2.Offers offers) {
        List<Offer> offersAdapter = new ArrayList<>();
        for (ar.fiuba.tdd.tp2.Offer anOffer: offers.getOffers()) {
            offersAdapter.add(new Offer(
                    anOffer.getDescription(),
                    anOffer.getCode(),
                    new OfferRule(anOffer.getRuleType(), anOffer.getRuleCode(), anOffer.getRuleRules()),
                    new Discount(anOffer.getDiscountType(), anOffer.getDiscountValue())
            ));
        }
        return offersAdapter;
    }

    private List<Rule> getRules(ar.fiuba.tdd.tp2.Rules rules) {
        List<Rule> rulesAdapter = new ArrayList<>();
        for (ar.fiuba.tdd.tp2.Rule aRule : rules.getRules()) {
            if (aRule.isAtomic()) {
                ar.fiuba.tdd.tp2.AtomicRule atomic = (ar.fiuba.tdd.tp2.AtomicRule) aRule;
                rulesAdapter.add(new AtomicRule(
                        atomic.getCode(),
                        atomic.getDescription(),
                        atomic.getType(),
                        atomic.getField(),
                        atomic.getValue()
                ));
            } else {
                ar.fiuba.tdd.tp2.CompoundRule compound = (ar.fiuba.tdd.tp2.CompoundRule) aRule;
                rulesAdapter.add(new CompoundRule(
                        compound.getType(),
                        compound.getCode(),
                        compound.getRules()
                ));
            }
        }
        return rulesAdapter;
    }
}
