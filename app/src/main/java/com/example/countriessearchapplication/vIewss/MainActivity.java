package com.example.countriessearchapplication.vIewss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.countriessearchapplication.AdapterCountries;
import com.example.countriessearchapplication.Apii.Apiclient;
import com.example.countriessearchapplication.R;
import com.example.countriessearchapplication.helperr.Checkinternetconeection;
import com.example.countriessearchapplication.mOdels.Countrymodel;
import com.example.countriessearchapplication.mOdels.CountrymodelResponse;
import com.example.countriessearchapplication.vIewmodels.Countriesviewmodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Countriesviewmodel countriesviewmodel;
    RecyclerView recyclerView;
    AdapterCountries adapterCountries;
    ArrayList<Countrymodel>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (Checkinternetconeection.isConnectToInternet(MainActivity.this))
                {

                   countriesviewmodel = ViewModelProviders.of(MainActivity.this).get(Countriesviewmodel.class);
                   countriesviewmodel.getCountries(editText.getText().toString()).observe(MainActivity.this, new Observer<CountrymodelResponse>() {
                       @Override
                       public void onChanged(CountrymodelResponse countrymodelResponse) {
                           if (countrymodelResponse.getArrayListdata()!=null)
                           {
                               arrayList = new ArrayList<>();
                               arrayList =countrymodelResponse.getArrayListdata();
                                       Toast.makeText(MainActivity.this, countrymodelResponse.getArrayListdata().size()+"",Toast.LENGTH_SHORT).show();

                             adapterCountries = new AdapterCountries(MainActivity.this,arrayList);
                             recyclerView.setAdapter(adapterCountries);
                             adapterCountries.notifyDataSetChanged();
                             recyclerView.setAdapter(adapterCountries);
                             recyclerView.hasFixedSize();

                           }
                           else  {
                               arrayList = new ArrayList<>();

                               adapterCountries = new AdapterCountries(MainActivity.this,arrayList);
                               recyclerView.setAdapter(adapterCountries);
                               adapterCountries.notifyDataSetChanged();
                               recyclerView.setAdapter(adapterCountries);
                               recyclerView.hasFixedSize();
                               Toast.makeText(MainActivity.this, "no result for your search",Toast.LENGTH_SHORT).show();
                           }
                       }
                   });


                }
                else
                {
                    Toast.makeText(MainActivity.this, "no internet connection",Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
