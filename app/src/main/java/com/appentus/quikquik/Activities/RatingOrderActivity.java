package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.appentus.quikquik.Fragments.main.MyOrdersFragment;
import com.appentus.quikquik.Fragments.subfragment.OngoingOrdersFragment;
import com.appentus.quikquik.Fragments.subfragment.PastOrdersFragment;
import com.appentus.quikquik.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RatingOrderActivity extends AppCompatActivity {
  Activity activity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_order);
        ButterKnife.bind(activity);
    }

    @OnClick({R.id.ivback, R.id.tvcontinue})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.ivback:
                onBackPressed();
                break;
            case R.id.tvcontinue:
                onBackPressed();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        startActivity(new Intent(activity, MainActivity.class));
    }
}
