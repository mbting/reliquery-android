package mv.naeem.reliquery.api;

import mv.naeem.reliquery.models.home.Item;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiInterface {

    @GET("/")
    Call<List<Item>> home();

}
