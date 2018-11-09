package com.alvarezaaronai.newsapp;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<NewsItem> parseNews(String JSONString){
        ArrayList<NewsItem> newsItemsTemp = new ArrayList<>();

        try {
            JSONObject news = new JSONObject(JSONString);
            JSONObject articles = news.getJSONObject("articles");

            int articlesSize = articles.length();
            for(int art = 0; art > articlesSize; art++ ) {
                //Strings for every Key
                String titleTemp = articles.getString("title");
                String authorTemp = articles.getString("author");
                String descriptionTemp = articles.getString("description");
                String urlTemp = articles.getString("url");
                String urlImageTemp = articles.getString("imageToUrl");
                String dateImageTemp = articles.getString("publishedAt");
                //Creating a NewsTemp
                NewsItem tempNewsItem = new NewsItem(titleTemp, authorTemp, descriptionTemp, urlTemp, urlImageTemp, dateImageTemp);
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


