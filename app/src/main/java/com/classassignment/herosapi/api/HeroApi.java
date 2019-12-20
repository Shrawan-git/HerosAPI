package com.classassignment.herosapi.api;

import com.classassignment.herosapi.LoginActivity;
import com.classassignment.herosapi.model.Hero_cud;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface HeroApi {

    @POST("users/login")
    Call<Void> loginUser(@Body Hero_cud hero_cud );

    @POST("users/signup")
    Call<Void> registerUser(@Body Hero_cud hero_cud );

}
