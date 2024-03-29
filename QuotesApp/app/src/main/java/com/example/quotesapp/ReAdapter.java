package com.example.quotesapp;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.Reholder> {
    Activity activity;
    List<StdData> dataList = new ArrayList<>();
    String a;

    private static final String TAG = "ReAdapter";

    public ReAdapter(cat cat, List<StdData> dataList) {
        activity = cat;
        this.dataList = dataList;
    }


    @Override
    public Reholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.layout, parent, false);
        return new Reholder(view);
    }

    @Override
    public void onBindViewHolder(Reholder holder, int position) {

        holder.text.setText(dataList.get(position).text);

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Reholder extends RecyclerView.ViewHolder {
        TextView text, dem, text1;
        LinearLayout linearLayout;

        public Reholder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            linearLayout = itemView.findViewById(R.id.layout_id);
        }
    }
}
