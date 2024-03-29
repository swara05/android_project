package com.example.mobilenumberlocator;

public class Bankmodel {
    int bankimg;
    String bankname,acbal,custnum,mincon;
    public Bankmodel(String bankname, String acbal, String custnum, int bankimg, String mincon) {
        this.bankname = bankname;
        this.acbal = acbal;
        this.custnum = custnum;
        this.bankimg = bankimg;
        this.mincon = mincon;
    }

    public String getName() { return bankname; }
    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getacbal() { return acbal;}
    public void setAcbal(String acbal) {
        this.acbal = acbal;
    }

    public String getcustnum() { return custnum;}
    public void setCustnum(String custnum) {
        this.custnum = custnum;
    }

    public int getImg() { return bankimg;}
    public void setBankimg(int bankimg) {
        this.bankimg = bankimg;
    }

    public String getmincon() { return mincon;}
    public void setMincon(String mincon) {
        this.mincon = mincon;
    }
}
