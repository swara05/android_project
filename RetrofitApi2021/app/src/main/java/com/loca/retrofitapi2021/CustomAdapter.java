package com.loca.retrofitapi2021;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.loca.retrofitapi2021.Pojo.Data;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    private ArrayList<Data> arrayList = new ArrayList<>();
    private ImageView img;

    public CustomAdapter(Context context, ArrayList<Data> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView ==  null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        }
        TextView  txt;
        ImageView  image;
        image = (ImageView) convertView.findViewById(R.id.image);
        txt = (TextView) convertView.findViewById(R.id.txt);

        txt.setText(arrayList.get(position).getImage_name());

        Glide.with(convertView)
                .load("http://icallscreen.in/wallpaper/public/images/image/"+arrayList.get(position).getImage())
                .into(image);


        return convertView;
    }
}
