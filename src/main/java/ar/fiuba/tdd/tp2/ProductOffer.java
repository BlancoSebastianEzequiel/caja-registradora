package ar.fiuba.tdd.tp2;

import org.json.simple.JSONObject;

public class ProductOffer {

    private String name;
    private String brandCode;
    private String brandName;
    private String categoryCode;
    private String categoryName;
    private Double price;
    private Double ivaPorcentage;
    private String code;


    public ProductOffer(JSONObject data) {
        this.name = (String) data.get("name");
        this.brandCode = (String) ((JSONObject) data.get("brand")).get("code");
        this.brandName =  (String) ((JSONObject) data.get("brand")).get("name");
        this.categoryCode = (String) ((JSONObject) data.get("category")).get("code");
        this.categoryName = (String) ((JSONObject) data.get("category")).get("name");
        this.ivaPorcentage = (Double) data.get("iva_porcentage");
        this.code = (String) data.get("code");
    }

    public String getName() { return this.name; }
    public String getBrandCode() {
        return this.brandCode;
    }
    public String getBrandName() { return this.brandName; }
    public String getCategoryCode() {
        return this.categoryCode;
    }
    public String getCategoryName() {
        return this.categoryName;
    }
    public Double getPrice() {
        return this.price;
    }
    public Double getIvaPorcentage() {
        return this.ivaPorcentage;
    }
    public String getCode() {
        return this.code;
    }
}
