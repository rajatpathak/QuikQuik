package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OngoingOrdersAdapter extends RecyclerView.Adapter<OngoingOrdersAdapter.ViewHolder> {
    Activity activity;

    public OngoingOrdersAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public OngoingOrdersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoingorderlayout,parent,false);
        return new OngoingOrdersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingOrdersAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
