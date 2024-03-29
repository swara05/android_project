package com.example.budgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity {
    RadioButton inc, exp, business, clothing, drinks, education, food, fuel;
    LinearLayout drop_category, drop_mode;
    TextView inc_txt, cancel, set, cat, md, demo;
    EditText amt, note;
    ImageView back, done, delete;
    int m, l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        delete = findViewById(R.id.delete);
        inc = findViewById(R.id.income_button);
        inc_txt = findViewById(R.id.txt_inc);
        cat = findViewById(R.id.cat);
        md = findViewById(R.id.md);
        back = findViewById(R.id.back);
        amt = findViewById(R.id.amount);
        demo = findViewById(R.id.demo_id);
        done = findViewById(R.id.done);
        note = findViewById(R.id.note);
        exp = findViewById(R.id.expense_button);
        drop_category = findViewById(R.id.drop_category);
        drop_mode = findViewById(R.id.drop_mode);
        Intent a = getIntent();
        int abc = a.getIntExtra("position",-1);
        String typ  = a.getStringExtra("typ");
        if (typ.equalsIgnoreCase("Income")){
            inc.setChecked(true);
            exp.setChecked(false);
        }else{
            inc.setChecked(false);
            exp.setChecked(true);
        }
        Database database = new Database(EditActivity.this);
        List<StdData> dataList = database.RetriveData();

        amt.setText("" + dataList.get(abc).amount);
        cat.setText("" + dataList.get(abc).category);
        md.setText("" + dataList.get(abc).mode);
        note.setText("" + dataList.get(abc).note);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demo.setText("" + dataList.get(abc).id);
                int abcd = Integer.parseInt(demo.getText().toString());
                database.DeleteData(abcd);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inc.isChecked() == true) {
                    exp.setChecked(false);
                }
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exp.isChecked() == true) {
                    inc.setChecked(false);

                }
            }
        });
        drop_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(EditActivity.this);
                dialog.setContentView(R.layout.category);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();
                cancel = dialog.findViewById(R.id.cancel);
                set = dialog.findViewById(R.id.set);
                business = dialog.findViewById(R.id.business);
                clothing = dialog.findViewById(R.id.clothing);
                drinks = dialog.findViewById(R.id.drinks);
                education = dialog.findViewById(R.id.education);
                food = dialog.findViewById(R.id.food);
                fuel = dialog.findViewById(R.id.fuel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                business.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (business.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                clothing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clothing.isChecked() == true) {
                            business.setChecked(false);
                            drinks.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                drinks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (drinks.isChecked() == true) {
                            clothing.setChecked(false);
                            business.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                education.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (education.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            business.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (food.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            education.setChecked(false);
                            business.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                fuel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (fuel.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                            business.setChecked(false);
                        }
                    }
                });
                set.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (business.isChecked() == true) {
                            cat.setText("Business");
                            dialog.dismiss();
                            business.setChecked(true);
                        } else if (clothing.isChecked() == true) {
                            cat.setText("Clothing");
                            dialog.dismiss();
                            clothing.setChecked(true);
                        } else if (drinks.isChecked() == true) {
                            cat.setText("Drinks");
                            dialog.dismiss();
                            drinks.setChecked(true);
                        } else if (education.isChecked() == true) {
                            cat.setText("Education");
                            dialog.dismiss();
                            education.setChecked(true);
                        } else if (food.isChecked() == true) {
                            cat.setText("Food");
                            dialog.dismiss();
                            food.setChecked(true);
                        } else if (fuel.isChecked() == true) {
                            cat.setText("Fuel");
                            dialog.dismiss();
                            fuel.setChecked(true);
                        }
                    }
                });

            }
        });
        drop_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(EditActivity.this);
                dialog.setContentView(R.layout.mode);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                dialog.show();
                cancel = dialog.findViewById(R.id.cancel);
                set = dialog.findViewById(R.id.set);
                clothing = dialog.findViewById(R.id.clothing);
                drinks = dialog.findViewById(R.id.drinks);
                education = dialog.findViewById(R.id.education);
                food = dialog.findViewById(R.id.food);
                fuel = dialog.findViewById(R.id.fuel);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                clothing.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clothing.isChecked() == true) {
                            drinks.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                drinks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (drinks.isChecked() == true) {
                            clothing.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                education.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (education.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            food.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                food.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (food.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            education.setChecked(false);
                            fuel.setChecked(false);
                        }
                    }
                });
                fuel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (fuel.isChecked() == true) {
                            clothing.setChecked(false);
                            drinks.setChecked(false);
                            education.setChecked(false);
                            food.setChecked(false);
                        }
                    }
                });
                set.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (clothing.isChecked() == true) {
                            md.setText("Cash");
                            dialog.dismiss();
                            clothing.setChecked(true);
                        } else if (drinks.isChecked() == true) {
                            md.setText("Credit Card");
                            dialog.dismiss();
                            drinks.setChecked(true);
                        } else if (education.isChecked() == true) {
                            md.setText("Debit Card");
                            dialog.dismiss();
                            education.setChecked(true);
                        } else if (food.isChecked() == true) {
                            md.setText("Net Banking");
                            dialog.dismiss();
                            food.setChecked(true);
                        } else if (fuel.isChecked() == true) {
                            md.setText("Cheque");
                            dialog.dismiss();
                            fuel.setChecked(true);
                        }
                    }
                });

            }
        });
        int store = Integer.parseInt(amt.getText().toString());
//        Toast.makeText(this, "" + store, Toast.LENGTH_SHORT).show();
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int amte = Integer.parseInt(amt.getText().toString());
                String ct = cat.getText().toString();
                String med = md.getText().toString();
                String nt = note.getText().toString();
                boolean inc_radio = inc.isChecked();
                boolean exp_radio = exp.isChecked();
                m = amte - store;
                if (m < amte) {
                    l = m - m - m;
                    m = (amte + store -l)/2;
                }

                demo.setText("" + dataList.get(abc).id);
                int abcd = Integer.parseInt(demo.getText().toString());
                if (inc_radio == true) {
                    database.UpdateData(abcd, "Income", m, ct, med, nt);
                    finish();
                } else if (exp_radio == true) {
                    database.UpdateData(abcd, "Expense", m, ct, med, nt);
                    finish();
                }
            }
        });
    }
}