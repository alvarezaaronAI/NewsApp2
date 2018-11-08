package com.alvarezaaronai.newsapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsItemViewHolder> {


    @NonNull
    @Override
    public NewsItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder newsItemViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Class that creates a NewsItemViewHolder
    public class NewsItemViewHolder extends RecyclerView.ViewHolder {

        //Creates a new NewsItemViewHolder
        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }
}
