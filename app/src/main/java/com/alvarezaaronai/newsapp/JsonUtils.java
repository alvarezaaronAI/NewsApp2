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
            Log.d(TAG, "parseNews: --- --- " + articles);

            for(int art = 0; art < articles.length(); art++ ) {
                //Strings for every Key
                JSONObject a = articles.getJSONObject(art);
                String titleTemp = a.getString("title");
                String descriptionTemp = a.getString("description");
                String dateTemp = a.getString("publishedAt");
                String authorTemp = a.getString("author");
                String urlTemp = a.getString("url");
                String urlImage = a.getString("urlToImage");

                Log.d(TAG, "parseNews: \n"
                        + authorTemp + "\n"
                        + titleTemp + "\n"
                        + descriptionTemp + "\n"
                        + urlTemp + "\n"
                        + urlImage + "\n"
                        + dateTemp + "\n");
                //Creating a NewsTemp
                NewsItem tempNewsItem = new NewsItem("Title" + titleTemp, descriptionTemp,dateTemp,authorTemp,urlTemp,urlImage);
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
