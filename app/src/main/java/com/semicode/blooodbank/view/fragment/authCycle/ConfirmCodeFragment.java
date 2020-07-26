package com.semicode.blooodbank.view.fragment.authCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.data.api.ApiService;

import com.semicode.blooodbank.data.model.restPassword.RestPassword;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.semicode.blooodbank.data.api.ApiClient.getClient;


public class ConfirmCodeFragment extends BaseFragment {


    @BindView(R.id.confirm_password_fragment_et_code)
    EditText confirmPasswordFragmentEtCode;
    @BindView(R.id.confirm_password_fragment_et_new_pass)
    EditText confirmPasswordFragmentEtNewPass;
    @BindView(R.id.confirm_password_fragment_et_confirm_pass)
    EditText confirmPasswordFragmentEtConfirmPass;
    @BindView(R.id.confirm_password_fragment_btn_change_pass)
    Button confirmPasswordFragmentBtnChangePass;
   ApiService apiService ;
   String phoneNumber ,code ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_confirm_code, container, false);
        ButterKnife.bind(this, view);
        apiService =getClient().create(ApiService.class);
        phoneNumber =getArguments().getString("phone number");
        code =getArguments().getString("code number");
        confirmPasswordFragmentEtCode.setText(phoneNumber);
        confirmPasswordFragmentEtNewPass.setText(code);
        return view;
    }

    @Override
    public void onBack() {
        ForgetPasswordFragment forgetPasswordFragment = new ForgetPasswordFragment();
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.auth_cycle_frame, forgetPasswordFragment);

    }

    @OnClick(R.id.confirm_password_fragment_btn_change_pass)
    public void onViewClicked() {
        apiService.changePassword(confirmPasswordFragmentEtNewPass.getText().toString(),
                confirmPasswordFragmentEtConfirmPass.getText().toString(),Integer.parseInt(confirmPasswordFragmentEtCode.getText().toString()),phoneNumber).enqueue(new Callback<RestPassword>() {
            @Override
            public void onResponse(Call<RestPassword> call, Response<RestPassword> response) {



            }

            @Override
            public void onFailure(Call<RestPassword> call, Throwable t) {
                HelperMethod.makeTextToast(getActivity(),"...not done .......");

            }
        });
    }
}