package com.semicode.blooodbank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import butterknife.ButterKnife;


public class EmptyFragment extends BaseFragment {




    public EmptyFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);
        return view ;
    }
}