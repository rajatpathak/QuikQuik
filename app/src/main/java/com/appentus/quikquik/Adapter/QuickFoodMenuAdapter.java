package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.R;

public class QuickFoodMenuAdapter extends RecyclerView.Adapter<QuickFoodMenuAdapter.ViewHolder> {
    Activity activity;

    public QuickFoodMenuAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public QuickFoodMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.foodmenulayout,parent,false);
        return new QuickFoodMenuAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuickFoodMenuAdapter.ViewHolder holder, int position) {

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
