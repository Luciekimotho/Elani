package com.lucie.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lucie on 11/16/15.
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private Context context;
    private List<String> name;
    List<String>price;
    List<String>imageUrl;

    public ItemAdapter(Context mContext, List<String> name, List<String> price, List<String> imageUrl) {
        this.context = mContext;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }



    public static class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CardView itemCard;
        ImageView itemImg;
        TextView itemName, itemPrice;

        public ItemHolder(View v) {
            super(v);
            itemCard = (CardView) v.findViewById(R.id.itemCardView);
            itemImg = (ImageView) v.findViewById(R.id.itemImgView);
            itemName = (TextView) v.findViewById(R.id.itemNameView);
            itemPrice = (TextView) v.findViewById(R.id.itemPriceView);
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Log.d("position", ""+position);
            Toast.makeText(v.getContext(), "Clicked Position = " +position, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_card, parent, false);
        ItemHolder itemHolder = new ItemHolder(layoutView);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int i) {
        holder.itemName.setText(name.get(i));
        holder.itemPrice.setText("Ksh." +price.get(i));
        Picasso.with(this.context)
                .load(imageUrl.get(i)).resize(150, 150).centerCrop()
                .into(holder.itemImg);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }


}
