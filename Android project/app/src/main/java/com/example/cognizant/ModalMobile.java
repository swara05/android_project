package com.example.cognizant;

public class ModalMobile {
    private int mimg;
    private String mname;

    public ModalMobile(int mimg, String mname) {
        this.mimg = mimg;
        this.mname = mname;
    }

    public int getMimg() {
        return mimg;
    }

    public void setMimg(int mimg) {
        this.mimg = mimg;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
