package com.semicode.blooodbank.view.fragment.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.helper.SharedPreferencesManger;
import com.semicode.blooodbank.view.activity.AuthCycleActivity;
import com.semicode.blooodbank.view.activity.HomeCycleActivity;

import butterknife.ButterKnife;



public class SplashFragment extends BaseFragment {


    boolean GO_TO_SLIDER;
  String anytext ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        HelperMethod.makeTextToast(getActivity(),SharedPreferencesManger.LoadData(getActivity(),SharedPreferencesManger.APITOKEN));
        GO_TO_SLIDER = SharedPreferencesManger.LoadBoolean(getActivity(), SharedPreferencesManger.SPLASH);
        anytext = SharedPreferencesManger.LoadData(getActivity(),SharedPreferencesManger.APITOKEN) ;
        SliderFragment sliderFragment = new SliderFragment();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (GO_TO_SLIDER) {
                    if (anytext.isEmpty()) {
                        Intent myIntent = new Intent(getActivity(), AuthCycleActivity.class);
                        startActivity(myIntent);
                    } else {
                        Intent intent = new Intent(getActivity(), HomeCycleActivity.class);
                        startActivity(intent);
                    }

                    getActivity().finish();
                } else {
                    HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.splash_frame, sliderFragment);
                    SharedPreferencesManger.SaveData(getActivity(), SharedPreferencesManger.SPLASH, true);
                }

            }
        }, 3000);

        return view;

    }

    @Override
    public void onBack() {
        getActivity().finish();
    }
}