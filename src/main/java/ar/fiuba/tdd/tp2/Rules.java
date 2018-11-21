package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Rules extends JsonConverter {

    private List<Rule> rules;

    public Rules(String JsonFileName) throws IOException, ParseException {
        super(JsonFileName);
        this.rules = new ArrayList<>();
        for (Object anObjectRule: (JSONArray) this.obj) {
            JSONObject aRule = (JSONObject) anObjectRule;
            this.rules.add(Rule.getRule(aRule));
        }
    }

    public List<Rule> getRules() {
        return this.rules;
    }
}
