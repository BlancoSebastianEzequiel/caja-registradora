package ar.fiuba.tdd.tp2;

import org.json.simple.JSONObject;

public class CompoundRule extends Rule {
    private String type;
    private String code;
    private Object rules;

    public CompoundRule(JSONObject aRule) {
        this.type = (String) aRule.get("type");
        this.code = (String) aRule.get("code");
        this.rules = (Object) aRule.get("rules");
    }

    public String getType() {
        return this.type;
    }

    public String getCode() {
        return this.code;
    }

    public Object getRules() {
        return this.rules;
    }

    public Boolean isAtomic() {
        return false;
    }
    public Boolean isCompound() {
        return true;
    }
}
