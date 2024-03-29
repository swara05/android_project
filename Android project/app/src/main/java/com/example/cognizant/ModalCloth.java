package com.example.cognizant;

public class ModalCloth {
    private String cname;
    private int img;

    public ModalCloth(String cname, int img) {
        this.cname = cname;
        this.img = img;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
