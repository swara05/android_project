package com.example.admob.Pojo;

public class Data
{
    private String google_native;

    private String startapp_source;

    private String fb_interstitial_two;

    private String fb_native_three;

    private String fb_banner;
    /*
               r19 = this;
               r0 = r19
               super.onCreate(r20)
               java.lang.String r1 = "speedometer_preferences"
               r2 = 0
               android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
               r0.preferences = r1
               java.lang.String r3 = "darkMode"
               r4 = 1
               boolean r1 = r1.getBoolean(r3, r4)
               r0.dark_mode = r1
               java.lang.String r3 = "burgundy"
               java.lang.String r5 = "displayColor"
               java.lang.String r6 = "bgColor"
               java.lang.String r7 = "black"
               java.lang.String r8 = "skin"
               java.lang.String r9 = "red"
               if (r1 == 0) goto L_0x0036
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r6, r7)
               r0.bgColor = r1
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r5, r9)
               r0.displayColor = r1
               goto L_0x0046
           L_0x0036:
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r6, r8)
               r0.bgColor = r1
               android.content.SharedPreferences r1 = r0.preferences
               java.lang.String r1 = r1.getString(r5, r3)
               r0.displayColor = r1*/
    private String rating;

    private String fb_source;

    private String fb_interstitial_three;

    private String google_source;

    private String visible_extra;

    private String google_banner;

    private String google_interstitial;

    private String fb_interstitial;

    private String fb_native;

    private String startapp_id;

    private String app_status;

    private String fb_native_two;

    public String getGoogle_native ()
    {
        return google_native;
    }

    public void setGoogle_native (String google_native)
    {
        this.google_native = google_native;
    }

    public String getStartapp_source ()
    {
        return startapp_source;
    }

    public void setStartapp_source (String startapp_source)
    {
        this.startapp_source = startapp_source;
    }

    public String getFb_interstitial_two ()
    {
        return fb_interstitial_two;
    }

    public void setFb_interstitial_two (String fb_interstitial_two)
    {
        this.fb_interstitial_two = fb_interstitial_two;
    }

    public String getFb_native_three ()
    {
        return fb_native_three;
    }

    public void setFb_native_three (String fb_native_three)
    {
        this.fb_native_three = fb_native_three;
    }

    public String getFb_banner ()
    {
        return fb_banner;
    }

    public void setFb_banner (String fb_banner)
    {
        this.fb_banner = fb_banner;
    }

    public String getRating ()
    {
        return rating;
    }

    public void setRating (String rating)
    {
        this.rating = rating;
    }

    public String getFb_source ()
    {
        return fb_source;
    }

    public void setFb_source (String fb_source)
    {
        this.fb_source = fb_source;
    }

    public String getFb_interstitial_three ()
    {
        return fb_interstitial_three;
    }

    public void setFb_interstitial_three (String fb_interstitial_three)
    {
        this.fb_interstitial_three = fb_interstitial_three;
    }

    public String getGoogle_source ()
    {
        return google_source;
    }

    public void setGoogle_source (String google_source)
    {
        this.google_source = google_source;
    }

    public String getVisible_extra ()
    {
        return visible_extra;
    }

    public void setVisible_extra (String visible_extra)
    {
        this.visible_extra = visible_extra;
    }

    public String getGoogle_banner ()
    {
        return google_banner;
    }

    public void setGoogle_banner (String google_banner)
    {
        this.google_banner = google_banner;
    }

    public String getGoogle_interstitial ()
    {
        return google_interstitial;
    }

    public void setGoogle_interstitial (String google_interstitial)
    {
        this.google_interstitial = google_interstitial;
    }

    public String getFb_interstitial ()
    {
        return fb_interstitial;
    }

    public void setFb_interstitial (String fb_interstitial)
    {
        this.fb_interstitial = fb_interstitial;
    }

    public String getFb_native ()
    {
        return fb_native;
    }

    public void setFb_native (String fb_native)
    {
        this.fb_native = fb_native;
    }

    public String getStartapp_id ()
    {
        return startapp_id;
    }

    public void setStartapp_id (String startapp_id)
    {
        this.startapp_id = startapp_id;
    }

    public String getApp_status ()
    {
        return app_status;
    }

    public void setApp_status (String app_status)
    {
        this.app_status = app_status;
    }

    public String getFb_native_two ()
    {
        return fb_native_two;
    }

    public void setFb_native_two (String fb_native_two)
    {
        this.fb_native_two = fb_native_two;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [google_native = "+google_native+", startapp_source = "+startapp_source+", fb_interstitial_two = "+fb_interstitial_two+", fb_native_three = "+fb_native_three+", fb_banner = "+fb_banner+", rating = "+rating+", fb_source = "+fb_source+", fb_interstitial_three = "+fb_interstitial_three+", google_source = "+google_source+", visible_extra = "+visible_extra+", google_banner = "+google_banner+", google_interstitial = "+google_interstitial+", fb_interstitial = "+fb_interstitial+", fb_native = "+fb_native+", startapp_id = "+startapp_id+", app_status = "+app_status+", fb_native_two = "+fb_native_two+"]";
    }
}

