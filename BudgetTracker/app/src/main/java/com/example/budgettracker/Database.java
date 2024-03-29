package com.example.budgettracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    Context context;

    public Database(@Nullable Context context) {
        super(context, "budget.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String que = "CREATE TABLE budget(id INTEGER PRIMARY KEY AUTOINCREMENT,type Text,amount INTEGER,category TEXT,mode TEXT,note TEXT)";
        db.execSQL(que);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void InsertData(String type, int amount, String category, String mode, String note) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", type);
        values.put("amount", amount);
        values.put("category", category);
        values.put("mode", mode);
        values.put("note", note);
        long if_inserted = database.insert("budget", null, values);
        if (if_inserted == -1) {
            Toast.makeText(context, "Data Not Inserted!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data Inserted!", Toast.LENGTH_SHORT).show();
        }
    }

    public List<StdData> RetriveData() {
        List<StdData> dataList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        String que = "SELECT * FROM budget";
        Cursor cursor = database.rawQuery(que, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            int id = cursor.getInt(0);
            String type = cursor.getString(1);
            int amount = cursor.getInt(2);
            String cateogry = cursor.getString(3);
            String mode = cursor.getString(4);
            String note = cursor.getString(5);
            StdData data = new StdData(amount, id, type, cateogry, mode, note);
            dataList.add(data);
            cursor.moveToNext();
        }
        return dataList;
    }

    void DeleteData(int id) {
        SQLiteDatabase database = getWritableDatabase();
        long is_delete = database.delete("budget", "id=" + id, null);
        if (is_delete == -1) {
            Toast.makeText(context, "Data Is Not Deleted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data Is Deleted ", Toast.LENGTH_SHORT).show();
        }
    }

    void UpdateData(int id, String type, int amount, String category, String mode, String note) {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", type);
        values.put("amount", amount);
        values.put("category", category);
        values.put("mode", mode);
        values.put("note", note);
        long if_inserted = database.update("budget", values, "id=" + id, null);
        if (if_inserted == -1) {
            Toast.makeText(context, "Data Not Updated!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Data Updated!", Toast.LENGTH_SHORT).show();
        }
    }
}
