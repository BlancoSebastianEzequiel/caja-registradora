package ar.fiuba.tdd.tp2.offer_validator_client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class CarsParking {
    List<Car> cars;

    // public constructor is necessary for collections
    public CarsParking() {
        cars = new ArrayList<Car>();
    }

    public static CarsParking parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        CarsParking carsParking = gson.fromJson(response, CarsParking.class);
        return carsParking;
    }
}
