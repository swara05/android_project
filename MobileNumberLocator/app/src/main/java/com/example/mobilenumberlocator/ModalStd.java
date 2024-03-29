package com.example.mobilenumberlocator;

import android.content.Context;

import java.util.List;

public class ModalStd {
    String stdname;
    String stdcod;

    public ModalStd(String stdname, String stdcod) {
        this.stdname = stdname;
        this.stdcod = stdcod;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public String getStdcod() {
        return stdcod;
    }

    public void setStdcod(String stdcod) {
        this.stdcod = stdcod;
    }
}
