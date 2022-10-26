package com.example.quotesapp.views;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.example.quotesapp.R;
import com.example.quotesapp.adapters.QuoteAdapter;
import com.example.quotesapp.models.Quotes;
import com.example.quotesapp.utils.DataUtil;
import com.example.quotesapp.viewmodels.QuoteViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataUtil data = new DataUtil();
    String jsonString = null;
    QuoteViewModel viewModel;
    QuoteAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //pull JSON data as string
        jsonString = data.loadFile(this);
        viewModel = new ViewModelProvider(this).get(QuoteViewModel.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //on scroll, snap to position
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        getData();
    }

    public void getData(){
        ArrayList<Integer> speeds = new ArrayList<>();

        //have viewModel convert string to object
        if (jsonString != null){
            viewModel.convertFile(jsonString);
        }
        viewModel.convertedData.observe(this, quotes -> {
            if (quotes != null) {
                adapter = new QuoteAdapter(quotes, this);
                recyclerView.setAdapter(adapter);

                for (Quotes quote : quotes) {
                    speeds.add(quote.getSlideTransitionDelay());
                }
            }
        });
        setScroll(speeds);
    }

    public void setScroll(ArrayList<Integer> list){
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            boolean next = true;
            @Override
            public void run() {
                if(count < adapter.getItemCount()){
                    if(count==adapter.getItemCount()-1){
                        next = false;
                    }else if(count == 0){
                        next = true;
                    }
                    if(next) count++;
                    else count = 0;

                    //scroll to next slide after slideTransitionDelay
                    recyclerView.smoothScrollToPosition(count);
                    handler.postDelayed(this, list.get(count));
                }
            }
        };
        handler.postDelayed(runnable, 1200);
    }

}
