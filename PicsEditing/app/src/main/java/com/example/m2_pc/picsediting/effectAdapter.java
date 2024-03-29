package com.example.m2_pc.picsediting;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by M2-pc on 10/3/2018.
 */

public class effectAdapter extends RecyclerView.Adapter<effectAdapter.ViewHolder>{

    Activity activity;
    List<ModelData> dataList;
    LayoutInflater inflater;

    public effectAdapter(EditingActivity editingActivity, List<ModelData> dataList) {
        activity = editingActivity;
        this.dataList = dataList;
        inflater = LayoutInflater.from(editingActivity);

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.effect,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        switch (position)
        {

            case 0:
                Effects.applyEffectNone(holder.imageView);
                break;

            case 1:
                Effects.harsh1(holder.imageView);
                break;

            case 2:
                Effects.harsh2(holder.imageView);
                break;

            case 3:
                Effects.harsh3(holder.imageView);
                break;

            case 4:
                Effects.harsh4(holder.imageView);
                break;

            case 5:
                Effects.harsh5(holder.imageView);
                break;

            case 6:
                Effects.harsh6(holder.imageView);
                break;

            case 7:
                Effects.applyEffect1(holder.imageView);
                break;

            case 8:
                Effects.applyEffect2(holder.imageView);
                break;

            case 9:
                Effects.applyEffect3(holder.imageView);
                break;

            case 10:
                Effects.applyEffect4(holder.imageView);
                break;

            case 11:
                Effects.applyEffect5(holder.imageView);
                break;

            case 12:
                Effects.applyEffect6(holder.imageView);
                break;

            case 13:
                Effects.applyEffect7(holder.imageView);
                break;

            case 14:
                Effects.applyEffect8(holder.imageView);
                break;

            case 15:
                Effects.applyEffect9(holder.imageView);
                break;

            case 16:
                Effects.applyEffect10(holder.imageView);
                break;

            case 17:
                Effects.applyEffect11(holder.imageView);
                break;

            case 18:
                Effects.applyEffect12(holder.imageView);
                break;

            case 19:
                Effects.applyEffect13(holder.imageView);
                break;

            case 20:
                Effects.applyEffect14(holder.imageView);
                break;

            case 21:
                Effects.applyEffect15(holder.imageView);
                break;

            case 22:
                Effects.applyEffect16(holder.imageView);
                break;

            case 23:
                Effects.applyEffect17(holder.imageView);
                break;

            case 24:
                Effects.applyEffect18(holder.imageView);
                break;

            case 25:
                Effects.applyEffect19(holder.imageView);
                break;

            case 26:
                Effects.applyEffect20(holder.imageView);
                break;

            case 27:
                Effects.applyEffect21(holder.imageView);
                break;

            case 28:
                Effects.applyEffect22(holder.imageView);
                break;

        }

        holder.imageView.setImageResource(dataList.get(position).getEffect());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditingActivity)activity).setEffect(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.effect1);

        }
    }

}
