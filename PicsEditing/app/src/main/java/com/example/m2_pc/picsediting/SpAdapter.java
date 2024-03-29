package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by M2-pc on 10/2/2018.
 */

public class SpAdapter extends BaseAdapter{

    int[] spiderman = new int[] {R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
            R.drawable.s11,R.drawable.s12,R.drawable.s13,R.drawable.s14,R.drawable.s15,R.drawable.s16,R.drawable.s17,R.drawable.s18,R.drawable.s19,R.drawable.s20,
            R.drawable.s21,R.drawable.s22,R.drawable.s23,R.drawable.s24,R.drawable.s25,R.drawable.s26,R.drawable.s27,R.drawable.s28,R.drawable.s29,R.drawable.s30,
            R.drawable.s31,R.drawable.s32,R.drawable.s33,R.drawable.s34,R.drawable.s35,R.drawable.s36,R.drawable.s37,R.drawable.s38,R.drawable.s39,R.drawable.s40,
            R.drawable.s41,R.drawable.s42,R.drawable.s43,R.drawable.s44,R.drawable.s45,R.drawable.s46,R.drawable.s47,R.drawable.s48,R.drawable.s49};

    Activity activity;
    LayoutInflater inflater;

    public SpAdapter(EditingActivity editingActivity) {

        activity = editingActivity;
        inflater = LayoutInflater.from(editingActivity);

    }

    @Override
    public int getCount() {
        return spiderman.length;
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

        Glide.with(activity).load(spiderman[i]).into(holder.imageView);
        return view;
    }

    public class ViewHolder {
        ImageView imageView;
    }
}
