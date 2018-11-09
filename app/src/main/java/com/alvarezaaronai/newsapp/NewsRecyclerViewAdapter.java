package com.alvarezaaronai.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsItemViewHolder> {
    private static final String TAG = "NewsRecyclerViewAdapter";
     ArrayList<NewsItem> mNewsList;
    final private NewsListItemClickListner mOnClickListener;

    public interface NewsListItemClickListner {
        void onListItemListener(int clickedItemIndex);
    }
    public NewsRecyclerViewAdapter(ArrayList<NewsItem> newsListIn , NewsListItemClickListner listener){
        mOnClickListener = listener;
        mNewsList = newsListIn;
    }

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.news_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);

        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsItemViewHolder newsItemViewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called");
        newsItemViewHolder.mTitle.setText(mNewsList.get(i).getTitle());
        newsItemViewHolder.mDescription.setText(mNewsList.get(i).getDescription());
        newsItemViewHolder.mDate.setText(mNewsList.get(i).getDate());
        Log.d(TAG, "onBindViewHolder: " + mNewsList.get(i).getTitle() + mNewsList.get(i).getDescription() + mNewsList.get(i).getDate());
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + mNewsList.size());
        return mNewsList.size();
    }

    // Class that creates a NewsItemViewHolder
    public class NewsItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //Member Variables for the Layout
        private TextView mTitle;
        private TextView mDescription;
        private TextView mDate;
        //-------------------------------
        //Creates a new NewsItemViewHolder
        public NewsItemViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.tv_news_title);
            mDescription = (TextView) itemView.findViewById(R.id.tv_news_description);
            mDate = (TextView) itemView.findViewById(R.id.tv_news_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemListener(clickedPosition);
        }
    }
}
