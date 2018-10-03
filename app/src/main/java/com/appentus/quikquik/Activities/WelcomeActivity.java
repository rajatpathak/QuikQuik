package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.appentus.quikquik.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends AppCompatActivity {
    Activity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnlogin, R.id.btnregister})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.btnlogin:
                startActivity(new Intent(activity, LoginActivity.class));
                break;
            case R.id.btnregister:
                startActivity(new Intent(activity, Register.class));
                break;
        }
    }
}
