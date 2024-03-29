package com.example.mobilenumberlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SAdapter extends RecyclerView.Adapter<SAdapter.ViewHolder> {

    private List<ModalStd> userList;
    Context context;

    public SAdapter(List<ModalStd>userList,Context context){
        this.userList = userList;
        this.context = context;
    }
    
    @NonNull
    @Override
    public SAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_std,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SAdapter.ViewHolder holder, int position) {
        holder.sname.setText(userList.get(position).stdname);
        holder.scod.setText(userList.get(position).stdcod);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView sname;
        private TextView scod;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            sname = itemView.findViewById(R.id.stdname);
            scod = itemView.findViewById(R.id.stdcod);
        }

    }
}
