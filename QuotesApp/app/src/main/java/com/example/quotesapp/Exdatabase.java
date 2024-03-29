package com.example.quotesapp;

import android.Manifest;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Exdatabase extends SQLiteOpenHelper {
    public static String MY_DATA = "testxyz.db";
    public String DB_PATH = "";
    Context context;

    public Exdatabase(@Nullable Context context) {
        super(context, MY_DATA, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 17)
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        else
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        this.context = context;

        copyDataBase();

        this.getReadableDatabase();
    }

    private void copyDataBase() {
        if (!checkDataBase()) {
            this.getReadableDatabase();
            this.close();
            try {
                copyDBFile();
            } catch (IOException mIOException) {
                throw new Error("ErrorCopyingDataBase");
            }
        }
    }

    private boolean checkDataBase() {
        File dbFile = new File(DB_PATH + MY_DATA);
        return dbFile.exists();
    }

    private void copyDBFile() throws IOException {
        InputStream mInput = context.getAssets().open(MY_DATA);
        //InputStream mInput = mContext.getResources().openRawResource(R.raw.info);
        OutputStream mOutput = new FileOutputStream(DB_PATH + MY_DATA);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0)
            mOutput.write(mBuffer, 0, mLength);
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

    public List<StdData> Retivedata() {
        List<StdData> dataList = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        String que = "SELECT * FROM myText";
        Cursor cursor = database.rawQuery(que, null);
        cursor.moveToFirst();
        for (int i = 0; i < cursor.getCount(); i++) {
            int id = cursor.getInt(0);
            String text = cursor.getString(1);
            String cate = cursor.getString(2);
            String lang = cursor.getString(3);

            StdData stdData = new StdData(id, text, cate, lang);
            dataList.add(stdData);
            cursor.moveToNext();
        }
        return dataList;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
