package com.girls.team9.whowant;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eugene on 2015-08-14.
 */
public class BasketRecyclerAdapter extends RecyclerView.Adapter<BasketRecyclerAdapter.ViewHolder> {
    Context context;
    List<BasketRecyclerItem> items_list;
    int itemLayout;
    int frag;

    public BasketRecyclerAdapter(Context context, List<BasketRecyclerItem> items, int itemLayout, int frag) {
        this.context = context;
        this.items_list = items;
        this.itemLayout = itemLayout;
        this.frag = frag;
    }//RecyclerAdpater


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (itemLayout) {
            case R.layout.item_basket:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_basket, parent, false);
                return new ViewHolder(v, itemLayout);

        }
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (itemLayout) {
            case R.layout.item_basket:
                final BasketRecyclerItem item_list = items_list.get(position);
                holder.name.setText(item_list.getName());
                holder.number.setText(item_list.getNumber());
                holder.price.setText(item_list.getPrice());
                break;
        }
    }

    @Override
    public int getItemCount() {
        switch (itemLayout) {
            case R.layout.item_basket:
                return items_list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView number;
        TextView price;
        ImageView image;
        LinearLayout basket_container;

        public ViewHolder(View itemView, int itemLayout) {
            super(itemView);
            switch (itemLayout) {
                case R.layout.item_best_recycler:
                    image = (ImageView) itemView.findViewById(R.id.image);
                    name = (TextView) itemView.findViewById(R.id.name);
                    number = (TextView) itemView.findViewById(R.id.number);
                    price = (TextView) itemView.findViewById(R.id.price);
                    basket_container = (LinearLayout) itemView.findViewById(R.id.basket_container);
                    break;
            }
        }
    }//class ViewHolder

}//class