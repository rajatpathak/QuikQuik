package com.appentus.quikquik.Fragments.subfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.Adapter.OngoingOrdersAdapter;
import com.appentus.quikquik.Adapter.OurServicesAdapter;
import com.appentus.quikquik.Adapter.WorkAdapter;
import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceFragment extends Fragment {
    public ServiceFragment() {
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
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new GridLayoutManager(activity,2));
        recyclerView.setAdapter(new OurServicesAdapter(activity));
        return view;
    }

}