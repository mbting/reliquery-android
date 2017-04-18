package mv.naeem.reliquery;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import mv.naeem.reliquery.models.home.Item;
import mv.naeem.reliquery.models.home.Part;

import java.util.List;

public class HomeCardsAdapter extends RecyclerView.Adapter<HomeCardsAdapter.ItemViewHolder> {

    List<Item> items;

    HomeCardsAdapter(List<Item> items){
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.home_card, viewGroup, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.name.setText(items.get(i).getName());
        itemViewHolder.vaulted.setVisibility((items.get(i).getVaulted()) ? View.VISIBLE : View.INVISIBLE);

        // add parts
        itemViewHolder.parts.removeAllViews();
        for (Part ip: items.get(i).getParts()) {
            View v = LayoutInflater.from(itemViewHolder.parts.getContext()).inflate(R.layout.home_card_part, itemViewHolder.parts, false);
            TextView item_name = (TextView) v.findViewById(R.id.home_card_part_name);
            TextView item_chance = (TextView) v.findViewById(R.id.home_card_part_chance);
            item_name.setText(ip.getName());
            item_chance.setText(ip.getChances());
            itemViewHolder.parts.addView(v);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView name;
        ImageView vaulted;
        LinearLayout parts;

         ItemViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.home_card);
            name = (TextView)itemView.findViewById(R.id.home_card_title);
            vaulted = (ImageView)itemView.findViewById(R.id.home_card_vaulted);
            parts = (LinearLayout)itemView.findViewById(R.id.home_card_parts);
        }
    }
}
