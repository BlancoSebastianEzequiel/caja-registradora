package ar.fiuba.tdd.tp2.offer_validator_client;

import java.util.List;

public class Sale {
    List<Product> products;
    Payment payment;
    PurchaseDate purchase_date;

    public Sale(List<Product> products, Payment payment, PurchaseDate purchase_date) {
        this.products = products;
        this.payment = payment;
        this.purchase_date = purchase_date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Payment getPayment() {
        return payment;
    }

    public PurchaseDate getPurchase_date() {
        return purchase_date;
    }
}
