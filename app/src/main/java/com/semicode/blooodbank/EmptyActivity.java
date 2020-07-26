package com.semicode.blooodbank;

import android.os.Bundle;

import com.semicode.blooodbank.view.activity.BaseActivity;

public class EmptyActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_cycle);
    }
}