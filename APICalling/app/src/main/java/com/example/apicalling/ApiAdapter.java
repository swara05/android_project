package com.example.apicalling;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ApiAdapter extends RecyclerView.Adapter<ApiAdapter.ViewHolder> {

    Context context;
    ArrayList<Data> data;

    public ApiAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ApiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idimg.setText(data.get(position).getId());
        holder.imgname.setText(data.get(position).getImage_name());
        Picasso.with(context.getApplicationContext())
                .load("http://icallscreen.in//wallpaper//public//images//image/"+data.get(position).getImage())
                .fit()
                .into(holder.img);
                        //.load("http://icallscreen.in//wallpaper//public//images//image/"+ data.get(position).getImage())

        holder.create.setText(data.get(position).getCreated_at());
        holder.update.setText(data.get(position).getUpdated_at());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView idimg,imgname,create,update;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idimg = itemView.findViewById(R.id.idimg);
            imgname = itemView.findViewById(R.id.imgname);
            create = itemView.findViewById(R.id.create);
            update = itemView.findViewById(R.id.update);
            img = itemView.findViewById(R.id.img);
        }
    }
}
