package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appentus.quikquik.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectLocationActivity extends AppCompatActivity {
Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);
        activity=this;
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ivback,R.id.tvcontinue})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                finish();
                break;
            case R.id.tvcontinue:
                startActivity(new Intent(activity, ScheduleActivity.class));
                break;
        }
    }
}
