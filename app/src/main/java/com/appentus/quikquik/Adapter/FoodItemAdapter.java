package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.Activities.QuickResMenuActivity;
import com.appentus.quikquik.Activities.RestaurentActivity;
import com.appentus.quikquik.R;

public class FoodItemAdapter extends RecyclerView.Adapter<FoodItemAdapter.ViewHolder> {
    Activity activity;

    public FoodItemAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public FoodItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menurecyclerlayout,parent,false);
        return new FoodItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodItemAdapter.ViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, QuickResMenuActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
