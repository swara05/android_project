package com.example.cognizant;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.ViewHolder> {

    private List<ModalBag> userList2;
    Context context;
    public BagAdapter(List<ModalBag> userList2,Context context) {

        this.userList2 = userList2;
        this.context = context;
    }

    @NonNull
    @Override
    public BagAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bags,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BagAdapter.ViewHolder holder, int position) {
            final ModalBag temp2 = userList2.get(position);
            String bagname = userList2.get(position).getBname();
            int bagimg = userList2.get(position).getBimg();

            holder.setData(bagname,bagimg);
            holder.bimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent bag = new Intent(context,Items.class);
                    bag.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    bag.putExtra("catname",temp2.getBname());
                    context.startActivity(bag);
                }
            });
    }

    @Override
    public int getItemCount() {
        return userList2.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView bname;
        private ImageView bimg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bname = itemView.findViewById(R.id.bname);
            bimg = itemView.findViewById(R.id.bimg);
        }
        public void setData(String bagname,int bagimg){
            bname.setText(bagname);
            bimg.setImageResource(bagimg);
        }
    }
}
