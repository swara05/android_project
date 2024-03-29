package com.example.mobilenumberlocator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class USSDAdapter extends RecyclerView.Adapter<USSDAdapter.ViewHolder> {

    private List<ModalUSSD> userList;
    Context context;

    public USSDAdapter(List<ModalUSSD> userList, Context context) {
        this.userList = userList;
        this.context = context;
    }


    @NonNull
    @Override
    public USSDAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ussd,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull USSDAdapter.ViewHolder holder, int position) {
      holder.title.setText(userList.get(position).getTitle());
      holder.data.setText(userList.get(position).getData());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView data;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            title = itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.data);
        }

    }
}
