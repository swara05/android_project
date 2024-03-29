package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by M2-pc on 9/27/2018.
 */

class MyAdapter extends BaseAdapter{

    Activity activity;
    LayoutInflater inflater;

    int[] images = new int[] {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8,R.drawable.a9,R.drawable.a10,
            R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.a16,R.drawable.a17,R.drawable.a18,R.drawable.a19,R.drawable.a20,
            R.drawable.a21,R.drawable.a22,R.drawable.a23,R.drawable.a24,R.drawable.a25,R.drawable.a26,R.drawable.a27,R.drawable.a28,R.drawable.a29,R.drawable.a30,
            R.drawable.a31,R.drawable.a32,R.drawable.a33,R.drawable.a34,R.drawable.a35,R.drawable.a36,R.drawable.a37,R.drawable.a38,R.drawable.a39,R.drawable.a40,
            R.drawable.a41,R.drawable.a42,R.drawable.a43,R.drawable.a44,R.drawable.a45,R.drawable.a46,R.drawable.a47,R.drawable.a48,R.drawable.a49,
            R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,
            R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20,
            R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25,R.drawable.p26,R.drawable.p27,R.drawable.p28,R.drawable.p29,R.drawable.p30,
            R.drawable.p31,R.drawable.p32,R.drawable.p33,R.drawable.p34,R.drawable.p35,R.drawable.p36,R.drawable.p37,R.drawable.p38,R.drawable.p39,R.drawable.p40,
            R.drawable.p41,R.drawable.p42,R.drawable.p43,R.drawable.p44,R.drawable.p45,R.drawable.p46,R.drawable.p47,R.drawable.p48,R.drawable.p49,R.drawable.p50};


    public MyAdapter(EditingActivity editingActivity) {

        activity = editingActivity;
        inflater = LayoutInflater.from(editingActivity);

    }

    @Override
    public int getCount() {
        return images.length;
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

        view = inflater.inflate(R.layout.items,viewGroup,false);
        ImageView imageView=(ImageView)view.findViewById(R.id.imageview);
        imageView.setImageResource(images[i]);
        return view;
    }
}
