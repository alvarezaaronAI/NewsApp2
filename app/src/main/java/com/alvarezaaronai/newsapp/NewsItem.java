package com.alvarezaaronai.newsapp;

import org.json.JSONObject;

public class NewsItem {

    //Json Val is "title"
    private String title;
    //Json Val is "author"
    private String author;
    //Json val is "description"
    private String description;
    //Json Val is "url"
    private String url;
    //Json Val is "urlToImage"
    private String imageUrl;
    //Json Val is "publishedAt"
    private String date;


    public NewsItem (){
        title = "UBG goes free-to-play on Xbox to combat waning interest";
        author = "Rachel Kaser";
        description = "Microsoft today revealed PlayerUnknown's Battlegrounds would be free-to-play this weekend, the first time the game has ever been free on that platform. It's a pleasant surprise for ...";
        url = "https://thenextweb.com/gaming/2018/11/08/pubg-free-weekend-xbox-player-interest/";
        imageUrl = "https://img-cdn.tnwcdn.com/image/tnw?filter_last=1&fit=1280%2C640&url=https%3A%2F%2Fcdn0.tnwcdn.com%2Fwp-content%2Fblogs.dir%2F1%2Ffiles%2F2017%2F12%2FPUBG.jpg&signature=78bb6051436b903034b703931b891605";
        date = "2018-11-08T09:34:58Z";
    }

    public NewsItem(String author,String title, String description, String url, String imageUrl, String date) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.url = url;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public NewsItem(String titleTemp, String descriptionTemp, String dateTemp) {
        this.title = titleTemp;
        this.description = descriptionTemp;
        this.date = dateTemp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
