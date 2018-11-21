package ar.fiuba.tdd.tp2.offer_validator_client;

public class Car {
    String color;
    String brand;
    String model;
    int id;

    public Car(String color, String brand, String model, Integer id) {
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}