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
import mv.naeem.reliquery.models.home.ItemPart;

import java.util.List;

public class PrimeCardAdapter extends RecyclerView.Adapter<PrimeCardAdapter.ItemViewHolder> {

    List<Item> items;

    PrimeCardAdapter(List<Item> items){
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prime_card, viewGroup, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder itemViewHolder, int i) {
        itemViewHolder.name.setText(items.get(i).name);
        itemViewHolder.vaulted.setVisibility((items.get(i).vaulted) ? View.VISIBLE : View.INVISIBLE);

        // add parts
        itemViewHolder.items.removeAllViews();
        for (ItemPart ip: items.get(i).parts) {
            View v = LayoutInflater.from(itemViewHolder.items.getContext()).inflate(R.layout.prime_card_part, itemViewHolder.items, false);
//            ImageView item_image = (ImageView) v.findViewById(R.id.prime_card_part_image);
            TextView item_name = (TextView) v.findViewById(R.id.prime_card_part_name);
            TextView item_chance = (TextView) v.findViewById(R.id.prime_card_part_chance);
            item_name.setText(ip.name);
            item_chance.setText(ip.chances);
            itemViewHolder.items.addView(v);
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
        LinearLayout items;

         ItemViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.prime_card);
            name = (TextView)itemView.findViewById(R.id.prime_card_title);
            vaulted = (ImageView)itemView.findViewById(R.id.prime_card_vaulted);
            items = (LinearLayout)itemView.findViewById(R.id.prime_card_parts);
        }
    }
}
