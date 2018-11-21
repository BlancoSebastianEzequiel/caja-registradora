package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Offer {

    private String description;
    private String code;
    private String ruleType;
    private String ruleCode;
    private List<String> ruleRules;
    private String discountType;
    private String discountValue;

    public Offer(JSONObject anOffer) {
        this.description = (String) anOffer.get("description");
        this.code = (String) anOffer.get("code");
        this.ruleType = (String) ((JSONObject) anOffer.get("rule")).get("type");
        this.ruleCode = (String) ((JSONObject) anOffer.get("rule")).get("code");
        this.ruleRules = new ArrayList<>();
        JSONArray rules = (JSONArray) ((JSONObject) anOffer.get("rule")).get("rules");
        for (Object anObjectRule: rules) {
            String aRule = (String) anObjectRule;
            this.ruleRules.add(aRule);
        }
        this.discountType = (String) anOffer.get("description");
        this.discountValue = (String) anOffer.get("description");
    }

    public String getDescription() {
        return this.description;
    }

    public String getCode() {
        return this.code;
    }

    public String getDiscountType() {
        return this.discountType;
    }

    public String getDiscountValue() {
        return this.discountValue;
    }

    public String getRuleCode() {
        return this.ruleCode;
    }

    public String getRuleType() {
        return this.ruleType;
    }

    public List<String> getRuleRules() {
        return this.ruleRules;
    }
}
