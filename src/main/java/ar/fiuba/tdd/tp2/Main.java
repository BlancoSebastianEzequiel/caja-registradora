package ar.fiuba.tdd.tp2;

import ar.fiuba.tdd.tp2.offer_validator_client.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.listCars();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Car car = new Car("red", "ford", "mondeo", 3);

        controller.createCar(car);
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        controller.listCars();
        List<Offer> offers = getOffers();
        List<Rule> rules = getRules();
        OffersInitializer offer_initializer = new OffersInitializer(offers, rules);
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        controller.initializeOffers(offer_initializer);
    }

    private static List<Rule> getRules() {
        Rule rule1 = new Rule("MES_SEPTIEMBRE", "EL MES ES SEPTIEMBRE",
                "EQUALS","CALENDAR.month", "SEPTIEMBRE");

        Rule rule2 = new Rule("PRICE_HIGHER_50000", "Producto con precio menor a 50000",
                "HIGHER","PRODUCT.price", "50000");

        return  Arrays.asList(rule1, rule2);
    }



    private static List<Offer> getOffers() {
        OfferRule offer_rule = new OfferRule("AND", "LACTEO_SEPTIEMBRE",
                Arrays.asList("PRODUCTO_LACTEO", "MES_SEPTIEMBRE"));
        Discount discount = new Discount("PERCENTAGE", 10);
        Offer offer1 = new Offer("10% de descuento en lácteos durante Septiembre","OF0001",
                offer_rule, discount);
        return  Arrays.asList(offer1);
    }
}
