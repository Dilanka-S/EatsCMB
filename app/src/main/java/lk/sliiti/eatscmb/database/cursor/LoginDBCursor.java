package lk.sliiti.eatscmb.database.cursor;

import android.database.Cursor;
import android.database.CursorWrapper;

import lk.sliiti.eatscmb.database.model.User;
import lk.sliiti.eatscmb.database.schema.LoginDBSchema;

public class LoginDBCursor extends CursorWrapper {

    public LoginDBCursor(Cursor cursor) {
        super(cursor);
    }

    public User getUser(){
        String username = getString(getColumnIndex(LoginDBSchema.userTable.Cols.USERNAME));
        String password = getString(getColumnIndex(LoginDBSchema.userTable.Cols.PASSWORD));
        String name = getString(getColumnIndex(LoginDBSchema.userTable.Cols.NAME));
        String logStatus = getString(getColumnIndex(LoginDBSchema.userTable.Cols.LOG_STATUS));
        return new User(username,password,name,logStatus);
    }
}