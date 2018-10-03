package com.appentus.quikquik.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.appentus.quikquik.Fragments.subfragment.AboutFragment;
import com.appentus.quikquik.Fragments.subfragment.ServiceFragment;
import com.appentus.quikquik.Fragments.subfragment.WorkWithUs;
import com.appentus.quikquik.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutUsActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.home_viewPager)
    ViewPager viewPager;
    Activity activity = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        AboutUsActivity.ViewPagerAdapter adapter = new AboutUsActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ServiceFragment(), "Services");
        adapter.addFragment(new AboutFragment(), "About");
        adapter.addFragment(new WorkWithUs(), "Work With US");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            fragmentTitle.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
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
