package com.example.admob.Pojo.Counter;public class Counter{    private Data data;    public Data getData ()    {        return data;    }    public void setData (Data data)    {        this.data = data;    }    /*               r19 = this;               r0 = r19               super.onCreate(r20)               java.lang.String r1 = "speedometer_preferences"               r2 = 0               android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)               r0.preferences = r1               java.lang.String r3 = "darkMode"               r4 = 1               boolean r1 = r1.getBoolean(r3, r4)               r0.dark_mode = r1               java.lang.String r3 = "burgundy"               java.lang.String r5 = "displayColor"               java.lang.String r6 = "bgColor"               java.lang.String r7 = "black"               java.lang.String r8 = "skin"               java.lang.String r9 = "red"               if (r1 == 0) goto L_0x0036               android.content.SharedPreferences r1 = r0.preferences               java.lang.String r1 = r1.getString(r6, r7)               r0.bgColor = r1               android.content.SharedPreferences r1 = r0.preferences               java.lang.String r1 = r1.getString(r5, r9)               r0.displayColor = r1               goto L_0x0046           L_0x0036:               android.content.SharedPreferences r1 = r0.preferences               java.lang.String r1 = r1.getString(r6, r8)               r0.bgColor = r1               android.content.SharedPreferences r1 = r0.preferences               java.lang.String r1 = r1.getString(r5, r3)               r0.displayColor = r1*/    @Override    public String toString()    {        return "ClassPojo [data = "+data+"]";    }}						