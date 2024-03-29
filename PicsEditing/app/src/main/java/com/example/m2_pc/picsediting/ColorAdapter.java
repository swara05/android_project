package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by M2-pc on 10/5/2018.
 */

public class ColorAdapter extends BaseAdapter {

    Activity activity;
    List<ColorData> dataList;
    LayoutInflater inflater;

    public ColorAdapter(TextActivity textActivity, List<ColorData> dataList) {

        activity = textActivity;
        this.dataList = dataList;
        inflater = LayoutInflater.from(textActivity);

    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.color_grid,viewGroup,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.colorbox);
        imageView.setBackgroundColor(Color.parseColor(  dataList.get(i).getColor1()));

        return view;
    }
}
