package com.semicode.blooodbank.view.fragment.splashCycle;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;

import butterknife.ButterKnife;


public class SplashFragment extends BaseFragment {





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);

        SliderFragment sliderFragment = new SliderFragment();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.frame, sliderFragment);

            }
        }, 3000);

        return view;
    }

    @Override
    public void onBack() {
        getActivity().finish();
    }
}