package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.appentus.quikquik.Adapter.NotificationAdapter;
import com.appentus.quikquik.Adapter.RestaurentItemAdapter;
import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RestaurentActivity extends AppCompatActivity {

    Activity activity;
    @BindView(R.id.resitemrecycle)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurent);
        activity = this;
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new RestaurentItemAdapter(activity));
    }

    @OnClick({R.id.ivback})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                finish();
                break;
        }
    }
}
