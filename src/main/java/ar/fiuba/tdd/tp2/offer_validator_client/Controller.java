package ar.fiuba.tdd.tp2.offer_validator_client;

//import ar.fiuba.tdd.tp2.offer_validator_client.OffersAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Controller {

    static final String BASE_URL = "http://localhost:3000/";
    OffersAPI offersAPI;

    public Controller() {
      Gson gson = new GsonBuilder()
              .setLenient()
              .create();

      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create(gson))
              .build();

      this.offersAPI = retrofit.create(OffersAPI.class);
    }

    public void initializeOffers(OffersInitializer offer_initializer) {
        System.out.println("Initialize offers");
        Call<String> call = this.offersAPI.initializeOffers(offer_initializer);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    String message = response.body();
                    System.out.println("\n\n"+message);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
          });
    }

    public void processSale(ProcessSale process_sale) {
        System.out.println("Process Sale");
        Call<List<SaleResult>> call = this.offersAPI.processSale(process_sale);
        call.enqueue(new Callback<List<SaleResult>>() {
            @Override
            public void onResponse(Call<List<SaleResult>> call, Response<List<SaleResult>> response) {
                if(response.isSuccessful()) {
                    List<SaleResult> sale_results = response.body();
                    for (SaleResult sale : sale_results) {
                        System.out.println("description: " + sale.description);
                        System.out.println("discount: " +sale.discount);
                    }
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<SaleResult>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
