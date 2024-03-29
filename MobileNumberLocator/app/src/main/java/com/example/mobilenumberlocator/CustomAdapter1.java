package com.example.mobilenumberlocator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter1 extends BaseAdapter {
    Context context;
    int loc[];
    String[] state;
    LayoutInflater inflter;

    public CustomAdapter1(Context applicationContext, int[] loc, String[] state) {
        this.context = applicationContext;
        this.loc = loc;
        this.state = state;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return loc.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.card_spinner1, null);
        ImageView icon1 = (ImageView) view.findViewById(R.id.image);
        TextView names1 = (TextView) view.findViewById(R.id.text);
        icon1.setImageResource(loc[i]);
        names1.setText(state[i]);
        return view;
    }
}
