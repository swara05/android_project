package com.example.bloodpressure;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

//import com.rtugeek.android.colorseekbar.ColorSeekBar;


public class AddData extends AppCompatActivity {

    ImageView back;
    LinearLayout date, time;
    // private SeekBar bpSeekBar;
    LinearLayout addtag;
    ImageView arrow1, img1, arrow2, img2, arrow3, img3, arrow4, img4, arrow5, img5, arrow6, img6;
    int sys, dis, pls;
    TextView dtext, ttext;
    String tim, det;
    TextView cancel, save;
    TextView export, today, week, month, year, crange, add;
    RecyclerView recyclerview;
    AdapterHistory adapterHistory;
    ArrayList<ModalHistory> userList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    String syst, dist, plst;
    LinearLayout addbp, lbp;
    String state;
    Chip chip;
    LottieAnimationView lottie;
    List<String> selectedChips = new ArrayList<>();

    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private SharedPreferences sharedPreferences;
    private String chipdata;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        back = findViewById(R.id.back);
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);
        lottie = findViewById(R.id.lottie);
        TextView status = findViewById(R.id.status);
        TextView data = findViewById(R.id.data);
        addtag = findViewById(R.id.addtag);
        arrow1 = findViewById(R.id.arrow1);
        img1 = findViewById(R.id.img1);
        arrow2 = findViewById(R.id.arrow2);
        img2 = findViewById(R.id.img2);
        arrow3 = findViewById(R.id.arrow3);
        img3 = findViewById(R.id.img3);
        arrow4 = findViewById(R.id.arrow4);
        img4 = findViewById(R.id.img4);
        arrow5 = findViewById(R.id.arrow5);
        img5 = findViewById(R.id.img5);
        arrow6 = findViewById(R.id.arrow6);
        img6 = findViewById(R.id.img6);
        dtext = findViewById(R.id.dtext);
        ttext = findViewById(R.id.ttext);
        cancel = findViewById(R.id.cancel_button);
        save = findViewById(R.id.save);
        //export = findViewById(R.id.export);
        today = findViewById(R.id.today);
        week = findViewById(R.id.week);
        month = findViewById(R.id.month);
        year = findViewById(R.id.year);
        crange = findViewById(R.id.crange);
        add = findViewById(R.id.add);
        ChipGroup chipGroup = findViewById(R.id.chipshow);
        addbp = findViewById(R.id.addbp);
        lbp = findViewById(R.id.lbp);

        addtag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(AddData.this, ModifyTag.class);
                startActivity(i);
            }
        });

        loadData();


//        chipGroup.removeAllViews();
//        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
//        int chipCount = sharedPreferences.getInt("chipCount", 0);
//        String text = null;
//
//        for (int i = 0; i < chipCount; i++) {
//            text = sharedPreferences.getString("chip" + i, "");
//            if (!text.isEmpty()) {
//                chip = (Chip) this.getLayoutInflater().inflate(R.layout.single_chip, null, false);
//                chip.setText(text);
//                chip.setCloseIconVisible(false);
//                chipGroup.addView(chip);
//            }
//        }



//        chip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //Toast.makeText(AddData.this, chip.getText().toString(), Toast.LENGTH_SHORT).show();
//                for (int i = 0; i < chipGroup.getChildCount(); i++) {
//                     chip = (Chip) chipGroup.getChildAt(i);
//                    if (chip.isChecked()) {
//                        selectedChips.add(chip.getText().toString());
//
//
//
//                    }
//                }
//            }
//        });
     

// Now you can use the selectedChips list to pass data to another view

//        Chip chip = (Chip) this.getLayoutInflater().inflate(R.layout.single_chip, null, false);
//        chip.setText(text);
//        chipGroup.addView(chip);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });




        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        det = dateFormat.format(calendar.getTime());
        dtext.setText(det);

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm", Locale.getDefault());
        tim = timeFormat.format(calendar.getTime());
        ttext.setText(tim);


        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create a new DatePickerDialog with current date as default
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(AddData.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                // Handle the selected date here
                                String selectedDate = String.format("%02d/%02d/%d", dayOfMonth, (month + 1), year);
                                det = selectedDate;
                                dtext.setText(det);
                            }

