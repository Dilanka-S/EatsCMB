package lk.sliiti.eatscmb.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context)
    {
        super(context,"Login.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase testDB) {
        testDB.execSQL("create Table users"+"(username Text primary key, password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase testDB, int i, int i1) {
        testDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password)
    {
        SQLiteDatabase testDB = this.getWritableDatabase();
        ContentValues contentValue = new ContentValues();
        contentValue.put("username", username);
        contentValue.put("password",password);

       // long result = testDB.insert("users",null,contentValue);
        long result = testDB.insertWithOnConflict("users",null,contentValue,SQLiteDatabase.CONFLICT_IGNORE);

        if(result != -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Boolean checkUser(String username)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username = ?",  new String[] {username});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public Boolean checkUserPassword(String username, String password)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE username = ? and password = ?",  new String[] {username,password});
        if(cursor.getCount()>0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}
