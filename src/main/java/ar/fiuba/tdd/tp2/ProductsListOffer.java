package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsListOffer extends JsonConverter {

    private List<ProductOffer> products;

    public ProductsListOffer(String fileName) throws IOException, ParseException {
        super(fileName);
        this.products = new ArrayList<>();
        for(Object aProduct: (JSONArray) this.obj) {
            this.products.add(new ProductOffer((JSONObject) aProduct));
        }
    }

    public List<ProductOffer> getProducts() {
        return this.products;
    }
}