//                            @Override
//                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                                // Handle the selected date here
//                                det = dayOfMonth+"/"+(month+1)+"/"+year;
//                                dtext.setText(det);
//                                Toast.makeText(AddData.this,
//                                        "Selected date: " + year + "-" + (month + 1) + "-" + dayOfMonth,
//                                        Toast.LENGTH_SHORT).show();
//                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.show();
            }
        });


        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        // Create a new TimePickerDialog with current time as default
                        Calendar calendar = Calendar.getInstance();
                        int hour = calendar.get(Calendar.HOUR_OF_DAY);
                        int minute = calendar.get(Calendar.MINUTE);
                        boolean is24HourFormat = DateFormat.is24HourFormat(AddData.this);
                        timePickerDialog = new TimePickerDialog(AddData.this,
                                new TimePickerDialog.OnTimeSetListener() {
                                    @Override
                                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                        // Handle the selected time here
                                        tim = hourOfDay + ":"+minute;
                                        ttext.setText(tim);
//                                        Toast.makeText(AddData.this,
//                                                "Selected time: " + hourOfDay + ":" + minute,
//                                                Toast.LENGTH_SHORT).show();
                                    }
                                }, hour, minute, is24HourFormat);
                        timePickerDialog.show();

            }
        });

        NumberPicker numberPicker = findViewById(R.id.number_picker);
        NumberPicker numberPicker1 = findViewById(R.id.number_picker1);
        NumberPicker numberPicker2 = findViewById(R.id.number_picker2);


        numberPicker.setMinValue(40);
        numberPicker.setMaxValue(200);
        numberPicker.setValue(100);

        numberPicker1.setMinValue(40);
        numberPicker1.setMaxValue(200);
        numberPicker1.setValue(75);

        numberPicker2.setMinValue(40);
        numberPicker2.setMaxValue(200);
        numberPicker2.setValue(70);

        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Handle selection event
