package com.semicode.blooodbank.view.fragment.homeCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.homeCycle.more.AbootAppFragment;
import com.semicode.blooodbank.view.fragment.homeCycle.more.ConnectUsFragment;
import com.semicode.blooodbank.view.fragment.homeCycle.more.FavoritFragment;
import com.semicode.blooodbank.view.fragment.homeCycle.more.NotificationSettingFragment;
import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.semicode.blooodbank.helper.HelperMethod.showDialog;


public class MoreFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_more, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.more_tv_favorite, R.id.more_tv_connect_us, R.id.more_tv_about_app, R.id.more_tv_star_rate, R.id.more_tv_notification_setting, R.id.more_tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_tv_favorite:
                HelperMethod.replaceFragment(getFragmentManager(), R.id.home_cycle_frame, new FavoritFragment());
//
                break;
            case R.id.more_tv_connect_us:
                HelperMethod.replaceFragment(getFragmentManager(), R.id.home_cycle_frame, new ConnectUsFragment());

                break;
            case R.id.more_tv_about_app:
                HelperMethod.replaceFragment(getFragmentManager(), R.id.home_cycle_frame, new AbootAppFragment());
                break;
            case R.id.more_tv_star_rate:

                break;
            case R.id.more_tv_notification_setting:
                HelperMethod.replaceFragment(getFragmentManager(), R.id.home_cycle_frame, new NotificationSettingFragment());
                break;
            case R.id.more_tv_logout:
                showDialog(getActivity(), "do you want to logout ?");
//                SharedPreferencesManger.clean(getActivity());
//                Intent myIntent = new Intent(getActivity(), SplashCycleActivity.class);
//                startActivity(myIntent);
                break;
        }
    }

    @Override
    public void onBack() {
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.home_cycle_frame, new MainFragment());

    }
}