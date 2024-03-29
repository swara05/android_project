package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by M2-pc on 10/1/2018.
 */

public class IpAdapter extends BaseAdapter{

    int[] ip = new int[] {R.drawable.ip1,R.drawable.ip2,R.drawable.ip3,R.drawable.ip4,R.drawable.ip5,R.drawable.ip6,R.drawable.ip7,R.drawable.ip8,R.drawable.ip9,R.drawable.ip10,
            R.drawable.ip11,R.drawable.ip12,R.drawable.ip13,R.drawable.ip14,R.drawable.ip15,R.drawable.ip16,R.drawable.ip17,R.drawable.ip18,R.drawable.ip19,R.drawable.ip20,
            R.drawable.ip21,R.drawable.ip22,R.drawable.ip23,R.drawable.ip24,R.drawable.ip25,R.drawable.ip26,R.drawable.ip27,R.drawable.ip28,R.drawable.ip29,R.drawable.ip30,
            R.drawable.ip31,R.drawable.ip32,R.drawable.ip33,R.drawable.ip34,R.drawable.ip35,R.drawable.ip36,R.drawable.ip37,R.drawable.ip38,R.drawable.ip39,R.drawable.ip40,
            R.drawable.ip41,R.drawable.ip42,R.drawable.ip43,R.drawable.ip44,R.drawable.ip45,R.drawable.ip46,R.drawable.ip47,R.drawable.ip48,R.drawable.ip49,R.drawable.ip50,
            R.drawable.ip51,R.drawable.ip52,R.drawable.ip53,R.drawable.ip54,R.drawable.ip55,R.drawable.ip56,R.drawable.ip57,R.drawable.ip58,R.drawable.ip59};

    Activity activity;
    LayoutInflater inflater;

    public IpAdapter(EditingActivity editingActivity) {

        activity = editingActivity;
        inflater = LayoutInflater.from(editingActivity);

    }

    @Override
    public int getCount() {
        return ip.length;
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
        if (view==null)
        {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.heros,viewGroup,false);
            holder.imageView = (ImageView)view.findViewById(R.id.imageview);
            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)view.getTag();
        }

        Glide.with(activity).load(ip[i]).into(holder.imageView);
        return view;
    }

    public class ViewHolder {
        ImageView imageView;
    }
}
