package com.example.apiintegration;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @Headers("content-Type: application/json")
    @GET("get-data.php")

   Call<AccountsInfo> getData();


    @POST("insert-accounts-data.php")
    Call<Insertinfo>  insertData(@Body Insertinfo insertinfo );




}

