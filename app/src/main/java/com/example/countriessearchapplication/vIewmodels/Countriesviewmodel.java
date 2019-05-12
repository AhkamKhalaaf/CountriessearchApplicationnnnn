package com.example.countriessearchapplication.vIewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countriessearchapplication.Apii.Apiclient;
import com.example.countriessearchapplication.Apii.Apiinterface;
import com.example.countriessearchapplication.mOdels.Countrymodel;
import com.example.countriessearchapplication.mOdels.CountrymodelResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Countriesviewmodel extends ViewModel {
    Apiinterface apiinterface;
    MutableLiveData<CountrymodelResponse>mutableLiveData;
    CountrymodelResponse countrymodelResponse;

    public Countriesviewmodel() {
        apiinterface = Apiclient.getInstance();
    }

   public MutableLiveData<CountrymodelResponse>getCountries(String searchvalue)
    {
        countrymodelResponse = new CountrymodelResponse();
        mutableLiveData  = new MutableLiveData<>();
        apiinterface.getSearchresult(searchvalue)
                .enqueue(new Callback<ArrayList<Countrymodel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Countrymodel>> call, Response<ArrayList<Countrymodel>> response) {
                        if (response.isSuccessful() &&response.body()!=null)
                        {
                            countrymodelResponse.setArrayListdata(response.body());
                            mutableLiveData.setValue(countrymodelResponse);

                        }
                        else
                        {
                            countrymodelResponse.setArrayListdata(null);
                            mutableLiveData.setValue(countrymodelResponse);

                        }

                    }

                    @Override
                    public void onFailure(Call<ArrayList<Countrymodel>> call, Throwable t) {
                        countrymodelResponse.setThrowable(t);
                        mutableLiveData.setValue(countrymodelResponse);
                        Log.d("DDAATAAA", "kokoko");
                    }
                });
        return mutableLiveData;
    }
}
