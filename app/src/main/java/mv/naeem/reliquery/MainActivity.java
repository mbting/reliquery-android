package mv.naeem.reliquery;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import mv.naeem.reliquery.api.ApiClient;
import mv.naeem.reliquery.models.home.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final Context c = this;
    private List<Item> data = new ArrayList<>();
    private List<Item> filtered = new ArrayList<>();
    private final HomeCardsAdapter adapter = new HomeCardsAdapter(filtered);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RecyclerView itemList = (RecyclerView)findViewById(R.id.home_list);
        LinearLayoutManager llm = new LinearLayoutManager(c);
        itemList.setLayoutManager(llm);
        itemList.setAdapter(adapter);

        ApiClient.getClient().home().enqueue(new Callback<List<Item>>(){
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                data.addAll(response.body());
                filtered.addAll(data);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                try {
                    Toast.makeText(c,"Failed",Toast.LENGTH_LONG).show();
                } catch (Exception e) { e.printStackTrace(); }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) { return true; }

            @Override
            public boolean onQueryTextChange(final String query) {
                if (query.length() == 0) {
                    filtered.clear();
                    filtered.addAll(data);
                    adapter.notifyDataSetChanged();
                } else {
                    filtered.clear();
                    adapter.notifyDataSetChanged();
                    for (Item i : data) {
                        if (i.getName().toLowerCase().contains(query)) {
                            filtered.add(i);
                        }
                    }
                    adapter.notifyDataSetChanged();
                }
                return true;
            }
        });
        return true;

    }




}