//                Toast.makeText(AddData.this, "Selected : "+newVal, Toast.LENGTH_SHORT).show();
                 sys = newVal;
                syst = Integer.toString(newVal);

                if (sys < 90 ) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.blue));
                    status.setBackgroundResource(R.color.lblue);
                    status.setText("◉ Hypotension");
                    data.setText("Hypotension");
                    state = "◉ Hypotension";
                    arrow1.setVisibility(View.VISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);

                } else if (sys >= 90 && sys <= 119) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.green));
                    status.setBackgroundResource(R.color.lgreen);
                    state = "◉ Normal";
                    status.setText("◉ Normal");
                    data.setText("Great! Your blood pressure is in the healthy range.Just keeep it!");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.VISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if (sys >= 120 && sys <= 129 ) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.light_yello));
                    status.setBackgroundResource(R.color.l_yello);
                    state = "◉ Elevated";
                    status.setText("◉ Elevated");
                    data.setText("Elevated");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.VISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if ((sys >= 130 && sys <= 139)) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.yellow));
                    status.setBackgroundResource(R.color.lyellow);
                    state = "◉ Hypertension Stage 1";
                    status.setText("◉ Hypertension Stage 1");
                    data.setText("Higher blood pressure than normal.You should see your doctors for some prescriptions.");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.VISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if (sys >= 140 && sys <=180) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.orange));
                    status.setBackgroundResource(R.color.lorange);
                    state = "◉ Hypertension Stage 2";
                    status.setText("◉ Hypertension Stage 2");
                    data.setText("Attention! Please seek your doctor's advice for immediate medical treatment and lifestyle changes.");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.VISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if (sys > 180) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.red));
                    status.setBackgroundResource(R.color.lred);
                    state = "◉ Hypertensive Crisis";
                    status.setText("◉ Hypertensive Crisis");
                    data.setText("Oh! Please wait five minutes and then test your blood pressure again.If your reading are still unusually high, contact your doctor immediately.");
                     arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.VISIBLE);

                }
            }
        });

        numberPicker1.setWrapSelectorWheel(false);
        numberPicker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker1, int oldVal1, int newVal1) {
                // Handle selection event
                //Toast.makeText(AddData.this, "Selected : "+newVal1, Toast.LENGTH_SHORT).show();
                 dis = newVal1;
                dist = Integer.toString(newVal1);

                if (dis < 60) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.blue));
                    status.setBackgroundResource(R.color.lblue);
                    state = "◉ Hypotension";
                    status.setText("◉ Hypotension");
                    data.setText("Hypotension");
                    arrow1.setVisibility(View.VISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if ( dis >= 60 && dis <= 79) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.green));
                    status.setBackgroundResource(R.color.lgreen);
                    state = "◉ Normal";
                    status.setText("◉ Normal");
                    data.setText("Great! Your blood pressure is in the healthy range.Just keeep it!");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.VISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if ( dis >= 60 && dis <= 79 ) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.light_yello));
                    status.setBackgroundResource(R.color.l_yello);
                    state = "◉ Elevated";
                    status.setText("◉ Elevated");
                    data.setText("Elevated");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.VISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if ( dis >= 80 && dis <= 89) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.yellow));
                    status.setBackgroundResource(R.color.lyellow);
                    state = "◉ Hypertension Stage 1";
                    status.setText("◉ Hypertension Stage 1");
                    data.setText("Higher blood pressure than normal.You should see your doctors for some prescriptions.");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.VISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if ( dis >= 90 && dis <= 119) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.orange));
                    status.setBackgroundResource(R.color.lorange);
                    state = "◉ Hypertension Stage 2";
                    status.setText("◉ Hypertension Stage 2");
                    data.setText("Attention! Please seek your doctor's advice for immediate medical treatment and lifestyle changes.");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.VISIBLE);
                    arrow6.setVisibility(View.INVISIBLE);
                } else if (dis > 120) {
                    status.setTextColor(ContextCompat.getColor(AddData.this, R.color.red));
                    status.setBackgroundResource(R.color.lred);
                    state = "◉ Hypertensive Crisis";
                    status.setText("◉ Hypertensive Crisis");
                    data.setText("Oh! Please wait five minutes and then test your blood pressure again.If your reading are still unusually high, contact your doctor immediately.");
                    arrow1.setVisibility(View.INVISIBLE);
                    arrow2.setVisibility(View.INVISIBLE);
                    arrow3.setVisibility(View.INVISIBLE);
                    arrow4.setVisibility(View.INVISIBLE);
                    arrow5.setVisibility(View.INVISIBLE);
                    arrow6.setVisibility(View.VISIBLE);

                }
            }
        });

        numberPicker2.setWrapSelectorWheel(false);
        numberPicker2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker2, int oldVal2, int newVal2) {
                // Handle selection event
               // Toast.makeText(AddData.this, "Selected : "+newVal2, Toast.LENGTH_SHORT).show();
                pls = newVal2;
                plst = Integer.toString(newVal2);
            }
        });



        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addbp.setVisibility(View.GONE);
                lbp.setVisibility(View.VISIBLE);

            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // my_prefs
                SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                for (int i=0; i<chipGroup.getChildCount();i++){
                    Chip chip = (Chip)chipGroup.getChildAt(i);
                    Log.i("outside if ", i+ " chip = " + chip.getText().toString());
                    if (chip.isChecked()){

                       // textView.setText(chip.getText().toString());

                        chipdata = chip.getText().toString();

                        selectedChips.add(chip.getText().toString());
                        Log.i("inside if ", i+ " chip = " + selectedChips.add(chip.getText().toString()));


                    }
                }

               //String jsonString = new Gson().toJson(selectedChips);


                editor.putString("time", tim);
                editor.putString("date", det);
                editor.putString("status", state);
                editor.putString("tag",chipdata);
                editor.putInt("systolic", sys);
                editor.putInt("diastolic", dis);
                editor.putInt("pulse", pls);
                editor.apply();


                userList.add(new ModalHistory(tim,det,state,chipdata,syst,dist,plst));
                saveData();

               addbp.setVisibility(View.GONE);
               lbp.setVisibility(View.VISIBLE);
            }
        });

        today.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                today.setBackgroundResource(R.drawable.select);
                week.setBackgroundResource(R.drawable.lightdata);
                month.setBackgroundResource(R.drawable.lightdata);
                year.setBackgroundResource(R.drawable.lightdata);

                Calendar calendar = Calendar.getInstance();
                String startDateStr = dateFormat.format(calendar.getTime());
                String endDateStr = startDateStr;
                crange.setText("Today");

                filterDataByDateRange(startDateStr, endDateStr);
            }
        });

        week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                today.setBackgroundResource(R.drawable.lightdata);
                week.setBackgroundResource(R.drawable.select);
                month.setBackgroundResource(R.drawable.lightdata);
                year.setBackgroundResource(R.drawable.lightdata);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek());
                String startDateStr = dateFormat.format(calendar.getTime());
                calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6);
                String endDateStr = dateFormat.format(calendar.getTime());
                crange.setText("This Week");

                filterDataByDateRange(startDateStr, endDateStr);
            }
        });

        month.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                today.setBackgroundResource(R.drawable.lightdata);
                week.setBackgroundResource(R.drawable.lightdata);
                month.setBackgroundResource(R.drawable.select);
                year.setBackgroundResource(R.drawable.lightdata);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                String startDateStr = dateFormat.format(calendar.getTime());
                calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
                String endDateStr = dateFormat.format(calendar.getTime());
                crange.setText("This Month");

                filterDataByDateRange(startDateStr, endDateStr);
            }
        });

        year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                today.setBackgroundResource(R.drawable.lightdata);
                week.setBackgroundResource(R.drawable.lightdata);
                month.setBackgroundResource(R.drawable.lightdata);
                year.setBackgroundResource(R.drawable.select);

                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.MONTH, Calendar.JANUARY);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
                String startDateStr = dateFormat.format(calendar.getTime());
                calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                calendar.set(Calendar.DAY_OF_MONTH, 31);
                String endDateStr = dateFormat.format(calendar.getTime());
                crange.setText("This Year");

                filterDataByDateRange(startDateStr, endDateStr);

            }
        });

        MaterialDatePicker.Builder<Pair<Long, Long>> materialDateBuilder = MaterialDatePicker.Builder.dateRangePicker();

        materialDateBuilder.setTitleText("SELECT A DATE");

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        crange.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // getSupportFragmentManager() to
                        // interact with the fragments
                        // associated with the material design
                        // date picker tag is to get any error
                        // in logcat
                        if (!materialDatePicker.isAdded()) {
                            materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                        }


                    }
                });


        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onPositiveButtonClick(Object selection) {

                        // if the user clicks on the positive
                        // button that is ok button update the
                        // selected date
                        crange.setText(materialDatePicker.getHeaderText());
                        Pair<Long, Long> selectedDates = (Pair<Long, Long>) selection;
                        String startDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDates.first);
                        String endDate = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(selectedDates.second);
                        filterDataByDateRange(startDate, endDate);
                        // in the above statement, getHeaderText
                        // will return selected date preview from the
                        // dialog
                    }
                });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbp.setVisibility(View.VISIBLE);
                lbp.setVisibility(View.GONE);
            }
        });


        recyclerview=findViewById(R.id.recyclerview);
        adapterHistory = new AdapterHistory(userList,getApplicationContext());
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setHasFixedSize(true);
        recyclerview.setAdapter(adapterHistory);

    }



    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(userList);
        editor.putString("courses", json);
        editor.apply();
        adapterHistory = new AdapterHistory(userList,getApplicationContext());
        recyclerview.setAdapter(adapterHistory);
        adapterHistory.notifyItemInserted(userList.size());
       // Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("shared preferences", AppCompatActivity.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("courses", null);
        Type type = new TypeToken<ArrayList<ModalHistory>>() {}.getType();
        userList = gson.fromJson(json, type);
        if (userList == null) {
            userList = new ArrayList<>();
        }
    }

    private void filterDataByDateRange(String startDateStr, String endDateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        try {
            Date startDate = dateFormat.parse(startDateStr);
            Date endDate = dateFormat.parse(endDateStr);

            ArrayList<ModalHistory> filteredList = new ArrayList<>();
            for (ModalHistory item : userList) {
                Date itemDate = dateFormat.parse(item.getHdate());

                if (itemDate.compareTo(startDate) >= 0 && itemDate.compareTo(endDate) <= 0) {
                    filteredList.add(item);
                }
            }

            if(filteredList.isEmpty()){
               lottie.setVisibility(View.VISIBLE);
               recyclerview.setVisibility(View.GONE);
            }else{
                lottie.setVisibility(View.GONE);
                recyclerview.setVisibility(View.VISIBLE);
                adapterHistory = new AdapterHistory(filteredList,getApplicationContext());
                recyclerview.setAdapter(adapterHistory);
            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}