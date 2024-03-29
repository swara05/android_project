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

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    Context context;
    private List<ModalItems> userLit;

    public ItemAdapter(List<ModalItems> userLit,Context context) {

        this.userLit = userLit;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_it,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ViewHolder holder, int position) {


        final ModalItems tp = userLit.get(position);
        String tex = userLit.get(position).getText();
        int pic = userLit.get(position).getPicture();

        holder.setData(tex,pic);
        holder.picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent item = new Intent(context,Final.class);
                item.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                item.putExtra("fname",tp.getText());
                item.putExtra("fpic",tp.getPicture());
                item.putExtra("fdesc",tp.getDesc());
                context.startActivity(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userLit.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private ImageView picture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            picture = itemView.findViewById(R.id.picture);
        }


        public void setData(String tex, int pic) {

            text.setText(tex);
            picture.setImageResource(pic);
        }
    }
}
