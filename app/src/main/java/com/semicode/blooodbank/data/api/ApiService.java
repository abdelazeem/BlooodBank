package com.semicode.blooodbank.data.api;

import com.semicode.blooodbank.data.model.donation.Donation;
import com.semicode.blooodbank.data.model.donationDetils.DonationDetils;
import com.semicode.blooodbank.data.model.generalRespoe.GeneralResponse;


import com.semicode.blooodbank.data.model.notification.Notification;
import com.semicode.blooodbank.data.model.post.Post;
import com.semicode.blooodbank.data.model.posts.Posts;
import com.semicode.blooodbank.data.model.profile.Profile;

import com.semicode.blooodbank.data.model.restPassword.RestPassword;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @GET("cities")
    Call<GeneralResponse> getCities(@Query("governorate_id") int governorateId);

    @GET("governorates")
    Call<GeneralResponse> getGovernment();

    @GET("blood-types")
    Call<GeneralResponse> getBloodType();

    @GET("notifications-settings")
    Call<Notification> getNotificationsSettings(@Query("api_token") String apiToken);

    @GET("posts")
    Call<Posts> getPosts(@Query("api_token") String apiToken,
                         @Query("page") int page);

    @GET("post")
    Call<Post> getPostDetails(@Query("api_token") String apiToken,
                              @Query("post_id") int postId,
                              @Query("page") int page);

    @GET("my-favourites")
    Call<Posts> getFavouritesPosts(@Query("api_token") String apiToken,
                                   @Query("page") int page);

    @GET("donation-requests")
    Call<Donation> getDonationRequests(@Query("api_token") String apiToken,
                                       @Query("page") int page);

    @GET("donation-request")
    Call<DonationDetils> getDonationDetails(@Query("api_token") String apiToken,
                                            @Query("donation_id") int donationId);

    @GET("donation-request/create")
    Call<DonationDetils> createDonation(@Query("blood_type_id") String bloodTypeId,
                                        @Query("bags_num") int bagsNum,
                                        @Query("hospital_name") String hospitalName,
                                        @Query("hospital_address") String hospitalAddress,
                                        @Query("city_id") int cityId,
                                        @Query("phone") String phone,
                                        @Query("notes") String notes,
                                        @Query("latitude") float latitude,
                                        @Query("longitude") float longitude);

    @GET("donation-requests")
    Call<Donation> getDonationFilter(@Query("api_token") String apiToken,
                                     @Query("blood_type_id") int bloodTypeId,
                                     @Query("governorate_id") int governorateId,
                                     @Query("page") int page);


    @GET("new-password")
    Call<RestPassword> changePassword(@Query("password") String password
            , @Query("password_confirmation") String passwordConfirmation
            , @Query("pin_code") int pinCode
            , @Query("phone") String phone
    );

    @FormUrlEncoded
    @POST("reset-password")
    Call<RestPassword> resetPassword(@Field("phone") String Phone);

    @FormUrlEncoded
    @POST("login")
    Call<Profile> logIn(@Field("phone") String Phone,
                        @Field("password") String password);

    //
    @FormUrlEncoded
    @POST("signup")
    Call<Profile> signUp(@Field("name") String name,
                         @Field("email") String email,
                         @Field("birth_date") String birthDate,
                         @Field("city_id") int cityId,
                         @Field("phone") String phone,
                         @Field("donation_last_date") String donationLastDate,
                         @Field("password") String password,
                         @Field("password_confirmation") String passwordConfirmation,
                         @Field("blood_type_id") int bloodTypeId);

    @FormUrlEncoded
    @POST("profile")
    Call<Profile> getProfileData(@Field("api_token") String apiToken);

    @FormUrlEncoded
    @POST("profile")
    Call<Profile> editProfileData(@Field("name") String name,
                                  @Field("email") String email,
                                  @Field("birth_date") String birthDate,
                                  @Field("city_id") String cityId,
                                  @Field("phone") String phone,
                                  @Field("donation_last_date") String donationLastDate,
                                  @Field("password") String password,
                                  @Field("password_confirmation") String passwordConfirmation,
                                  @Field("blood_type_id") String bloodTypeId,
                                  @Field("api_token") String apiToken);


}
