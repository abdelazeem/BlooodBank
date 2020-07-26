package com.semicode.blooodbank.view.fragment.authCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.data.api.ApiService;

import com.semicode.blooodbank.data.model.login.Login;
import com.semicode.blooodbank.data.model.restPassword.RestPassword;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.activity.HomeCycleActivity;
import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.semicode.blooodbank.data.api.ApiClient.getClient;


public class LoginFragment extends BaseFragment {


    @BindView(R.id.login_fragment_et_email)
    EditText loginFragmentEtEmail;
    @BindView(R.id.login_fragment_et_password)
    EditText loginFragmentEtPassword;
    @BindView(R.id.login_fragment_chb_remember)
    CheckBox loginFragmentChbRemember;
    @BindView(R.id.login_fragment_tv_forget_pass)
    TextView loginFragmentTvForgetPass;
    @BindView(R.id.login_fragment_btn_sign_in)
    Button loginFragmentBtnSignIn;
    @BindView(R.id.login_fragment_btn_sign_up)
    Button loginFragmentBtnSignUp;
    ApiService apiService ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
//        Intent intent = new Intent(getActivity() ,HomeCycleActivity.class);
//        startActivity(intent);
         apiService = getClient().create(ApiService.class);


        return view;
    }

    @OnClick({R.id.login_fragment_chb_remember, R.id.login_fragment_tv_forget_pass, R.id.login_fragment_btn_sign_in, R.id.login_fragment_btn_sign_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_fragment_chb_remember:
                break;
            case R.id.login_fragment_tv_forget_pass:
                ForgetPasswordFragment forgetPasswordFragment = new ForgetPasswordFragment();
                HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.auth_cycle_frame, forgetPasswordFragment);
                break;
            case R.id.login_fragment_btn_sign_in:
                apiService.logIn("01157903000","123").enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if (response.body().getStatus()==1){
                            HelperMethod.makeTextToast(getActivity(),"login done .......");
                        }else {
                            HelperMethod.makeTextToast(getActivity(),"email or password is incorrect.......");
                        }

                    }

                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        HelperMethod.makeTextToast(getActivity(),"login not  done .......");
                    }
                });
                break;
            case R.id.login_fragment_btn_sign_up:
                SignUpFragment signUpFragment = new SignUpFragment();
                HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.auth_cycle_frame, signUpFragment);

                break;
        }
    }

    @Override
    public void onBack() {
        getActivity().finish();
    }


}