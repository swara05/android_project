package com.example.json;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    Context context;
    private ArrayList<Modaljson> userList;


    public CustomAdapter(Context context, ArrayList<Modaljson> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false);
        ViewHolder v = new ViewHolder(view);
        return v;
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        String quo = userList.get(position).getQuote();
        String img = userList.get(position).getImage();
        String ico = userList.get(position).getIcon();
        String fol = userList.get(position).getFolder();
        String sou = userList.get(position).getSound();

        holder.setData(quo,img,ico,fol,sou);



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView quote,image,icon,sound,folder;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quote = (TextView) itemView.findViewById(R.id.quote);
            image = (TextView) itemView.findViewById(R.id.image);
            icon = (TextView) itemView.findViewById(R.id.icon);
            sound = (TextView) itemView.findViewById(R.id.sound);
            folder=(TextView) itemView.findViewById(R.id.folder);
        }

        public void setData(String quo, String img, String ico, String fol, String sou) {

            quote.setText(quo);
            image.setText(img);
            icon.setText(ico);
            folder.setText(fol);
            sound.setText(sou);
        }
    }
}
