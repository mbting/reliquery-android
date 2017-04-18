package mv.naeem.reliquery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import mv.naeem.reliquery.models.home.Item;
import mv.naeem.reliquery.models.home.ItemPart;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView itemList = (RecyclerView)findViewById(R.id.home_list);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        itemList.setLayoutManager(llm);

        HomeCardsAdapter adapter = new HomeCardsAdapter(getData());
        itemList.setAdapter(adapter);

    }

    public List<Item> getData() {
        // mock data
        List<Item> items = new ArrayList<>();
        // item parts
        List<ItemPart> itemparts = new ArrayList<>();
        itemparts.add(new ItemPart(1, "Blueprint", "10% - 20%"));
        itemparts.add(new ItemPart(2, "System", "10% - 20%"));
        itemparts.add(new ItemPart(3, "Chasis", "10% - 20%"));
        itemparts.add(new ItemPart(3, "Neuroptic", "10% - 20%"));
        // item parts long
        List<ItemPart> itemparts1 = new ArrayList<>();
        itemparts1.add(new ItemPart(1, "Blueprint", "10% - 20%"));
        itemparts1.add(new ItemPart(2, "System", "10% - 20%"));
        itemparts1.add(new ItemPart(3, "Chasis", "10% - 20%"));
        itemparts1.add(new ItemPart(3, "Neuroptic", "10% - 20%"));
        itemparts1.add(new ItemPart(3, "New", "10% - 20%"));
        // items
        items.add(new Item(1, "Excalibur", true, itemparts));
        items.add(new Item(1, "Volt", false, itemparts1));
        items.add(new Item(1, "Mag", true, itemparts));
        items.add(new Item(1, "Rhino", true, itemparts1));
        items.add(new Item(1, "Nekros", false, itemparts1));
        items.add(new Item(1, "Inaros", true, itemparts));
        items.add(new Item(1, "Nova", true, itemparts));
        items.add(new Item(1, "Chroma", false, itemparts1));
        items.add(new Item(1, "Frost", true, itemparts));

        return items;
    }

}

