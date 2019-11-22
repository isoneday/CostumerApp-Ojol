package com.imastudio.driverappojol.network;


import com.imastudio.driverappojol.model.modelauth.ResponseAuth;
import com.imastudio.driverappojol.model.modeldetail.ResponseDetailDriver;
import com.imastudio.driverappojol.model.modelhistory.ResponseHistory;
import com.imastudio.driverappojol.model.modelmap.ResponseMap;
import com.imastudio.driverappojol.model.modelreqorder.ResponseBooking;
import com.imastudio.driverappojol.model.modelwaiting.ResponseWaiting;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RestApi {


    @FormUrlEncoded
    @POST("daftar/3")
    Call<ResponseAuth> registerUser(
            @Field("nama") String strnama,
            @Field("phone") String strphone,
            @Field("password") String strpassword,
            @Field("email") String stremail
    );

    @FormUrlEncoded
    @POST("login_driver")
    Call<ResponseAuth> loginUser(
            @Field("f_password") String strpassword,
            @Field("f_email") String stremail,
            @Field("device") String strdevice
    );

    @GET("json")
    Call<ResponseMap> getDataMap(
            @Query("origin") String origin,
            @Query("destination") String destination,
            @Query("key") String key
    );

    //endpoint untk insert booking
    @FormUrlEncoded
    @POST("insert_booking")
    Call<ResponseBooking> insertOrderBooking(
            @Field("f_idUser") String striduser,
            @Field("f_latAwal") String strlatawal,
            @Field("f_awal") String strawal,
            @Field("f_latAkhir") String strlatakhir,
            @Field("f_lngAkhir") String strlngakhir,
            @Field("f_akhir") String strakhir,
            @Field("f_catatan") String strcatatan,
            @Field("f_jarak") String strjarak,
            @Field("f_lngAwal") String strlngawal,
            @Field("f_token") String strtoken,
            @Field("f_device") String strdevice
    );

    //endpoint untk check booking
    @FormUrlEncoded
    @POST("checkBooking")
    Call<ResponseWaiting> checkRequestBooking(
            @Field("idbooking") String stridbooking

    );

    //endpoint untk cancel booking
    @FormUrlEncoded
    @POST("cancel_booking")
    Call<ResponseWaiting> cancelBooking(
            @Field("idbooking") String stridbooking,
            @Field("f_token") String strtoken,
            @Field("f_device") String strdevice

    );

    @FormUrlEncoded
    @POST("get_driver")
    Call<ResponseDetailDriver> getDetailDriver(
            @Field("f_iddriver") String striddriver
    );
    @FormUrlEncoded
    @POST("get_booking")
    Call<ResponseHistory> getDataHistory(
            @Field("f_idUser") String striduser,
            @Field("status") String status,
            @Field("f_token") String f_token,
            @Field("f_device") String f_device
    );
@FormUrlEncoded
    @POST("complete_booking_from_user")
    Call<ResponseHistory> completeBooking(
            @Field("f_idUser") String striduser,
            @Field("id") String strIdbooking,
            @Field("f_token") String f_token,
            @Field("f_device") String f_device
    );
@FormUrlEncoded
    @POST("insert_review")
    Call<ResponseHistory> ratingDriver(
            @Field("f_idUser") String striduser,
            @Field("f_driver") String stridDriver,
            @Field("f_idBooking") String strIdbooking,
            @Field("f_ratting") String strRatting,
            @Field("f_comment") String strComment,
            @Field("f_token") String f_token,
            @Field("f_device") String f_device
    );

}