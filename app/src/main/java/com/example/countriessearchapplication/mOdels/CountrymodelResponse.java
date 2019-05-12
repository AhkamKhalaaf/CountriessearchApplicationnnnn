package com.example.countriessearchapplication.mOdels;

import java.util.ArrayList;

public class CountrymodelResponse {
    ArrayList<Countrymodel>arrayListdata;
    Throwable throwable;

    public CountrymodelResponse() {
    }

    public CountrymodelResponse(ArrayList<Countrymodel> arrayListdata ) {
        this.arrayListdata = arrayListdata;
        this.throwable = null;
    }

    public CountrymodelResponse(  Throwable throwable) {
        this.arrayListdata = null;
        this.throwable = throwable;
    }

    public ArrayList<Countrymodel> getArrayListdata() {
        return arrayListdata;
    }

    public void setArrayListdata(ArrayList<Countrymodel> arrayListdata) {
        this.arrayListdata = arrayListdata;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
