package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AtomicRule extends Rule {

    private String code;
    private String description;
    private String type;
    private String field;
    private Object value;

    public AtomicRule(JSONObject aRule) {
        this.code = (String) aRule.get("code");
        this.description = (String) aRule.get("description");
        this.type = (String) aRule.get("type");
        this.field = (String) aRule.get("field");
        this.value = aRule.get("value");
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getField() {
        return this.field;
    }

    public String getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }
}
