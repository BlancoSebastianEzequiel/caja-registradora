package ar.fiuba.tdd.tp2.offer_validator_client;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface OffersAPI {

    @GET("example/api/car")
    Call<List<Car>> listCars();

    @POST("/example/api/car")
    Call<Car> createCar(@Body Car car);

    @POST("/example/api/initialize")
    Call<String> initializeOffers(@Body OffersInitializer offer_initializer);

    @POST("/example/api/process-sale")
    Call<String> processSale(@Body ProcessSale process_sale);
}