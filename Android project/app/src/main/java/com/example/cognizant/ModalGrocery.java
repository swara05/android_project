package com.example.cognizant;

public class ModalGrocery {
    private int groimg;
    private String gname;

    public ModalGrocery(int groimg, String gname) {
        this.groimg = groimg;
        this.gname = gname;
    }

    public int getGroimg() {
        return groimg;
    }

    public void setGroimg(int groimg) {
        this.groimg = groimg;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
}
