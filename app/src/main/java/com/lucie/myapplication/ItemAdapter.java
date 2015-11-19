package com.lucie.myapplication;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by lucie on 11/16/15.
 */
public class ItemAdapter extends  RecyclerView.Adapter<ItemAdapter.ItemHolder> {
    private Context context;
    private List<Item> itemList;

    public ItemAdapter(Context mContext, List<Item> mList){
        this.context = mContext;
        this.itemList = mList;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_items, null);
        ItemHolder itemHolder = new ItemHolder(layoutView);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        /*Picasso.with(this.context)
                .load("https://s-media-cache-ak0.pinimg.com/236x/03/a8/53/03a8535aca4c3447abb505530d30b1f9.jpg").resize(150, 150).centerCrop()
                .into(holder.itemImg);*/
        Picasso.with(this.context)
                .load(itemList.get(position).getImgUrl()).resize(150, 150).centerCrop()
                .into(holder.itemImg);
        holder.itemName.setText(itemList.get(position).getName());
        holder.itemPrice.setText(itemList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder{
        CardView itemCard;
        ImageView itemImg;
        TextView itemName, itemPrice;
        public ItemHolder(View v) {
            super(v);
            itemCard = (CardView) v.findViewById(R.id.itemCardView);
            itemImg = (ImageView) v.findViewById(R.id.itemImgView);
            itemName = (TextView) v.findViewById(R.id.itemNameView);
            itemPrice = (TextView) v.findViewById(R.id.itemPriceView);
        }
    }

}
