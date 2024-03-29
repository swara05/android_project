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
import java.util.Objects;
import java.util.zip.Inflater;

public class GroAdapter extends RecyclerView.Adapter<GroAdapter.ViewHolder> {

    private List<ModalGrocery> userList1;
    Context context;
    public GroAdapter(List<ModalGrocery>userList1,Context context){
        this.userList1 = userList1;
        this.context = context;
    }

    @NonNull
    @Override
    public GroAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grocery,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GroAdapter.ViewHolder holder, int position) {

        final ModalGrocery temp1 = userList1.get(position);
        String groname = userList1.get(position).getGname();
        int gimage = userList1.get(position).getGroimg();

        holder.setData(groname,gimage);
        holder.groimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groc = new Intent(context,Items.class);
                groc.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                groc.putExtra("catname",temp1.getGname());
                context.startActivity(groc);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView gname;
        private ImageView groimg;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            gname = itemView.findViewById(R.id.gname);
            groimg = itemView.findViewById(R.id.groimg);
        }

        public void setData(String groname, int gimage) {
            groimg.setImageResource(gimage);
            gname.setText(groname);
        }
    }

}
