package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appentus.quikquik.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class CouriourActivity extends AppCompatActivity {

    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couriour);
        activity=this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ivback,R.id.tvcontinue,R.id.tvpickup,R.id.tvdrop})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                finish();
                break;
            case R.id.tvcontinue:
                startActivity(new Intent(activity, SelectLocationActivity.class));
                break;
            case R.id.tvpickup:
                startActivity(new Intent(activity, MapLocation.class));
                break;
            case R.id.tvdrop:
                startActivity(new Intent(activity, MapLocation.class));
                break;
        }
    }
}