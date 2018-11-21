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

    public void listCars() {
        System.out.println("List Cars:");
        Call<List<Car>> call = this.offersAPI.listCars();
        call.enqueue( new Callback<List<Car>>() {
            @Override
            public void onResponse(Call<List<Car>> call, Response<List<Car>> response) {
                if(response.isSuccessful()) {
                    List<Car> carsParking = response.body();
                    for (Car car : carsParking) {
                        System.out.println("id:" + car.id);
                        System.out.println("brand:" +car.brand);
                    }
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Car>> call, Throwable t) {
                t.printStackTrace();
            }
          });
    }

    public void createCar(Car car) {
        System.out.println("Create cars:");
        Call<Car> call = this.offersAPI.createCar(car);
        call.enqueue(new Callback<Car>() {
            @Override
            public void onResponse(Call<Car> call, Response<Car> response) {
                if(response.isSuccessful()) {
                    Car new_car = response.body();
                    System.out.println(new_car.brand);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<Car> call, Throwable t) {
                t.printStackTrace();
            }
          });
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
}
