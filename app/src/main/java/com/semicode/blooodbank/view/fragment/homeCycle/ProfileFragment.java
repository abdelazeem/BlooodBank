package com.semicode.blooodbank.view.fragment.homeCycle;

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
import com.semicode.blooodbank.data.model.profile.Client;
import com.semicode.blooodbank.data.model.profile.Profile;
import com.semicode.blooodbank.helper.HelperMethod;
import com.semicode.blooodbank.helper.InternetState;
import com.semicode.blooodbank.helper.SharedPreferencesManger;
import com.semicode.blooodbank.view.fragment.splashCycle.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.semicode.blooodbank.data.api.ApiClient.getClient;
import static com.semicode.blooodbank.helper.GeneralRequest.getSpinnerData;
import static com.semicode.blooodbank.helper.HelperMethod.isConnected;


public class ProfileFragment extends BaseFragment {


     @BindView(R.id.profile_fragment_et_name)
    EditText profileFragmentEtName;
    @BindView(R.id.profile_fragment_et_emil)
    EditText profileFragmentEtEmil;
    @BindView(R.id.profile_fragment_et_birth_date)
    TextView profileFragmentEtBirthDate;
    @BindView(R.id.profile_fragment_sp_blood_types)
    Spinner profileFragmentSpBloodTypes;
    @BindView(R.id.profile_fragment_et_last_donition)
    TextView profileFragmentEtLastDonition;
    @BindView(R.id.profile_fragment_sp_address)
    Spinner profileFragmentSpAddress;
    @BindView(R.id.profilefragment_sp_city)
    Spinner profilefragmentSpCity;
    @BindView(R.id.profile_fragment_et_phone)
    EditText profileFragmentEtPhone;
    @BindView(R.id.profile_fragment_et_password)
    EditText profileFragmentEtPassword;
    @BindView(R.id.profile_fragment_et_confirm_pass)
    EditText profileFragmentEtConfirmPass;
    @BindView(R.id.profile_fragment_btn_edit)
    Button profileFragmentBtnSignUp;

    MySpinnerAdapter governmentAdapter, bloodTypeSpinnerAdapter, CitySpinnerAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_profile, container, false);
        ButterKnife.bind(this, view);

        bloodTypeSpinnerAdapter = new MySpinnerAdapter(getActivity());
        governmentAdapter = new MySpinnerAdapter(getActivity());
        CitySpinnerAdapter = new MySpinnerAdapter(getActivity());

        getSpinnerData(getActivity(), profileFragmentSpBloodTypes, bloodTypeSpinnerAdapter, getString(R.string.choose_blood_type), getClient().getBloodType());
        getSpinnerData(getActivity(), profileFragmentSpAddress, governmentAdapter, getString(R.string.choose_govrenment), getClient().getGovernment());
        profileFragmentSpAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getSpinnerData(getActivity(), profilefragmentSpCity, CitySpinnerAdapter, getString(R.string.choose_govrenment), getClient().getCities(governmentAdapter.selectedId));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//        profileFragmentSpAddress.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////                HelperMethod.showProgressDialog(getActivity(), "loading cities");
//             int   govermentIdSelected = adapterView.getSelectedItemPosition();
//
//                GeneralRequest.getCityData(profilefragmentSpCity ,CitySpinnerAdapter ,govermentIdSelected);
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        getProfileData(SharedPreferencesManger.LoadData(getActivity(),SharedPreferencesManger.APITOKEN));
//APIToken
        return view;
    }

    public void setDataProfileFragment(Client client) {
        HelperMethod.showProgressDialog(getActivity(), "loading...");

        this.profileFragmentEtName.setText(client.getName());
        this.profileFragmentEtEmil.setText(client.getEmail());
        this.profileFragmentEtBirthDate.setText(client.getBirthDate());
        this.profileFragmentSpBloodTypes.setSelection(client.getBloodType().getId());
        this.profileFragmentEtLastDonition.setText(client.getDonationLastDate());
        this.profileFragmentSpAddress.setSelection(client.getCity().getGovernorate().getId());
        this.profilefragmentSpCity.setSelection(client.getCity().getId());
        this.profileFragmentEtPhone.setText(client.getPhone());
        HelperMethod.dismissProgressDialog();
//        this.profileFragmentEtPassword.setText(client.get);
//        this.profileFragmentBtnSignUp.setText(client);


    }

    void getProfileData(String ApiToke) {

        getClient().getProfileData(ApiToke).enqueue(new Callback<Profile>() {

            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (isConnected(getActivity())) {
                    if (response.body().getStatus() == 1) {
                        setDataProfileFragment(response.body().getData().getClient());
                        HelperMethod.makeTextToast(getActivity(), "done loading .....");

                    }else {
                        HelperMethod.makeTextToast(getActivity(), "please try again later ");
                    }

                }else  {
                    HelperMethod.makeTextToast(getActivity(), "please check your internet connection  ");

                }

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                HelperMethod.dismissProgressDialog();
            }
        });
    }

    @OnClick(R.id.profile_fragment_btn_edit)
    public void onViewClicked() {
        getClient().editProfileData(profileFragmentEtName.getText().toString(),
                profileFragmentEtEmil.getText().toString(),
                profileFragmentEtBirthDate.getText().toString(),
                profilefragmentSpCity.getSelectedItemPosition() + "",
                profileFragmentEtPhone.getText().toString(),
                profileFragmentEtLastDonition.getText().toString(),
                profileFragmentEtPassword.getText().toString(),
                profileFragmentEtConfirmPass.getText().toString(),
                profileFragmentSpBloodTypes.getSelectedItemPosition() + "",
                SharedPreferencesManger.LoadData(getActivity(),SharedPreferencesManger.APITOKEN)
        ).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.body().getStatus() == 1) {
                    HelperMethod.makeTextToast(getActivity(), "your profile data is updated ..");
                } else {
                    HelperMethod.makeTextToast(getActivity(), "data is not updated ..");
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                HelperMethod.makeTextToast(getActivity(), "ERROR..");
            }
        });
    }
}