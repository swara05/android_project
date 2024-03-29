package com.example.mobilenumberlocator;

public class ModalTopup {

    private String num,shceme,period;

    public ModalTopup(String num, String shceme, String period) {
        this.num = num;
        this.shceme = shceme;
        this.period = period;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getShceme() {
        return shceme;
    }

    public void setShceme(String shceme) {
        this.shceme = shceme;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
