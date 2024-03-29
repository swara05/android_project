package com.example.cognizant;

public class ModalBag {
    private int bimg;
    private String bname;

    public ModalBag(int bimg, String bname) {
        this.bimg = bimg;
        this.bname = bname;
    }

    public int getBimg() {
        return bimg;
    }

    public void setBimg(int bimg) {
        this.bimg = bimg;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
