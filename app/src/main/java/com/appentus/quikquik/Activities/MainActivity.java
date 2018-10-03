package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appentus.quikquik.Fragments.main.ChatFragment;
import com.appentus.quikquik.Fragments.main.HomeFragment;
import com.appentus.quikquik.Fragments.main.MyAccountFragment;
import com.appentus.quikquik.Fragments.main.MyOrdersFragment;
import com.appentus.quikquik.Fragments.main.SettingsFragment;
import com.appentus.quikquik.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    Activity activity;
    FragmentTransaction ft;
    @ColorRes
    int blue = R.color.tintblue;
    @ColorRes
    int gray = R.color.gray;
    int flag = 0;
    @BindViews(value = {R.id.tvhome, R.id.tvorder, R.id.tvchat, R.id.tvaccount, R.id.tvsetting})
    protected List<TextView> textViews;

    @BindViews(value = {R.id.llhome, R.id.llorder, R.id.llchat, R.id.llaccount, R.id.llsetting})
    protected List<LinearLayout> linearLayouts;

    @BindViews(value = {R.id.ivhome, R.id.ivorder, R.id.ivchat, R.id.ivaccount, R.id.ivsetting})
    protected List<ImageView> imageViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        ButterKnife.bind(this);
        home();
    }

    @OnClick({R.id.llhome, R.id.llorder, R.id.llchat, R.id.llaccount, R.id.llsetting})
    protected void onViewCliked(View view) {
        switch (view.getId()) {
            case R.id.llhome:
                if (flag != 0)
                    home();
                break;

            case R.id.llorder:
                if (flag != 1)
                    calendar();
                break;

            case R.id.llchat:
                if (flag != 2)
                    workout();
                break;

            case R.id.llaccount:
                if (flag != 3)
                    upload();
                break;

            case R.id.llsetting:
                //  if(flag!=4)
                settings();
                break;


        }
    }


    @Override
    public void onBackPressed() {
        if (flag != 0) {
            home();
        } else {
            super.onBackPressed();
        }
    }

    private void home() {
        flag = 0;
        changeFragment(new HomeFragment(), "HomeFragment");
        setColor(imageViews.get(0).getDrawable(), textViews.get(0), blue);
        setColor(imageViews.get(1).getDrawable(), textViews.get(1), gray);
        setColor(imageViews.get(2).getDrawable(), textViews.get(2), gray);
        setColor(imageViews.get(3).getDrawable(), textViews.get(3), gray);
        setColor(imageViews.get(4).getDrawable(), textViews.get(4), gray);
    }

    private void calendar() {
        flag = 1;
        changeFragment(new MyOrdersFragment(), "Calendar");
        setColor(imageViews.get(0).getDrawable(), textViews.get(0), gray);
        setColor(imageViews.get(1).getDrawable(), textViews.get(1), blue);
        setColor(imageViews.get(2).getDrawable(), textViews.get(2), gray);
        setColor(imageViews.get(3).getDrawable(), textViews.get(3), gray);
        setColor(imageViews.get(4).getDrawable(), textViews.get(4), gray);
    }

    private void workout() {
        flag = 2;
        changeFragment(new ChatFragment(), "WorkoutFragment");
        setColor(imageViews.get(0).getDrawable(), textViews.get(0), gray);
        setColor(imageViews.get(1).getDrawable(), textViews.get(1), gray);
        setColor(imageViews.get(2).getDrawable(), textViews.get(2), blue);
        setColor(imageViews.get(3).getDrawable(), textViews.get(3), gray);
        setColor(imageViews.get(4).getDrawable(), textViews.get(4), gray);
    }

    private void upload() {
        flag = 3;
        changeFragment(new MyAccountFragment(), "upload");
        setColor(imageViews.get(0).getDrawable(), textViews.get(0), gray);
        setColor(imageViews.get(1).getDrawable(), textViews.get(1), gray);
        setColor(imageViews.get(2).getDrawable(), textViews.get(2), gray);
        setColor(imageViews.get(3).getDrawable(), textViews.get(3), blue);
        setColor(imageViews.get(4).getDrawable(), textViews.get(4), gray);
    }

    private void settings() {
        flag = 4;
        changeFragment(new SettingsFragment(), "upload");
        setColor(imageViews.get(0).getDrawable(), textViews.get(0), gray);
        setColor(imageViews.get(1).getDrawable(), textViews.get(1), gray);
        setColor(imageViews.get(2).getDrawable(), textViews.get(2), gray);
        setColor(imageViews.get(3).getDrawable(), textViews.get(3), gray);
        setColor(imageViews.get(4).getDrawable(), textViews.get(4), blue);
    }

    protected void setColor(Drawable drawable, TextView textView, int color) {
        DrawableCompat.setTint(drawable, ContextCompat.getColor(this, color));
        textView.setTextColor(getResources().getColor(color));
    }

    public void changeFragment(Fragment targetFragment, String name) {
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentview, targetFragment);
        ft.commitAllowingStateLoss();
    }

}