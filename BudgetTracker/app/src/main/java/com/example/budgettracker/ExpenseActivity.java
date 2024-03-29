package com.example.budgettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class ExpenseActivity extends AppCompatActivity {
    RadioButton inc, exp, business, clothing, drinks, education, food, fuel;
    LinearLayout drop_category, drop_mode;
    TextView inc_txt, cancel, set, cat, md;
    EditText amt, note;
    ImageView back, done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        inc = findViewById(R.id.income_button);
        inc_txt = findViewById(R.id.txt_inc);
        cat = findViewById(R.id.cat);
        md = findViewById(R.id.md);
        back = findViewById(R.id.back);
        amt = findViewById(R.id.amount);
        done = findViewById(R.id.done);
        note = findViewById(R.id.note);
        exp = findViewById(R.id.expense_button);
        drop_category = findViewById(R.id.drop_category);
        drop_mode = findViewById(R.id.drop_mode);

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
                inc_txt.setText("Add Income");
            }
        });
        exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (exp.isChecked() == true) {
                    inc.setChecked(false);
                    inc_txt.setText("Add Expense");

                }
            }
        });
        drop_category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ExpenseActivity.this);
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
                Dialog dialog = new Dialog(ExpenseActivity.this);
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

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = note.getText().toString();
                boolean inc_radio = inc.isChecked();
                boolean exp_radio = exp.isChecked();
                int number = Integer.parseInt(amt.getText().toString());
                String catg = cat.getText().toString();
                String mod = md.getText().toString();
                if (TextUtils.isEmpty(amt.getText())) {
                    amt.setError("Enter Amount");
                } else {
                    Database database = new Database(ExpenseActivity.this);
                    if (inc_radio == true) {
                        database.InsertData("Income", number, catg, mod,a);
                        finish();
                    } else if (exp_radio == true) {
                        database.InsertData("Expense", number, catg, mod,a);
                        finish();
                    }

                }
            }
        });
    }
}