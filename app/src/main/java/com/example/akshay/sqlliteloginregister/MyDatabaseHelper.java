package com.example.akshay.sqlliteloginregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Akshay on 07-02-2018.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "USERS";

    //these are 3 columns
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_PASSWORD = "PASSWORD";
    public static final String COLUMN_GENDER = "GENDER";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+ TABLE_NAME +
                "NAME TEXT, "+
                "EMAIL TEXT,"+
                "PASSWORD TEXT"+
                "GENDER TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    public boolean insertData(String name,String email,String password,String gender){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_EMAIL,email);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from "+TABLE_NAME,null);
        return res;
    }

    // this below is for updating

    public boolean updateFunction(String id,String name,String email){
        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID,id);
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_EMAIL,email);
        db.update(TABLE_NAME,contentValues,"NAME = ?",new String[]{name});
        return true;
    }
    public Integer deleteData(String name){
        SQLiteDatabase db =this.getWritableDatabase();

        return db.delete(TABLE_NAME,"NAME = ?",new String[]{name});

    }



}
