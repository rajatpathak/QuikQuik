package com.appentus.quikquik.Fragments.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.Activities.CouriourActivity;
import com.appentus.quikquik.Activities.NotificationActivity;
import com.appentus.quikquik.Activities.QuickFoodActivity;
import com.appentus.quikquik.Adapter.CategoryAdapter;
import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeFragment extends Fragment {

    @BindView(R.id.quickrecycle)
    RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    Activity activity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new CategoryAdapter(activity));
        return view;
    }

    @OnClick({R.id.llnotifivation, R.id.llfood, R.id.llcourior})
    public void submit(View view) {
        switch (view.getId()) {
            case R.id.llnotifivation:
                startActivity(new Intent(activity, NotificationActivity.class));
                break;
            case R.id.llfood:
                startActivity(new Intent(activity, QuickFoodActivity.class));
                break;
            case R.id.llcourior:
                startActivity(new Intent(activity, CouriourActivity.class));
                break;
        }
    }
}
