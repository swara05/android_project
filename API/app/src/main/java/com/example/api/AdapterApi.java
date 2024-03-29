package com.example.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterApi extends RecyclerView.Adapter<AdapterApi.ViewHolder> {

    ArrayList<Data> list;
    Context context;

    public AdapterApi(ArrayList<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.startapp_source.setText("StratApp source : " +list.get(position).getStartapp_source());
        holder.google_native.setText("Google native : " +list.get(position).getGoogle_native());
        holder.rating.setText("Rating : "+list.get(position).getRating());
        holder.fb_banner.setText("Fb banner : "+list.get(position).getFb_banner());
        holder.fb_source.setText("Fb source : "+list.get(position).getFb_source());
        holder.fb_interstitial_two.setText("Fb Interstitial two : "+list.get(position).getFb_interstitial_two());
        holder.fb_native_three.setText("Fb native three : "+list.get(position).getFb_native_three());
        holder.fb_interstitial_three.setText("Fb intersitial three : "+list.get(position).getFb_interstitial_three());
        holder.google_source.setText("Google source : "+list.get(position).getGoogle_source());
        holder.visible_extra.setText("Visible extra : " +list.get(position).getVisible_extra());
        holder.google_banner.setText(" Google banner : "+list.get(position).getGoogle_banner());
        holder.google_interstitial.setText("Google interstitial : "+list.get(position).getGoogle_interstitial());
        holder.fb_interstitial.setText("Fb interstitial : "+list.get(position).getFb_interstitial());
        holder.fb_native.setText("Fb native : "+list.get(position).getFb_native());
        holder.startapp_id.setText("Startapp id : "+list.get(position).getStartapp_id());
        holder.app_status.setText("App_status : "+list.get(position).getApp_status());
        holder.fb_native_two.setText("Fb native two : "+list.get(position).getFb_native_two());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{

        TextView startapp_source,google_native,rating,fb_banner,fb_source,fb_interstitial_two,fb_native_three,
                fb_interstitial_three,google_source,visible_extra,google_banner,google_interstitial,fb_interstitial,fb_native,
                startapp_id,app_status,fb_native_two;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fb_interstitial_two = itemView.findViewById(R.id.fb_interstitial_two);
            startapp_source = itemView.findViewById(R.id.startapp_source);
            google_native = itemView.findViewById(R.id.google_native);
            rating = itemView.findViewById(R.id.rating);
            fb_banner = itemView.findViewById(R.id.fb_banner);
            fb_source = itemView.findViewById(R.id.fb_source);
            fb_native_three = itemView.findViewById(R.id.fb_native_three);
            fb_interstitial_three = itemView.findViewById(R.id.fb_interstitial_three);
            google_source = itemView.findViewById(R.id.google_source);
            visible_extra = itemView.findViewById(R.id.visible_extra);
            google_banner = itemView.findViewById(R.id.google_banner);
            google_interstitial = itemView.findViewById(R.id.google_interstitial);
            fb_interstitial = itemView.findViewById(R.id.fb_interstitial);
            fb_native = itemView.findViewById(R.id.fb_native);
            startapp_id = itemView.findViewById(R.id.startapp_id);
            app_status = itemView.findViewById(R.id.app_status);
            fb_native_two = itemView.findViewById(R.id.fb_native_two);

        }
    }
}
