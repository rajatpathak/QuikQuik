package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    Activity activity;

    public CategoryAdapter(Activity activity) {
        this.activity=activity;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.quickcatagorylayout,parent,false);
        return new CategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CategoryAdapter.ViewHolder holder, int position) {

        final LinearLayoutManager lm = new LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(lm);
        holder.recyclerView.setAdapter(new FoodItemAdapter(activity));


        holder.ivnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   holder.recyclerView.smoothScrollToPosition(lm.findFirstVisibleItemPosition()+1);
                holder.recyclerView.getLayoutManager().smoothScrollToPosition(holder.recyclerView,new RecyclerView.State(),lm.findFirstVisibleItemPosition()+2);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.RecyclerView)
        RecyclerView recyclerView;
        @BindView(R.id.ivnext)
        ImageButton ivnext;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
