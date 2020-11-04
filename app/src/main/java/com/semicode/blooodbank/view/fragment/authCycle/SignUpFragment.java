package com.semicode.blooodbank.view.fragment.authCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.adapter.MySpinnerAdapter;
import com.semicode.blooodbank.data.api.ApiService;
import com.semicode.blooodbank.data.api.ApiService.*;
import com.semicode.blooodbank.data.model.DateTxt;
import com.semicode.blooodbank.data.model.generalRespoe.GeneralResponse;
import com.semicode.blooodbank.data.model.generalRespoe.GeneralResponseData;

import com.semicode.blooodbank.data.model.profile.Profile;
import com.semicode.blooodbank.helper.GeneralRequest;
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
import static com.semicode.blooodbank.helper.GeneralRequest.getSpinnerData;


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
    MySpinnerAdapter governmentAdapter, bloodTypeSpinnerAdapter, CitySpinnerAdapter;

    public SignUpFragment() {




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_auth_sign_up, container, false);
        ButterKnife.bind(this, view);
        bloodTypeSpinnerAdapter = new MySpinnerAdapter(getActivity());
        governmentAdapter = new MySpinnerAdapter(getActivity());
        CitySpinnerAdapter = new MySpinnerAdapter(getActivity());

//
        getSpinnerData(getActivity(),signUpFragmentSpBloodTypes,bloodTypeSpinnerAdapter,getString(R.string.choose_blood_type), getClient().getBloodType());
        getSpinnerData(getActivity(),signUpFragmentSpAddress,governmentAdapter,getString(R.string.choose_govrenment), getClient().getGovernment());
//


        signUpFragmentSpAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                getSpinnerData(getActivity(),signUpFragmentSpCity,CitySpinnerAdapter,getString(R.string.choose_city), getClient().getCities(governmentAdapter.selectedId));

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        HelperMethod.dismissProgressDialog();

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
        HelperMethod.showProgressDialog(getActivity(), "Sign up...");
        getClient().signUp(signUpFragmentEtName.getText() + "",
                "" + signUpFragmentEtEmil.getText(),
                "" + signUpFragmentEtBirthDate.getText(),
                signUpFragmentSpCity.getSelectedItemPosition(),
                "" + signUpFragmentEtPhone.getText(),
                "" + signUpFragmentEtLastDonition.getText(),
                "" + signUpFragmentEtPassword.getText(),
                "" + signUpFragmentEtConfirmPass.getText(),
                signUpFragmentSpBloodTypes.getSelectedItemPosition()).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                HelperMethod.dismissProgressDialog();
                HelperMethod.makeTextToast(getActivity(), "done .............register");
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                HelperMethod.dismissProgressDialog();
                HelperMethod.makeTextToast(getActivity(), " not done!!!! ");
            }
        });

    }
}