package ar.fiuba.tdd.tp2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Offers extends JsonConverter {

    private List<Offer> offers;

    Offers(String JsonFileName) throws IOException, ParseException {
        super(JsonFileName);
        this.offers = new ArrayList<>();
        for (Object anObjectOffer: (JSONArray) this.obj) {
            JSONObject anOffer = (JSONObject) anObjectOffer;
            this.offers.add(new Offer(anOffer));
        }
    }

    public List<Offer> getOffers() {
        return this.offers;
    }
}
