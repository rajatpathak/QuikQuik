package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.appentus.quikquik.Adapter.QuickFoodMenuAdapter;
import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class QuickResMenuActivity extends AppCompatActivity {
    Activity activity;
    @BindView(R.id.RecyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_res_menu);
        activity = this;
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new QuickFoodMenuAdapter(activity));
    }

    @OnClick({R.id.ivback, R.id.tvcontinue})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                finish();
                break;
            case R.id.tvcontinue:
                startActivity(new Intent(activity, CartActivity.class));
                break;
        }
    }
}
