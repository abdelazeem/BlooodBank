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


public class ForgetPasswordFragment extends BaseFragment {


    @BindView(R.id.forget_pass_fragment_btn_send)
    Button forgetPassFragmentBtnSend;

    @BindView(R.id.forget_pass_fragment_et_email)
    EditText forgetPassFragmentEtEmail;
    String phone;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auth_forget_password, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onBack() {
        LoginFragment loginFragment = new LoginFragment();
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.auth_cycle_frame, loginFragment);

    }

    @OnClick(R.id.forget_pass_fragment_btn_send)
    public void onViewClicked() {
        phone =forgetPassFragmentEtEmail.getText().toString();

        if (phone.isEmpty()){
            HelperMethod.makeTextToast(getActivity()," enter emil or phone");
        }else {
            getClient().resetPassword(phone).enqueue(new Callback<RestPassword>() {
                @Override
                public void onResponse(Call<RestPassword> call, Response<RestPassword> response) {
                   int x = response.body().getRestPasswordData().getPinCodeForTest();
                    HelperMethod.makeTextToast(getActivity(),"code set to your emil"+x);
                    Bundle bundle=new Bundle();
                    bundle.putString("phone number", phone);
                    bundle.putString("code number", String.valueOf(x));
                    ConfirmCodeFragment confirmCodeFragment = new ConfirmCodeFragment();
                    confirmCodeFragment.setArguments(bundle);
                    HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.auth_cycle_frame, confirmCodeFragment);

                }

                @Override
                public void onFailure(Call<RestPassword> call, Throwable t) {
                    HelperMethod.makeTextToast(getActivity(),"please enter valid emil or phone");
                }
            });
        }

    }
}