package com.example.mobilenumberlocator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class BankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    List<Bankmodel> Blist;
    Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView bankname;
        ImageView bankimg;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            bankimg = itemView.findViewById(R.id.bankimg);
            bankname = itemView.findViewById(R.id.bankname);

        }
    }

    public BankAdapter(List<Bankmodel> blist, BankListMainActivity banklist) {
        this.Blist = blist;
        this.context = banklist;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bank, parent, false));
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        holder.setIsRecyclable(false);


        final Bankmodel daysModel = Blist.get(position);
        ViewHolder view = (ViewHolder) holder;
            view.bankname.setText(daysModel.getName());
            view.bankimg.setImageResource(daysModel.getImg());
//            Picasso.get().load(daysModel.getImg()).into(bankimg);



            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, GetbankdetailActivity.class);
                    intent.putExtra("image", daysModel.getImg());
                    intent.putExtra("name", daysModel.getName());
                    intent.putExtra("balance", daysModel.getacbal());
                    intent.putExtra("custnum", daysModel.getcustnum());
                    intent.putExtra("minstate", daysModel.getmincon());
                    intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });

        }

    @Override
    public int getItemCount() {
        return Blist.size();
    }
}