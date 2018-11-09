package com.alvarezaaronai.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    private static final String TAG = "JsonUtils";
    public static ArrayList<NewsItem> parseNews(String JSONString){
        ArrayList<NewsItem> newsItemsTemp = new ArrayList<>();
        Log.d(TAG, "parseNews: here");
        try {
            JSONObject news = new JSONObject(JSONString);
            JSONArray articles = news.getJSONArray("articles");

            int articlesSize = articles.length();
            for(int art = 0; art < articlesSize; art++ ) {
                //Strings for every Key
                JSONObject a = articles.getJSONObject(art);
                String authorTemp = a.getString("author");
                String titleTemp = a.getString("title");
                String descriptionTemp = a.getString("description");
                String urlTemp = a.getString("url");
                String urlImage = a.getString("urlToImage");
                String dateTemp = a.getString("publishedAt");

                Log.d(TAG, "parseNews: \n"
                        + authorTemp + "\n"
                        + titleTemp + "\n"
                        + descriptionTemp + "\n"
                        + urlTemp + "\n"
                        + urlImage + "\n"
                        + dateTemp + "\n");
                //Creating a NewsTemp
                NewsItem tempNewsItem = new NewsItem(authorTemp, titleTemp, descriptionTemp,urlTemp,urlImage,dateTemp);
                //Adding to the NewsItemTemp
                newsItemsTemp.add(tempNewsItem);
            }
            //----------------------
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Return and ArrayList of NewsItems
        return newsItemsTemp;
    }
}
