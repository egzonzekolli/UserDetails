package com.example.userdetails.api;

import com.example.userdetails.schema.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("users")
    Call<Example> getExample(
            @Query("per_page") int page
    );
}
