package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.R;

public class SubCartAdapter extends RecyclerView.Adapter<SubCartAdapter.ViewHolder> {
    Activity activity;
    public SubCartAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public SubCartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cartsubitemlayout,parent,false);
        return new SubCartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubCartAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
