package com.example.cognizant;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder> {

    private List<ModalMobile> userList3;
    Context context;
    public MobileAdapter(List<ModalMobile> userList3,Context context) {
        this.userList3 = userList3;
        this.context = context;
    }

    @NonNull
    @Override
    public MobileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mobile,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MobileAdapter.ViewHolder holder, int position) {
        final ModalMobile temp3 = userList3.get(position);
        String mobname = userList3.get(position).getMname();
        int mobimg = userList3.get(position).getMimg();

        holder.mimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mob = new Intent(context,Items.class);
                mob.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mob.putExtra("catname",temp3.getMname());
                context.startActivity(mob);
            }
        });
        holder.setData(mobname,mobimg);
    }

    @Override
    public int getItemCount() {
        return userList3.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mname;
        private ImageView mimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mname = itemView.findViewById(R.id.mname);
            mimg = itemView.findViewById(R.id.mimg);
        }
        public void setData(String mobname,int mobimg){
            mname.setText(mobname);
            mimg.setImageResource(mobimg);
        }
    }
}
