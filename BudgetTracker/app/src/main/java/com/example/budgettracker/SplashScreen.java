package com.example.budgettracker;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.drawerlayout.widget.DrawerLayout;

        import android.content.Intent;
        import android.graphics.Color;
        import android.icu.number.IntegerWidth;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.github.mikephil.charting.charts.PieChart;
        import com.github.mikephil.charting.data.PieData;
        import com.github.mikephil.charting.data.PieDataSet;
        import com.github.mikephil.charting.data.PieEntry;
        import com.github.mikephil.charting.utils.ColorTemplate;

        import org.eazegraph.lib.models.PieModel;

        import java.util.ArrayList;
        import java.util.List;

public class SplashScreen extends AppCompatActivity {
    ImageView menu;
    DrawerLayout drawerLayout;
    public static TextView income_amount, deck1, expense_amount, balance, deck, deck2;
    LinearLayout income, expense, transaction, share;
    int k, l, m;
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList pieEntries;
    ArrayList PieEntryLabels;

    @Override
    protected void onResume() {
        super.onResume();
        Total();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        income = findViewById(R.id.income);
        expense = findViewById(R.id.expense);
        deck1 = findViewById(R.id.deck1);
        deck2 = findViewById(R.id.deck2);
        transaction = findViewById(R.id.transactions);
        share = findViewById(R.id.share);
        drawerLayout = findViewById(R.id.drawer);
        deck = findViewById(R.id.deck);
        income_amount = findViewById(R.id.income_amount);
        expense_amount = findViewById(R.id.expense_amount);
        transaction = findViewById(R.id.transactions);
        balance = findViewById(R.id.balance);
        menu = findViewById(R.id.menu);
        pieChart = findViewById(R.id.pie_chart);

        Total();

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "hi");
//                String a = "https://play.google.com/store/apps/details?id=com.whatsapp&hl=en_IN&gl=US";
                String a = "com.example.budgettracker";
                intent.putExtra(android.content.Intent.EXTRA_TEXT, a);
                startActivity(Intent.createChooser(intent, "Share Via"));
            }
        });
        income_amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashScreen.this, IncomeActivity.class);
                startActivity(intent);
            }
        });
        expense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), ExpenseActivity.class);
                startActivity(a);
            }
        });
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(), TransactionActivity.class);
                startActivity(a);
            }
        });

    }

    private void Total() {
        Database database = new Database(SplashScreen.this);
        List<StdData> dataList = database.RetriveData();
        for (int i = 0; i < dataList.size(); i++) {
            deck1.setText("" + dataList.get(i).type);
            deck.setText("" + dataList.get(i).amount);
            String a = deck1.getText().toString();
            if (a.equalsIgnoreCase("Income")) {
                int j = Integer.parseInt(deck.getText().toString());
                m = m + j;
                income_amount.setText("" + m);
            }
        }
        for (int i = 0; i < dataList.size(); i++) {
            deck2.setText("" + dataList.get(i).type);
            deck.setText("" + dataList.get(i).amount);
            String a = deck2.getText().toString();
            if (a.equalsIgnoreCase("Expense")) {
                int j = Integer.parseInt(deck.getText().toString());
                l = l + j;
                expense_amount.setText("" + l);
            }
        }


        try {
            int ex = Integer.parseInt(expense_amount.getText().toString());
            int inc = Integer.parseInt(income_amount.getText().toString());
            balance.setText("" + (inc - ex));
//            int inc_data = Integer.parseInt(income_amount.getText().toString());
//            int exp_data = Integer.parseInt(expense_amount.getText().toString());
            getEntries(ex, inc);
            pieDataSet = new PieDataSet(pieEntries, "");
            pieData = new PieData(pieDataSet);
            pieChart.setData(pieData);
            pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
//            pieDataSet.setSliceSpace(2f);
            pieDataSet.setValueTextColor(Color.WHITE);
            pieDataSet.setValueTextSize(10f);
//            pieDataSet.setSliceSpace(5f);

        } catch (NumberFormatException e) {
            try {
                int inc = Integer.parseInt(income_amount.getText().toString());
                balance.setText("" + inc);
                gettEntries(inc);
                pieDataSet = new PieDataSet(pieEntries, "");
                pieData = new PieData(pieDataSet);
                pieChart.setData(pieData);
                pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
//                pieDataSet.setSliceSpace(2f);
                pieDataSet.setValueTextColor(Color.WHITE);
//                pieDataSet.setValueTextSize(10f);
                pieDataSet.setSliceSpace(5f);

            } catch (NumberFormatException f) {
                try {
                    int ex = Integer.parseInt(expense_amount.getText().toString());
                    balance.setText("" + ex);
                    getEntries(ex);
                    pieDataSet = new PieDataSet(pieEntries, "");
                    pieData = new PieData(pieDataSet);
                    pieChart.setData(pieData);
                    pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
//                    pieDataSet.setSliceSpace(2f);
                    pieDataSet.setValueTextColor(Color.WHITE);
                    pieDataSet.setValueTextSize(10f);
//                    pieDataSet.setSliceSpace(5f);
                } catch (NumberFormatException g) {

                }
            }
        }
    }

    private void getEntries(int a, int b) {
        pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(a, 0));
        pieEntries.add(new PieEntry(b, 1));
    } private void gettEntries(int a) {
        pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(a, 0));
    } private void getEntries( int b) {
        pieEntries = new ArrayList<>();

        pieEntries.add(new PieEntry(b, 0));
    }
}
