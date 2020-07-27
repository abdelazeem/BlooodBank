package com.semicode.blooodbank.view.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.authCycle.LoginFragment;
import com.semicode.blooodbank.view.fragment.authCycle.SignUpFragment;
import com.semicode.blooodbank.view.fragment.homeCycle.MoreFragment;
import com.semicode.blooodbank.view.fragment.homeCycle.ProfileFragment;
import com.semicode.blooodbank.view.fragment.splashCycle.SliderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCycleActivity extends BaseActivity {

    @BindView(R.id.home_cycle_frame)
    FrameLayout homeCycleFrame;
    @BindView(R.id.home_activity_nav_bottom)
    BottomNavigationView homeActivityNavBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        HelperMethod.changeLang(getBaseContext(), "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cycle);
        ButterKnife.bind(this);
        homeActivityNavBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home_activity_nav_home:
                        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.home_cycle_frame, new SignUpFragment());
                        break;
                    case R.id.home_activity_nav_profile:
                        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.home_cycle_frame, new ProfileFragment());
                        break;
                    case R.id.home_activity_nav_notification:
                        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.home_cycle_frame, new SliderFragment());
                        break;
                        case R.id.home_activity_nav_more_option:
                        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.home_cycle_frame, new MoreFragment());
                        break;

                }
                return true;
            }
        });

    }
}