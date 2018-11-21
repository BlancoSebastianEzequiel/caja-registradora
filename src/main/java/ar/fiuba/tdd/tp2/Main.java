package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.*;
import ar.fiuba.tdd.tp2.offer_validator_client.Product;
import ar.fiuba.tdd.tp2.offer_validator_client.PurchaseDate;
import ar.fiuba.tdd.tp2.offer_validator_client.Sale;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();

        List<Offer> offers = getOffers();
        List<Rule> rules = getRules();
        OffersInitializer offer_initializer = new OffersInitializer(offers, rules);

        controller.initializeOffers(offer_initializer);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Product> products = getProducts();
        Payment payment = new Payment("CREDIT","PARISIA");
        PurchaseDate purchase_date = new PurchaseDate(2018,20,4,
                "SEPTEMBER", "Thursday");
        Sale sale = new Sale(products, payment, purchase_date);
        ProcessSale process_sale = new ProcessSale("hols", sale);

        controller.processSale(process_sale);
    }

    private static List<Rule> getRules() {
        Rule rule1 = new Rule("MES_SEPTIEMBRE", "EL MES ES SEPTIEMBRE",
                "EQUALS","CALENDAR.month", "SEPTIEMBRE");

        Rule rule2 = new Rule("PRODUCTO_LACTEO", "PRODUCTO ES CATEGORIA LACTEO",
                "EQUALS","PRODUCT.category.code", "X033AXX");

        return  Arrays.asList(rule1, rule2);
    }


    private static List<Product> getProducts() {
        Brand brand = new Brand("Z001ABC", "La Calmisima");
        Category category = new Category("X033AXX", "Lacteo");
        Product product1 = new Product("Leche Descremada 1L, la Calmisima",
                "AAR001", brand, category,25.40, 10.5);


        return  Arrays.asList(product1);
    }

    private static List<Offer> getOffers() {
        OfferRule offer_rule = new OfferRule("AND", "LACTEO_SEPTIEMBRE",
                Arrays.asList("PRODUCTO_LACTEO", "MES_SEPTIEMBRE"));
        Discount discount = new Discount("PERCENTAGE", "10");
        Offer offer1 = new Offer("10% de descuento en lácteos durante Septiembre","OF0001",
                offer_rule, discount);
        return  Arrays.asList(offer1);
    }
}
