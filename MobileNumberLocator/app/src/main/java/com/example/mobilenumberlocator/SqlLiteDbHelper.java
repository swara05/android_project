//package com.example.mobilenumberlocator;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.SQLException;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//public class SqlLiteDbHelper extends SQLiteOpenHelper {
//    private static final String DATABASE_NAME = "mobileNumberfinderdatabase";
//    private static final String DATABASE_PATH = "/data/data/com.example.mobilenumberlocator/databases/";
//    private static final int DATABASE_VERSION = 1;
//    private static final String KEY_EMAILID = "emailid";
//    private static final String KEY_ID = "id";
//    private static final String KEY_MOBILENO = "mobileno";
//    private static final String KEY_NAME = "name";
//    private static final String TABLE_CONTACT = "mobileNumberfinder";
//    Context ctx;
//
//    /* renamed from: db */
//    private SQLiteDatabase f165db;
//
//    public void onCreate(SQLiteDatabase sQLiteDatabase) {
//    }
//
//    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
//    }
//
//    public SqlLiteDbHelper(Context context) {
//        super(context, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
//        this.ctx = context;
//    }
//
//    public Cursor Get_ContactDetails(String str) {
//        SQLiteDatabase readableDatabase = getReadableDatabase();
//        return readableDatabase.rawQuery("select * from mobileNumberfinder where mobilenumber='" + str + "'", (String[]) null);
//    }
//
//    public void CopyDataBaseFromAsset() throws IOException {
//        InputStream open = this.ctx.getAssets().open(DATABASE_NAME);
//        Log.e("sample", "Starting copying");
//        File file = new File("/data/data/com.example.mobilenumberlocator/databases");
//        if (!file.exists()) {
//            file.mkdir();
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream("/data/data/com.example.mobilenumberlocator/databases/mobileNumberfinderdatabase");
//        byte[] bArr = new byte[1024];
//        while (true) {
//            int read = open.read(bArr);
//            if (read > 0) {
//                fileOutputStream.write(bArr, 0, read);
//            } else {
//                //Log.e("sample", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED);
//                fileOutputStream.flush();
//                fileOutputStream.close();
//                open.close();
//                return;
//            }
//        }
//    }
//
//    public void openDataBase() throws SQLException {
//        this.f165db = SQLiteDatabase.openDatabase("/data/data/com.example.mobilenumberlocator/databases/mobileNumberfinderdatabase", (SQLiteDatabase.CursorFactory) null, 268435472);
//    }
//}
