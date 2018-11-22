package ar.fiuba.tdd.tp2.offer_validator_client;

public class Product {
    String name, code;
    Brand brand;
    Category category;
    double price, iva_porcentage;

    public Product(String name, String code, Brand brand, Category category, double price, double iva_porcentage) {
        this.name = name;
        this.code = code;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.iva_porcentage = iva_porcentage;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Brand getBrand() {
        return brand;
    }

    public Category getCategory() {
        return category;
    }

    public double getIva_porcentage() {
        return iva_porcentage;
    }

    public double getPrice() {
        return price;
    }
}
