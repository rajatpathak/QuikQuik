package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.R;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {
    Activity activity;

    public WorkAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public WorkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.workwithuslayout,parent,false);
        return new WorkAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkAdapter.ViewHolder holder, int position) {

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
