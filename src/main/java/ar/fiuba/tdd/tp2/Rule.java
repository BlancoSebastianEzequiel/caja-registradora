package ar.fiuba.tdd.tp2;

import org.json.simple.JSONObject;

public abstract class Rule {

    public static Rule getRule(JSONObject aRule) {
        if (aRule.containsKey("value")) {
            return new AtomicRule(aRule);
        }
        return new CompoundRule(aRule);
    }
}
