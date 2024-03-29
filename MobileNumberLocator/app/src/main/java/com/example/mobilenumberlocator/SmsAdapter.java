package com.example.mobilenumberlocator;

import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SmsAdapter extends RecyclerView.Adapter<SmsAdapter.ViewHolder> {

    private List<ModalTopup> userList;
    Context context;

    public SmsAdapter(List<ModalTopup> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public SmsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_popup,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SmsAdapter.ViewHolder holder, int position) {
        //  final ModalTopup temp = userList.get(position);

        String num = userList.get(position).getNum();
        String sch = userList.get(position).getShceme();
        String per = userList.get(position).getPeriod();

        if(num.equals("")){
            holder.text.setVisibility(View.VISIBLE);
            holder.cardView.setVisibility(View.GONE);
        }else {
            holder.num.setText(num);
            holder.scheme.setText(sch);
            holder.period.setText(per);
            holder.text.setVisibility(View.GONE);
        }

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent clo = new Intent(context,Items.class);
//                clo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                clo.putExtra("num",temp.getNum());
//                context.startActivity(clo);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView num,scheme,period,text;
        private CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            num = itemView.findViewById(R.id.num);
            scheme = itemView.findViewById(R.id.scheme);
            period = itemView.findViewById(R.id.period);
            text = itemView.findViewById(R.id.text);
            cardView = itemView.findViewById(R.id.cardview);
        }
    }
}
