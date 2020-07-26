package com.semicode.blooodbank.data.api;

import com.semicode.blooodbank.data.model.GeneralResponse;

import com.semicode.blooodbank.data.model.government.Government;
import com.semicode.blooodbank.data.model.login.Login;
import com.semicode.blooodbank.data.model.register.Register;
import com.semicode.blooodbank.data.model.restPassword.RestPassword;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("cities")
    Call<GeneralResponse>getCities(@Query("governorate_id")int governorateId);

    @GET("governorates")
    Call<GeneralResponse>getGovernment();

    @GET("blood-types")
    Call<GeneralResponse>getBloodType();


    @GET("new-password")
    Call<RestPassword>changePassword(@Query("password")String password
                                  ,@Query("password_confirmation")String passwordConfirmation
                                  ,@Query("pin_code")int pinCode
                                  ,@Query("phone")String phone
    );

    @FormUrlEncoded
    @POST("reset-password")
    Call<RestPassword>resetPassword(@Field("phone") String Phone);

    @FormUrlEncoded
    @POST("login")
    Call<Login>logIn(@Field("phone") String Phone,
                     @Field("password")String password);
//
    @FormUrlEncoded
    @POST("signup")
    Call<Register>signUp(@Field("name") String name,
                         @Field("email")String email,
                         @Field("birth_date")String birthDate,
                         @Field("city_id")int cityId,
                         @Field("phone")String phone,
                         @Field("donation_last_date")String donationLastDate,
                         @Field("password")String password,
                         @Field("password_confirmation")String passwordConfirmation,
                         @Field("blood_type_id")int bloodTypeId);



}
