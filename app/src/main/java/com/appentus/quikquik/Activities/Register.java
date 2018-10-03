package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appentus.quikquik.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Register extends AppCompatActivity {


    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnregister, R.id.txtlogin})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.btnregister:
                finishAffinity();
                startActivity(new Intent(activity, MainActivity.class));
                break;
            case R.id.txtlogin:
                finish();
                startActivity(new Intent(activity, LoginActivity.class));
                break;
        }
    }
}
