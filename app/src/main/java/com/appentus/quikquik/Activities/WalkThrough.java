package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.appentus.quikquik.Adapter.SlidingDummyImage_Adapter;
import com.appentus.quikquik.R;
import com.appentus.quikquik.Utility.CircleIndicator;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WalkThrough extends AppCompatActivity {
    Activity activity=this;
    @BindView(R.id.viewpager)
    ViewPager mPager;
    @BindView(R.id.circleIndicator)
    CircleIndicator indicator;
    private static final Integer[] IMAGES = {R.drawable.w1, R.drawable.w2, R.drawable.w3, R.drawable.w4, R.drawable.w5};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        ButterKnife.bind(activity);
        init();
        mPager.setCurrentItem(0);
    }

    private void init() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        mPager.setAdapter(new SlidingDummyImage_Adapter(activity, ImagesArray));
        indicator.setViewPager(mPager);
    }

    @OnClick(R.id.imageButton)
    public void onViewClicked(View view){
        if(mPager.getCurrentItem()!=4){
            mPager.setCurrentItem(mPager.getCurrentItem()+1);
        }else {
            finish();
            startActivity(new Intent(activity, AllowLocationActivity.class));
        }
    }
}
