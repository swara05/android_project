package com.loca.retrofitapi2021.Pojo.Coingecko;

public class Roi
{
    private String times;

    private String percentage;

    private String currency;

    public String getTimes ()
    {
        return times;
    }

    public void setTimes (String times)
    {
        this.times = times;
    }

    public String getPercentage ()
    {
        return percentage;
    }

    public void setPercentage (String percentage)
    {
        this.percentage = percentage;
    }

    public String getCurrency ()
    {
        return currency;
    }

    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [times = "+times+", percentage = "+percentage+", currency = "+currency+"]";
    }
}