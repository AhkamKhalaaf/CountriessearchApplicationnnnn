package com.example.countriessearchapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countriessearchapplication.mOdels.Countrymodel;

import java.util.ArrayList;

public class AdapterCountries extends RecyclerView.Adapter<AdapterCountries.Myviewholder> {
    Context context;
    ArrayList<Countrymodel>arrayList;

    public AdapterCountries(Context context, ArrayList<Countrymodel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemcountry,parent,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        Countrymodel countrymodel = arrayList.get(position);
        holder.textViewcountryname.setText(countrymodel.getName().toString());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class Myviewholder  extends RecyclerView.ViewHolder{
        TextView textViewcountryname;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            textViewcountryname = itemView.findViewById(R.id.textView);
        }
    }
}
