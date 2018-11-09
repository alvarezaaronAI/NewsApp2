package com.alvarezaaronai.newsapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Log Cats
    private static final String TAG = "MainActivity";
    //Member variables
    private EditText mSearchBoxEditText;
    private TextView mUrlDisplayTextView;
    private TextView mSearchResultsTextView;
    //Member Variables Recycle View
    /*
     * References to RecyclerView and Adapter to reset the list to its
     * "pretty" state when the reset menu item is clicked.
     */
    private NewsRecyclerViewAdapter mAdapter;
    private RecyclerView mNewsItemList;
    //List of Items
    ArrayList<NewsItem> mNewsItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Setting Member Variables
        mSearchBoxEditText = (EditText) findViewById(R.id.et_search_box);
        mUrlDisplayTextView = (TextView) findViewById(R.id.tv_url_display);
        mNewsItemList = (RecyclerView) findViewById(R.id.news_recyclerview);
        //mSearchResultsTextView = (TextView) findViewById(R.id.tv_newsApp_search_results_json);
        //------------------------
        //Creating Recycle View---
        //A LinearLayoutManager is responsible for measuring and positioning item views within a RecyclerView into a linear list.
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mNewsItemList.setLayoutManager(layoutManager);
        mNewsItemList.setHasFixedSize(true);
        //------------------------
    }
    private void makeNewsAppSearchQuery() {
        String newsAppQuery = mSearchBoxEditText.getText().toString();
        URL newsAppSearchURL = NetworkUtils.buildUrl(newsAppQuery);
        mUrlDisplayTextView.setText(newsAppSearchURL.toString());
        new NewsAppQueryTask().execute(newsAppSearchURL);
    }

    public class NewsAppQueryTask extends AsyncTask<URL, Void, String> {

        //Override the doInBackground method to perform the query. Return the results.
        @Override
        protected String doInBackground(URL... params) {
            URL searchUrl = params[0];
            String newsAppSearchResults = null;
            try {
                newsAppSearchResults = NetworkUtils.getResponseFromHttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return newsAppSearchResults;
        }

        //Override onPostExecute to display the results in the TextView
        @Override
        protected void onPostExecute(String newsAppSearchResults) {
            if (newsAppSearchResults != null && !newsAppSearchResults.equals("")) {
                mNewsItems = JsonUtils.parseNews(newsAppSearchResults);
                mAdapter = new NewsRecyclerViewAdapter(mNewsItems);
                mNewsItemList.setAdapter(mAdapter);
            }
        }
    }
    //Override to create a search in toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.get_news, menu);
        return true;
    }
    //Override to create an action in the toolbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_refresh) {
            makeNewsAppSearchQuery();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
