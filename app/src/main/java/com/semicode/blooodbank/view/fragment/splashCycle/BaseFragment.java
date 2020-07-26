package com.semicode.blooodbank.view.fragment.splashCycle;

import androidx.fragment.app.Fragment;

import com.semicode.blooodbank.view.activity.BaseActivity;

public class BaseFragment extends Fragment {

public BaseActivity baseActivity ;

    public void initFragment() {
        baseActivity = (BaseActivity) getActivity();
        baseActivity.baseFragment = this ;


    }
    public void onBack(){

    }

}
