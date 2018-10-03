package com.appentus.quikquik.Fragments.subfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.Adapter.OurServicesAdapter;
import com.appentus.quikquik.Adapter.WorkAdapter;
import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WorkWithUs extends Fragment {


    public WorkWithUs() {
        // Required empty public constructor
    }

    Activity activity;
    @BindView(R.id.RecyclerView)
    RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_work_with_us, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new WorkAdapter(activity));
        return view;
    }

}
