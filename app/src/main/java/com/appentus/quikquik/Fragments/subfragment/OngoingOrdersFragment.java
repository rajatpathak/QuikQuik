package com.appentus.quikquik.Fragments.subfragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.Adapter.OngoingOrdersAdapter;
import com.appentus.quikquik.Adapter.PastOrdersAdapter;
import com.appentus.quikquik.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OngoingOrdersFragment extends Fragment {

    public OngoingOrdersFragment() {
        // Required empty public constructor
    }

    Activity activity;
    @BindView(R.id.orderrecycle)
    RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ongoing_orders, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(new OngoingOrdersAdapter(activity));
        return view;
    }

}
