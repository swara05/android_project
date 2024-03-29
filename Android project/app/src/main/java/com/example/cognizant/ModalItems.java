package com.example.cognizant;

public class ModalItems {
    private String text;
    private String desc;
    private int picture;


    public ModalItems(String text, String desc, int picture) {
        this.text = text;
        this.desc = desc;
        this.picture = picture;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
