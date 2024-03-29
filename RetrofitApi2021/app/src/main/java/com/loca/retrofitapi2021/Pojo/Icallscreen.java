package com.loca.retrofitapi2021.Pojo;

import java.util.ArrayList;

public class Icallscreen
{
    private String baseURL;

    private ArrayList<Data> data;

    private String message;

    private String status;

    public String getBaseURL ()
    {
        return baseURL;
    }

    public void setBaseURL (String baseURL)
    {
        this.baseURL = baseURL;
    }

    public ArrayList<Data>  getData ()
    {
        return data;
    }

    public void setData (ArrayList<Data>  data)
    {
        this.data = data;
    }

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [baseURL = "+baseURL+", data = "+data+", message = "+message+", status = "+status+"]";
    }
}
			
