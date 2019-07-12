package com.example.smartparkingsystem.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.smartparkingsystem.Model.Parking;
import com.example.smartparkingsystem.Util.Constants;

public class DatabaseHandler extends SQLiteOpenHelper {

    private Context ctx;
    public DatabaseHandler(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
        this.ctx = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_USER_ID + " INTEGER PRIMARY KEY," + Constants.KEY_USER_NAME + " TEXT,"
                + Constants.KEY_USER_PASSWORD + " TEXT);";

        db.execSQL(CREATE_USER_TABLE);
        db.execSQL("INSERT INTO Constants.TABLE_NAME (user_name,user_password)  VALUES ('abc', 'abc')");

        String CREATE_PARKING_TABLE = "CREATE TABLE " + Constants.PARKING_TABLE + "("
                + Constants.PARKING_ID + " INTEGER," + Constants.PARKING_STATUS + " TEXT,"
                + Constants.PARKING_DURATION + " LONG);";

        db.execSQL(CREATE_PARKING_TABLE);





    }
    public boolean verifyUser(String UserName, String PassWord) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME, new String[] {Constants.KEY_USER_ID,
                        Constants.KEY_USER_NAME, Constants.KEY_USER_PASSWORD},
                Constants.KEY_USER_NAME + "=?",
                new String[] {String.valueOf(UserName)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();


        Parking user = new Parking();
        if(PassWord==cursor.getString(cursor.getColumnIndex(Constants.KEY_USER_PASSWORD)))
            return true;
        else
            return false;


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);

        onCreate(db);

    }

    public int updatestatus(int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Constants.PARKING_STATUS, "1");
        values.put(Constants.PARKING_DURATION, java.lang.System.currentTimeMillis());//get system time


        //update row
        return db.update(Constants.PARKING_TABLE, values, Constants.PARKING_ID + "=?", new String[] { String.valueOf(id)} );
    }
    public void addUser(Parking user) {
        SQLiteDatabase db = this.getWritableDatabase();

//        ContentValues values = new ContentValues();
////        values.put(Constants.KEY_USER_NAME, "abc");
////        values.put(Constants.KEY_USER_ID, "123");
////        values.put(Constants.KEY_USER_PASSWORD, "abc");
////
////        //Insert the row
////        db.insert(Constants.TABLE_NAME, null, values);
////
////        Log.d("Saved!!", "Saved to DB");


        db.execSQL("INSERT INTO Constants.TABLE_NAME (user_name,user_password)  VALUES ('abc', 'abc')");
    }




}
