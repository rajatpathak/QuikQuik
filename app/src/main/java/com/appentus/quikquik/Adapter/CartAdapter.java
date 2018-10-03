package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    Activity activity;
    public CartAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartitemlayout,parent,false);
        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        holder.recyclerView.setAdapter(new SubCartAdapter(activity));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.RecyclerView)
        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}
