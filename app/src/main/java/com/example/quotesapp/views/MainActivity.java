package com.example.quotesapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.quotesapp.R;
import com.example.quotesapp.models.Quotes;
import com.example.quotesapp.utils.DataUtil;
import com.example.quotesapp.viewmodels.QuoteViewModel;

public class MainActivity extends AppCompatActivity {
TextView test;
DataUtil data = new DataUtil();
String jsonString = null;
QuoteViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.testText);

        //pull JSON data as string
        jsonString = data.loadFile(this);
        viewModel = new ViewModelProvider(this).get(QuoteViewModel.class);

        getData();
    }

    public void getData(){

        //have viewmodel convert to object
        if (jsonString != null){
            viewModel.convertFile(jsonString);
        }

        viewModel.convertedData.observe(this, quotes -> {
            if (quotes != null){
                for (Quotes q: quotes){
                    test.setText(q.getQuote());
                }
            }
        });

    }
}