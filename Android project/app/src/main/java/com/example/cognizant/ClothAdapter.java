package com.example.cognizant;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

public class ClothAdapter extends RecyclerView.Adapter<ClothAdapter.ViewHolder> {
    private List<ModalCloth> userList;
    Context context;
    public ClothAdapter(List<ModalCloth>userList,Context context){
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public ClothAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cloth,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothAdapter.ViewHolder holder, int position) {
        final ModalCloth temp = userList.get(position);

        String name = userList.get(position).getCname();
        int image = userList.get(position).getImg();

        holder.setData(name,image);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clo = new Intent(context,Items.class);
                clo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                clo.putExtra("catname",temp.getCname());
                context.startActivity(clo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView cname;
        private ImageView img;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            cname = itemView.findViewById(R.id.cname);
            img = itemView.findViewById(R.id.img);
        }

        public void setData(String name, int image) {
            img.setImageResource(image);
            cname.setText(name);
        }
    }

}
