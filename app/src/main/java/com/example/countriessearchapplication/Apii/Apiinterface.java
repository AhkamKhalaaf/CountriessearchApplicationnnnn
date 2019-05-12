package com.example.countriessearchapplication.Apii;

import com.example.countriessearchapplication.mOdels.Countrymodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Apiinterface {
    @GET("rest/v2/name/{name}")
    Call<ArrayList<Countrymodel>>getSearchresult(@Path("name")String name);
}
