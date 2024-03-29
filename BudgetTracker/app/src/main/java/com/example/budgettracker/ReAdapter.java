package com.example.budgettracker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ReAdapter extends RecyclerView.Adapter<ReAdapter.Reholder> {
    Activity activity;
    List<StdData> dataList = new ArrayList<>();
    int id[];
    int k;
    int j;
    int m;

    public ReAdapter(TransactionActivity transactionActivity, List<StdData> dataList, int a, int b, int c) {
        activity = transactionActivity;
        this.dataList = dataList;
        k = a;
        j = b;
        m = c;
    }

    @Override
    public Reholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.retrive_data, parent, false);
        return new Reholder(view);
    }

    @Override
    public void onBindViewHolder(Reholder holder, int position) {
//        holder.id.setText("" + dataList.get(position).id);
        holder.tp.setText("" + dataList.get(position).type);
        holder.amt.setText("$" + dataList.get(position).amount);
        String a = holder.tp.getText().toString();
        if (a.equalsIgnoreCase("Income")) {
            holder.tp.setTextColor(ContextCompat.getColor(activity, R.color.green));
            holder.amt.setTextColor(ContextCompat.getColor(activity, R.color.green));
            holder.tp.setText("" + dataList.get(position).type);
            holder.amt.setText("$" + dataList.get(position).amount);
        } else {
            holder.tp.setTextColor(Color.RED);
            holder.amt.setTextColor(Color.RED);
            holder.tp.setText("" + dataList.get(position).type);
            holder.amt.setText("$" + dataList.get(position).amount);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(activity, EditActivity.class);
                a.putExtra("id", dataList.get(position).id);
                String typ = holder.tp.getText().toString();
                a.putExtra("typ", typ);
                a.putExtra("position", position);
                activity.startActivity(a);
            }
        });

//        switch (position) {
//            case 0:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "0";
//                        a.putExtra("id", id);
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("position", position);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 1:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        String id = "1";
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 2:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "2";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 3:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "3";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 4:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "4";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 5:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "5";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 6:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "6";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 7:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "7";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 8:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "8";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 9:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "9";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 10:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "10";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 11:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "11";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 12:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "12";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 13:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "13";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 14:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "14";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 15:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "15";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 16:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "16";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 17:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "17";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 18:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "18";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 19:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "19";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 20:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "20";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 21:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "21";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 22:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "22";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 23:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "23";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 24:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "24";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 25:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "25";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 26:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "26";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 27:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "27";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 28:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "28";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 29:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "29";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 30:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "30";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 31:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "31";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 32:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "32";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 33:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "33";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 34:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "34";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 35:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "35";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 36:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "36";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 37:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "37";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 38:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "38";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 39:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "39";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 40:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "40";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 41:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "41";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 42:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "42";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 43:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "43";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 44:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "44";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 45:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "45";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 46:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "46";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 47:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "47";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 48:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "48";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 49:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "49";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 50:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "50";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//            case 51:
//                holder.linearlayout.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent a = new Intent(activity, EditActivity.class);
//                        String id = "51";
//                        String typ = holder.tp.getText().toString();
//                        a.putExtra("typ",typ);
//                        a.putExtra("id", id);
//                        activity.startActivity(a);
//                    }
//                });
//                break;
//        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class Reholder extends RecyclerView.ViewHolder {
        TextView amt, tp, id;
        LinearLayout linearlayout;

        public Reholder(View itemView) {
            super(itemView);
            amt = itemView.findViewById(R.id.amt);
            tp = itemView.findViewById(R.id.tp);
            id = itemView.findViewById(R.id.id);
            linearlayout = itemView.findViewById(R.id.a);
        }
    }
}
