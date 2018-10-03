package com.appentus.quikquik.Fragments.main;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appentus.quikquik.R;

import butterknife.ButterKnife;


public class ChatFragment extends Fragment {

    public ChatFragment() {
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
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        activity = getActivity();
        ButterKnife.bind(this, view);
        return view;
    }

}
