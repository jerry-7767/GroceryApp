package com.example.groceryapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groceryapp.ProductDetailsActivity;
import com.example.groceryapp.R;
import com.example.groceryapp.model.RecentlyViewed;
import com.example.groceryapp.model.VegrtableItems;

import java.util.List;

public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.VegetableViewHolder> {

    Context context;
    List<VegrtableItems> vegrtableItems;

    public VegetableAdapter(Context context, List<VegrtableItems> vegrtableItems) {
        this.context = context;
        this.vegrtableItems = vegrtableItems;
    }

    @NonNull
    @Override
    public VegetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recently_viewed_items, parent, false);

        return new VegetableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableViewHolder holder, final int position) {

        holder.name.setText(vegrtableItems.get(position).getName());
        holder.description.setText(vegrtableItems.get(position).getDescription());
        holder.price.setText(vegrtableItems.get(position).getPrice());
        holder.qty.setText(vegrtableItems.get(position).getQuantity());
        holder.unit.setText(vegrtableItems.get(position).getUnit());
        holder.bg.setBackgroundResource(vegrtableItems.get(position).getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(context, ProductDetailsActivity.class);
                i.putExtra("name", vegrtableItems.get(position).getName());
                i.putExtra("image", vegrtableItems.get(position).getBigimageurl());
                i.putExtra("price",vegrtableItems.get(position).getPrice());
                i.putExtra("desc",vegrtableItems.get(position).getDescription());
                i.putExtra("qty",vegrtableItems.get(position).getQuantity());
                i.putExtra("unit",vegrtableItems.get(position).getUnit());

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return vegrtableItems.size();
    }

    public  static class VegetableViewHolder extends RecyclerView.ViewHolder{

        TextView name, description, price, qty, unit;
        ConstraintLayout bg;

        public VegetableViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.product_name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            qty = itemView.findViewById(R.id.qty);
            unit = itemView.findViewById(R.id.unit);
            bg = itemView.findViewById(R.id.recently_layout);

        }
    }

}
