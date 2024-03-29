package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by M2-pc on 9/27/2018.
 */

public class EmojiAdapter extends BaseAdapter {

    Activity activity;
    LayoutInflater inflater;

    int[] images2 = new int[]{R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4, R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8, R.drawable.i9, R.drawable.i10,
            R.drawable.i11, R.drawable.i12, R.drawable.i13, R.drawable.i14, R.drawable.i15, R.drawable.i16, R.drawable.i17, R.drawable.i18, R.drawable.i19, R.drawable.i20,
            R.drawable.i21, R.drawable.i22, R.drawable.i23, R.drawable.i24, R.drawable.i25, R.drawable.i26, R.drawable.i27, R.drawable.i28, R.drawable.i29, R.drawable.i30,
            R.drawable.i31, R.drawable.i32, R.drawable.i33, R.drawable.i34, R.drawable.i35, R.drawable.i36, R.drawable.i37, R.drawable.i38, R.drawable.i39, R.drawable.i40,
            R.drawable.i41, R.drawable.i42, R.drawable.i43, R.drawable.i44, R.drawable.i45, R.drawable.i46, R.drawable.i47, R.drawable.i48, R.drawable.i49, R.drawable.i50,
            R.drawable.i51, R.drawable.i52, R.drawable.i53, R.drawable.i54, R.drawable.i55, R.drawable.i56, R.drawable.i57, R.drawable.i58, R.drawable.i59, R.drawable.i60,
            R.drawable.i61, R.drawable.i62, R.drawable.i63, R.drawable.i64, R.drawable.i65, R.drawable.i66, R.drawable.i67, R.drawable.i68, R.drawable.i69, R.drawable.i70,
            R.drawable.i71, R.drawable.i72, R.drawable.i73, R.drawable.i74, R.drawable.i75, R.drawable.i76, R.drawable.i77, R.drawable.i78, R.drawable.i79, R.drawable.i80,
            R.drawable.i81, R.drawable.i82, R.drawable.i83, R.drawable.i84, R.drawable.i85, R.drawable.i86, R.drawable.i87, R.drawable.i88, R.drawable.i89, R.drawable.i90,
            R.drawable.i91, R.drawable.i92, R.drawable.i93, R.drawable.i94, R.drawable.i95, R.drawable.i96, R.drawable.i97, R.drawable.i98, R.drawable.i99, R.drawable.i100,
            R.drawable.i111, R.drawable.i112, R.drawable.i113, R.drawable.i114, R.drawable.i115, R.drawable.i116, R.drawable.i117, R.drawable.i118, R.drawable.i119, R.drawable.i120,
            R.drawable.i121, R.drawable.i122, R.drawable.i123, R.drawable.i124, R.drawable.i125, R.drawable.i126, R.drawable.i127};

    public EmojiAdapter(EditingActivity editingActivity) {

        activity = editingActivity;
        inflater = LayoutInflater.from(editingActivity);

    }

    @Override
    public int getCount() {
        return images2.length;
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
//        holder.imageView.setImageResource(images2[i]);
        Glide.with(activity).load(images2[i]).into(holder.imageView);
        return view;
    }

    public class ViewHolder {
        ImageView imageView;
    }
}
