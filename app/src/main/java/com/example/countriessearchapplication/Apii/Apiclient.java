package com.example.countriessearchapplication.Apii;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apiclient {
   private static Apiinterface apiinterface;

    public  static Apiinterface getInstance()
    {
        if (apiinterface==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://restcountries.eu/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(Apiinterface.class);
        }

            return apiinterface;

    }
}
