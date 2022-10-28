package com.example.quotesapp.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.quotesapp.models.Quotes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class QuoteViewModel extends ViewModel {
    public MutableLiveData<ArrayList<Quotes>> convertedData = new MutableLiveData<>();

    public void convertFile(String pulledJson){
        ArrayList<Quotes> quoteList = new Gson().fromJson(pulledJson,
                new TypeToken<ArrayList<Quotes>>() {}.getType());
        convertedData.setValue(quoteList);
    }
}
