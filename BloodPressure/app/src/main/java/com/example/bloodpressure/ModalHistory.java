package com.example.bloodpressure;

public class ModalHistory {

    String htime,hdate,hstatus,htag,hsys,hdis,hpls;

    public ModalHistory(String htime, String hdate, String hstatus, String htag, String hsys, String hdis, String hpls) {
        this.htime = htime;
        this.hdate = hdate;
        this.hstatus = hstatus;
        this.htag = htag;
        this.hsys = hsys;
        this.hdis = hdis;
        this.hpls = hpls;
    }

    public String getHtime() {
        return htime;
    }

    public void setHtime(String htime) {
        this.htime = htime;
    }

    public String getHdate() {
        return hdate;
    }

    public void setHdate(String hdate) {
        this.hdate = hdate;
    }

    public String getHstatus() {
        return hstatus;
    }

    public void setHstatus(String hstatus) {
        this.hstatus = hstatus;
    }

    public String getHtag() {
        return htag;
    }

    public void setHtag(String htag) {
        this.htag = htag;
    }

    public String getHsys() {
        return hsys;
    }

    public void setHsys(String hsys) {
        this.hsys = hsys;
    }

    public String getHdis() {
        return hdis;
    }

    public void setHdis(String hdis) {
        this.hdis = hdis;
    }

    public String getHpls() {
        return hpls;
    }

    public void setHpls(String hpls) {
        this.hpls = hpls;
    }


}
