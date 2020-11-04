package com.semicode.blooodbank.view.activity;

import android.os.Bundle;

import com.jaeger.library.StatusBarUtil;
import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.splashCycle.SplashFragment;

public class SplashCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        StatusBarUtil.setTransparent( getParent());
        HelperMethod.changeLang(getBaseContext(), "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_cycle);

        SplashFragment splashFragment = new SplashFragment();
        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.splash_frame, splashFragment);

//        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.frame, signUpFragment);
//        Intent myIntent = new Intent(getBaseContext(), HomeCycleActivity.class);
//        startActivity(myIntent);

    }
}