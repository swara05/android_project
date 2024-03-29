package com.loca.retrofitapi2021.Pojo;

public class Data
{
    private String image;

    private String image_name;

    private String updated_at;

    private String created_at;

    private String id;

    private String status;

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getImage_name ()
    {
        return image_name;
    }

    public void setImage_name (String image_name)
    {
        this.image_name = image_name;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
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
        return "ClassPojo [image = "+image+", image_name = "+image_name+", updated_at = "+updated_at+", created_at = "+created_at+", id = "+id+", status = "+status+"]";
    }
}
			
		