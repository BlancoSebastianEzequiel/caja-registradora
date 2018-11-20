package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Product extends JsonConverter {

    private String code;
    private JSONObject data;

    public Product(String FileName, String code) throws IOException, ParseException {
        super(FileName);
        this.code = code;
        this.data = this.getData();
    }

    private JSONObject getData() {
        JSONArray products = (JSONArray) this.obj;
        for (Object objectProduct : products) {
            JSONObject product = (JSONObject) objectProduct;
            if (product.get("code").equals(this.code)) {
                return product;
            }
        }
        throw new ProductDoesNotExist();
    }
    public String getName() {
        return (String) this.data.get("name");
    }
    public String getBrandCode() {
        return (String) ((JSONObject) this.data.get("brand")).get("code");
    }
    public String getBrandName() {
        return (String) ((JSONObject) this.data.get("brand")).get("name");
    }
    public String getCategoryCode() {
        return (String) ((JSONObject) this.data.get("category")).get("code");
    }
    public String getCategoryName() {
        return (String) ((JSONObject) this.data.get("category")).get("name");
    }
    public Double getPrice() {
        return (Double) this.data.get("price");
    }
    public Double getIvaPorcentage() {
        return (Double) this.data.get("iva_porcentage");
    }
    public String getCode() {
        return (String) this.data.get("code");
    }
}
