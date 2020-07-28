package com.semicode.blooodbank.view.fragment.homeCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MoreFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.more_tv_favorite, R.id.more_tv_connect_us, R.id.more_tv_about_app, R.id.more_tv_star_rate, R.id.more_tv_notification_setting, R.id.more_tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_tv_favorite:
                HelperMethod.replaceFragment(getFragmentManager(),R.id.home_cycle_frame,new FavoritFragment());
//
                break;
            case R.id.more_tv_connect_us:
                HelperMethod.replaceFragment(getFragmentManager(),R.id.home_cycle_frame,new ConnectUsFragment());

                break;
            case R.id.more_tv_about_app:
                break;
            case R.id.more_tv_star_rate:
                break;
            case R.id.more_tv_notification_setting:
                break;
            case R.id.more_tv_logout:
                break;
        }
    }
}