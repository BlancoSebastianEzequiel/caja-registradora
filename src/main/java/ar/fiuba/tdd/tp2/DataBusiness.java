package ar.fiuba.tdd.tp2;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class DataBusiness extends JsonConverter {

    private String cuit, businessName;
    public DataBusiness(String fileName) throws IOException, ParseException {
        super(fileName);
        this.cuit = (String) ((JSONObject) this.obj).get("cuit");
        this.businessName = (String) ((JSONObject) this.obj).get("business_name");
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public String getCuit() {
        return this.cuit;
    }
}
