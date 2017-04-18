package mv.naeem.reliquery.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient instance;
    private ApiInterface client;

    public static final String BASE_URL = "http://reliquery.naeem.mv";

    private ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        client = retrofit.create(ApiInterface.class);
    }

    public static ApiClient getInstance() {
        if(instance == null) instance = new ApiClient();
        return instance;
    }

    public static ApiInterface getClient() {
        return getInstance().client;

    }
}
