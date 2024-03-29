package com.example.mobilenumberlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int img[];
    String[] cardName;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] img, String[] cardName) {
        this.context = applicationContext;
        this.img = img;
        this.cardName = cardName;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.card_spinner, null);
        ImageView icon = (ImageView) view.findViewById(R.id.image_view);
        TextView names = (TextView) view.findViewById(R.id.text_view);
        icon.setImageResource(img[i]);
        names.setText(cardName[i]);
        return view;
    }
}
