package com.semicode.blooodbank.view.fragment.authCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.adapter.MySpinnerAdapter;
import com.semicode.blooodbank.data.api.ApiService;
import com.semicode.blooodbank.data.model.DateTxt;
import com.semicode.blooodbank.data.model.GeneralResponse;
import com.semicode.blooodbank.data.model.GeneralResponseData;
import com.semicode.blooodbank.data.model.register.Register;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.semicode.blooodbank.data.api.ApiClient.getClient;


public class SignUpFragment extends BaseFragment {


    @BindView(R.id.sign_up_fragment_sp_blood_types)
    Spinner signUpFragmentSpBloodTypes;

    DateTxt dateTxt;
    @BindView(R.id.sign_up_fragment_et_birth_date)
    TextView signUpFragmentEtBirthDate;
    @BindView(R.id.sign_up_fragment_et_last_donition)
    TextView signUpFragmentEtLastDonition;

    @BindView(R.id.sign_up_fragment_sp_address)
    Spinner signUpFragmentSpAddress;
    @BindView(R.id.sign_up_fragment_sp_city)
    Spinner signUpFragmentSpCity;

    List<GeneralResponseData> bloodTypeList = new ArrayList<>();
    List<GeneralResponseData> cityList = new ArrayList<>();
    List<GeneralResponseData> governmentList = new ArrayList<>();

    @BindView(R.id.sign_up_fragment_btn_sign_up)
    Button signUpFragmentBtnSignUp;
    ApiService apiService;
    @BindView(R.id.sign_up_fragment_et_name)
    EditText signUpFragmentEtName;
    @BindView(R.id.sign_up_fragment_et_emil)
    EditText signUpFragmentEtEmil;
    @BindView(R.id.sign_up_fragment_et_phone)
    EditText signUpFragmentEtPhone;
    @BindView(R.id.sign_up_fragment_et_password)
    EditText signUpFragmentEtPassword;
    @BindView(R.id.sign_up_fragment_et_confirm_pass)
    EditText signUpFragmentEtConfirmPass;
    MySpinnerAdapter governmentAdapter ;
    public SignUpFragment() {


        apiService = getClient().create(ApiService.class);

        apiService.getBloodType().enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                bloodTypeList.addAll(response.body().getData());

            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });

        apiService.getGovernment().enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                governmentList.addAll(response.body().getData());
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });
        apiService.getCities( 3).enqueue(new Callback<GeneralResponse>() {
            @Override
            public void onResponse(Call<GeneralResponse> call, Response<GeneralResponse> response) {
                cityList.addAll(response.body().getData());
            }

            @Override
            public void onFailure(Call<GeneralResponse> call, Throwable t) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);


        MySpinnerAdapter bloodTypeSpinnerAdapter = new MySpinnerAdapter(getActivity());
        bloodTypeSpinnerAdapter.setData(bloodTypeList, "فصيله الدم");

         governmentAdapter = new MySpinnerAdapter(getActivity());
        governmentAdapter.setData(governmentList, "اختر المحافظه");

        MySpinnerAdapter mySpinnerAdapter = new MySpinnerAdapter(getActivity());
        mySpinnerAdapter.setData(cityList, "اختر المدينه");


        signUpFragmentSpBloodTypes.setAdapter(bloodTypeSpinnerAdapter);
        signUpFragmentSpAddress.setAdapter(governmentAdapter);
        signUpFragmentSpCity.setAdapter(mySpinnerAdapter);

        return view;
    }


    @Override
    public void onBack() {
        LoginFragment loginFragment = new LoginFragment();
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.auth_cycle_frame, loginFragment);

    }


    @OnClick({R.id.sign_up_fragment_et_birth_date, R.id.sign_up_fragment_et_last_donition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sign_up_fragment_et_birth_date:
                DateTxt dateTxt = new DateTxt("17", "9", "1997");
                HelperMethod.showCalender(getActivity(), "birth day", signUpFragmentEtBirthDate, dateTxt);
                break;
            case R.id.sign_up_fragment_et_last_donition:
                DateTxt dateTxt2 = new DateTxt("1", "1", "2019");
                HelperMethod.showCalender(getActivity(), "birth day", signUpFragmentEtLastDonition, dateTxt2);
                break;
        }
    }


    @OnClick(R.id.sign_up_fragment_btn_sign_up)
    public void onViewClicked() {
        apiService.signUp(signUpFragmentEtName.getText() + "",
                "" + signUpFragmentEtEmil,
                "" + signUpFragmentEtBirthDate,
                1,
                "" + signUpFragmentEtPhone,
                "" + signUpFragmentEtLastDonition.getText(),
                "" + signUpFragmentEtPassword, "" + signUpFragmentEtConfirmPass.getText(),
                2).enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                HelperMethod.makeTextToast(getActivity(), "done .............register");
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                HelperMethod.makeTextToast(getActivity(), "not done ");
            }
        });

    }
}