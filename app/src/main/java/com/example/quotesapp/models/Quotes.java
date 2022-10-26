package com.example.quotesapp.models;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Quotes {
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("slideTransitionDelay")
    @Expose
    private Integer slideTransitionDelay;

    public Quotes(String quote, String author, Integer slideTransitionDelay) {
        this.quote = quote;
        this.author = author;
        this.slideTransitionDelay = slideTransitionDelay;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getSlideTransitionDelay() {
        return slideTransitionDelay;
    }

    public void setSlideTransitionDelay(Integer slideTransitionDelay) {
        this.slideTransitionDelay = slideTransitionDelay;
    }
}
