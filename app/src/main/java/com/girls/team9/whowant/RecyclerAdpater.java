package com.girls.team9.whowant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hyemi on 2015-08-13.
 */
public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.ViewHolder> {
    Context context;
    List<BestRecyclerItem> items_list;
    int itemLayout;
    int frag;

    public RecyclerAdpater(Context context, List<BestRecyclerItem> items, int itemLayout, int frag) {
        this.context=context;
        this.items_list=items;
        this.itemLayout=itemLayout;
        this.frag=frag;
    }//RecyclerAdpater



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (itemLayout) {
            case R.layout.item_best_recycler:
                v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_best_recycler, parent, false);
                return new ViewHolder(v, itemLayout);

//            case R.layout.item_teamlist:
//                v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_teamlist,viewGroup, false);
//                return new ViewHolder(v,itemLayout);
        }
        return null;    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        switch (itemLayout) {
            case R.layout.item_best_recycler:
                final BestRecyclerItem item_list = items_list.get(position);
                holder.name.setText(item_list.getName());
                holder.price.setText(item_list.getPrice());
                break;
        }
    }

    @Override
    public int getItemCount() {
        switch (itemLayout) {
            case R.layout.item_best_recycler:
                return items_list.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView price;
        ImageView picture;
        LinearLayout container;

        public ViewHolder(View itemView,int itemLayout) {
            super(itemView);
            switch (itemLayout) {
                case R.layout.item_best_recycler:
                    picture=(ImageView)itemView.findViewById(R.id.picture);
                    name = (TextView) itemView.findViewById(R.id.name);
                    price = (TextView) itemView.findViewById(R.id.price);
                    container =(LinearLayout)itemView.findViewById(R.id.container);
                    break;
            }
        }
    }//class ViewHolder

}//class
