package ar.fiuba.tdd.tp2;

public class ProductTicket {
    private String code;
    private Integer quantity;
    private String name;
    private Double price;

    ProductTicket(String code, Integer quantity, String description, Double price ){
        this.code = code;
        this.quantity = quantity;
        this.name = description;
        this.price = price;
    }

    public void add() {
        quantity += 1;
    }

    public Double getPrice() {
        return this.price;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public Integer getQuantity() { return this.quantity;
    }
}
