package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by M2-pc on 10/12/2018.
 */

public class SmokeAdapter extends BaseAdapter{

    Activity activity;
    List<SmokeData>dataList2;
    LayoutInflater inflater;

    public SmokeAdapter(TextActivity textActivity, List<SmokeData> dataList2) {

        activity = textActivity;
        this.dataList2 = dataList2;
        inflater = LayoutInflater.from(textActivity);

    }

    @Override
    public int getCount() {
        return dataList2.size();
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

        view = inflater.inflate(R.layout.smoke_grid,viewGroup,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.smoke_item);
        imageView.setImageResource(dataList2.get(i).getSmoke());

        return view;
    }
}
