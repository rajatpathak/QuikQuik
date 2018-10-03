package com.appentus.quikquik.Fragments.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.Fragments.subfragment.OngoingOrdersFragment;
import com.appentus.quikquik.Fragments.subfragment.PastOrdersFragment;
import com.appentus.quikquik.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MyOrdersFragment extends Fragment {


    public MyOrdersFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.home_viewPager)
    ViewPager viewPager;
    Activity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_orders, container, false);
        ButterKnife.bind(this, view);
        try {
            activity = getActivity();
        } catch (Exception ex) {
        }
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new OngoingOrdersFragment(), "Ongoing Orders");
        adapter.addFragment(new PastOrdersFragment(), "Past Orders");
        viewPager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {
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

    public class onClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

}
