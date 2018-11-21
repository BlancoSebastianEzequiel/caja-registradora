package ar.fiuba.tdd.tp2.offer_validator_client;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface OffersAPI {
    @POST("/validator/api/initialize")
    Call<String> initializeOffers(@Body OffersInitializer offer_initializer);

    @POST("/validator/api/process-sale")
    Call<List<SaleResult>> processSale(@Body ProcessSale process_sale);
}