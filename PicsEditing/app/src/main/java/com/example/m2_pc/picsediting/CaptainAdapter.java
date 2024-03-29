package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by M2-pc on 10/3/2018.
 */

public class CaptainAdapter extends BaseAdapter{

    int[] captain = new int[] {R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
            R.drawable.c11,R.drawable.c12,R.drawable.c13,R.drawable.c14,R.drawable.c15,R.drawable.c16,R.drawable.c17,R.drawable.c18,R.drawable.c19,R.drawable.c20,
            R.drawable.c21,R.drawable.c22,R.drawable.c23,R.drawable.c24,R.drawable.c25,R.drawable.c26,R.drawable.c27,R.drawable.c28,R.drawable.c29,R.drawable.c30,
            R.drawable.c31,R.drawable.c32,R.drawable.c33,R.drawable.c34,R.drawable.c35,R.drawable.c36,R.drawable.c37,R.drawable.c38,R.drawable.c39,R.drawable.c40,
            R.drawable.c41,R.drawable.c42,R.drawable.c43,R.drawable.c44,R.drawable.c45,R.drawable.c46};

    Activity activity;
    LayoutInflater inflater;

    public CaptainAdapter(EditingActivity editingActivity) {

        activity = editingActivity;
        inflater = LayoutInflater.from(editingActivity);
    }



    @Override
    public int getCount() {
        return captain.length;
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

        ViewHolder holder;
        if (view == null)
        {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.items, viewGroup, false);
            holder.imageView = (ImageView) view.findViewById(R.id.imageview);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(activity).load(captain[i]).into(holder.imageView);


        return view;
    }

    public class ViewHolder {
        ImageView imageView;
    }


}
