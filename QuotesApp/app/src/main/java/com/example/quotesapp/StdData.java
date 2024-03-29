package com.example.quotesapp;

public class StdData {
    public int id;
    public String text;
    public String cate;

    public String lang;

    public StdData() {
    }

    public StdData(int id, String text, String cate, String lang) {
        this.id = id;
        this.text = text;
        this.cate = cate;
        this.lang = lang;
    }

}
