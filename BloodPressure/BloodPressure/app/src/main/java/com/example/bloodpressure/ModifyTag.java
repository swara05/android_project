package com.example.bloodpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class ModifyTag extends AppCompatActivity {

    Button add;
    ChipGroup chipGroup;
    private SharedPreferences sharedPreferences;
    ImageView back;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_modify_tag);
//
//        add = findViewById(R.id.add);
//        chipGroup = findViewById(R.id.chip);
//        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                final Dialog dialog = new Dialog(ModifyTag.this);
//                dialog.setContentView(R.layout.dialog_tag);
//                dialog.setCancelable(false);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//
//                dialog.show();
//
//                /* My Cancel Button , and its listener */
//
//                Button cancel=(Button)dialog.findViewById(R.id.cancel);
//                Button save=(Button)dialog.findViewById(R.id.save);
//                EditText editText=(EditText)dialog.findViewById(R.id.etext);
//
//
//                cancel.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        dialog.dismiss();
//                    }
//                });
//
//                save.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        String t = editText.getText().toString();
//
//                        setChips(t);
//                        dialog.dismiss();
//                    }
//                });
//
//
//
//            }
//        });
//    }
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_modify_tag);

    add = findViewById(R.id.add);
    chipGroup = findViewById(R.id.chip);
    back = findViewById(R.id.back);
    sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

    // Restore the state of the ChipGroup from the SharedPreferences
    int chipCount = sharedPreferences.getInt("chipCount", 0);
    for (int i = 0; i < chipCount; i++) {
        String text = sharedPreferences.getString("chip" + i, "");
        if (!text.isEmpty()) {
            setChips(text);
        }
    }
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });


    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final Dialog dialog = new Dialog(ModifyTag.this);
            dialog.setContentView(R.layout.dialog_tag);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

            dialog.show();

            /* My Cancel Button , and its listener */

            Button cancel = (Button) dialog.findViewById(R.id.cancel);
            Button save = (Button) dialog.findViewById(R.id.save);
            EditText editText = (EditText) dialog.findViewById(R.id.etext);

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
            });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String t = editText.getText().toString();

                    setChips(t);
                    dialog.dismiss();
                }
            });
        }
    });

    ArrayList<String> chipLabels = new ArrayList<>();
    for (int i = 0; i < chipGroup.getChildCount(); i++) {
        Chip chip = (Chip) chipGroup.getChildAt(i);
        chipLabels.add(chip.getText().toString());
    }

//    Intent intent = new Intent(this, AddData.class);
//    intent.putStringArrayListExtra("chipLabels", chipLabels);
//    startActivity(intent);

}

    public void setChips(String e) {
        Chip chip = (Chip) this.getLayoutInflater().inflate(R.layout.single_chip, null, false);
        chip.setText(e);

        Chip finalChip = chip;
        chip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipGroup.removeView(finalChip);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("chip" + chipGroup.indexOfChild(finalChip));
                editor.remove("chipCount" + chipGroup.indexOfChild(finalChip));
                editor.apply();
                //Toast.makeText(ModifyTag.this, finalChip.getText().toString() + " removed.", Toast.LENGTH_SHORT).show();
            }
        });
        chipGroup.addView(chip);

        // Save the state of the ChipGroup to the SharedPreferences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("chipCount", chipGroup.getChildCount());
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            chip = (Chip) chipGroup.getChildAt(i);
            editor.putString("chip" + i, chip.getText().toString());
        }
        editor.apply();
    }

//    public void setChips(String e) {
//        Chip chip = (Chip) this.getLayoutInflater().inflate(R.layout.single_chip, null, false);
//        chip.setText(e);
//
//        Chip finalChip = chip;
//        chip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chipGroup.removeView(finalChip);
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.remove("chip" + chipGroup.indexOfChild(finalChip));
//                editor.apply();
//                chipLabels.remove(finalChip.getText().toString()); // Remove the label from the ArrayList
//                //Toast.makeText(ModifyTag.this, finalChip.getText().toString() + " removed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//        chipGroup.addView(chip);
//        chipLabels.add(e); // Add the label to the ArrayList
//
//        // Save the state of the ChipGroup to the SharedPreferences
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("chipCount", chipGroup.getChildCount());
//        for (int i = 0; i < chipGroup.getChildCount(); i++) {
//            chip = (Chip) chipGroup.getChildAt(i);
//            editor.putString("chip" + i, chip.getText().toString());
//        }
//        editor.apply();
//    }

//    public  void  setChips(String e){
//        final Chip chip = (Chip) this.getLayoutInflater().inflate(R.layout.single_chip,null,false);
//        chip.setText(e);
//
//        chip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                chipGroup.removeView(chip);
//                Toast.makeText(ModifyTag.this, chip.getText().toString()+" removed.", Toast.LENGTH_SHORT).show();
//            }
//        });
//        chipGroup.addView(chip);
//    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//
//        // Save the selected Chip IDs
//        List<Integer> selectedChipIds = new ArrayList<>(chipGroup.getCheckedChipIds());
//        outState.putIntegerArrayList("selectedChipIds", (ArrayList<Integer>) selectedChipIds);
//    }
//
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//
//        // Restore the selected Chip IDs
//        List<Integer> selectedChipIds = savedInstanceState.getIntegerArrayList("selectedChipIds");
//        if (selectedChipIds != null) {
//            for (int chipId : selectedChipIds) {
//                Chip chip = chipGroup.findViewById(chipId);
//                if (chip != null) {
//                    chip.setChecked(true);
//                }
//            }
//        }
//    }

}