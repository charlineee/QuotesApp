package com.example.quotesapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotesapp.R;
import com.example.quotesapp.models.Quotes;

import java.util.ArrayList;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.ViewHolder>{
    public ArrayList<Quotes> quotesList;
    Context context;

    public QuoteAdapter(ArrayList<Quotes> quotesList, Context context) {
        this.quotesList = quotesList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuoteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteAdapter.ViewHolder holder, int position) {
        holder.quote.setText(quotesList.get(position).getQuote());
        holder.author.setText(quotesList.get(position).getAuthor());
    }

    @Override
    public int getItemCount() {
        if (quotesList == null){
            return 0;
        }
        return quotesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView quote;
        private final TextView author;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quote = itemView.findViewById(R.id.quote);
            author = itemView.findViewById(R.id.author);
        }
    }
}

