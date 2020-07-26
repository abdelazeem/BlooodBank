package com.semicode.blooodbank.view.activity;

import android.os.Bundle;


import com.semicode.blooodbank.R;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.authCycle.LoginFragment;


public class AuthCycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        HelperMethod.changeLang(getBaseContext(), "ar");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_cycle);

        LoginFragment loginFragment = new LoginFragment();
        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.auth_cycle_frame, loginFragment);


    }
}