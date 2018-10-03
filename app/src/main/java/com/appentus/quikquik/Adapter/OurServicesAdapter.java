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

public class OurServicesAdapter extends RecyclerView.Adapter<OurServicesAdapter.ViewHolder> {
    Activity activity;

    public OurServicesAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public OurServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ourservicelayout, parent, false);
        return new OurServicesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OurServicesAdapter.ViewHolder holder, int position) {
        if(position%2!=0){
            holder.imageView.setBackgroundColor(activity.getResources().getColor(R.color.gray));
        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
