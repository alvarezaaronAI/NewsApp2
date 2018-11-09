package com.alvarezaaronai.newsapp;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {
    /**
     * These utilities will be used to communicate with the network.
     */
    final static String NEWSAPP_BASE_URL =
            "https://newsapi.org/v1/articles";
    final static String PARAM_QUERY = "source";
    final static String QUERY_VAL = "the-next-web";
    final static String PARAM_SORT = "sortBy";
    final static String SORT_VAL = "latest";
    final static String PARAM_API = "apiKey";
    final static String APIKEY_VAL = "f58eb6e9d24a424289aa8acbe8c753a1";

    public static URL buildUrl(String newsAppSearchQuery) {
        Uri builtUri = Uri.parse(NEWSAPP_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, QUERY_VAL)
                .appendQueryParameter(PARAM_SORT,SORT_VAL)
                .appendQueryParameter(PARAM_API,APIKEY_VAL)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }
    /**
     * This method returns the entire result from the HTTP response.
     *
     * @param url The URL to fetch the HTTP response from.
     * @return The contents of the HTTP response.
     * @throws IOException Related to network and stream reading
     */

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
