package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.*;
import ar.fiuba.tdd.tp2.offer_validator_client.Product;
import ar.fiuba.tdd.tp2.offer_validator_client.PurchaseDate;
import ar.fiuba.tdd.tp2.offer_validator_client.Sale;

import java.util.ArrayList;
import java.util.List;

public class Adapter {

    public Adapter() {}

    public Sale getSale(List<ar.fiuba.tdd.tp2.Product> products, ar.fiuba.tdd.tp2.PurchaseDate purchaseDate) {
        Payment payment = new Payment("CREDIT","PARISIA");
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
}
