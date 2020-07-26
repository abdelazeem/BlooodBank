package com.semicode.blooodbank.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

public class BaseActivity extends AppCompatActivity {

     public BaseFragment baseFragment ;


    public void superBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }
}
