package vn.edu.poly.layout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.layout.model.User;

import static vn.edu.poly.layout.Constants.USER_FULL_NAME;
import static vn.edu.poly.layout.Constants.USER_PASSWORD;
import static vn.edu.poly.layout.Constants.USER_PHONE;
import static vn.edu.poly.layout.Constants.USER_TABLE;
import static vn.edu.poly.layout.Constants.USER_USER_NAME;

public class UserDAO {

    private DBHelper dbHelper;

    public UserDAO(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public long insertUser(User user) {

        long result = -1;

        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_USER_NAME, user.USER_USER_NAME);
        contentValues.put(USER_PASSWORD, user.USER_PASSWORD);
        contentValues.put(USER_PHONE, user.USER_PHONE);
        contentValues.put(USER_FULL_NAME, user.USER_FULL_NAME);

        // xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        result = sqLiteDatabase.insert(USER_TABLE, null, contentValues);

        sqLiteDatabase.close();

        return result;
    }


    public long updateUser(User user) {

        long result = -1;

        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_USER_NAME, user.USER_USER_NAME);
        contentValues.put(USER_PASSWORD, user.USER_PASSWORD);
        contentValues.put(USER_PHONE, user.USER_PHONE);
        contentValues.put(USER_FULL_NAME, user.USER_FULL_NAME);

        // xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        result = sqLiteDatabase.update(USER_TABLE, contentValues, USER_USER_NAME + "=?",
                new String[]{user.USER_USER_NAME});

        sqLiteDatabase.close();

        return result;

    }


    public long delUser(String user_name) {

        long result = -1;

        // xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        result = sqLiteDatabase.delete(USER_TABLE, USER_USER_NAME + "=?",
                new String[]{user_name});

        return result;

    }

    public List<User> getAllUsers() {
        List<User> users = null;

        String QUERY = "SELECT * FROM " + USER_TABLE;


        // xin quyen doc ghi

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                users = new ArrayList<>();

                // di chuyen toi vi tri dau tien cua con tro cursor
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String USER_USER_NAME_ = cursor.getString(cursor.getColumnIndex(USER_USER_NAME));

                    String USER_PASSWORD_ = cursor.getString(cursor.getColumnIndex(USER_PASSWORD));

                    String USER_PHONE_ = cursor.getString(cursor.getColumnIndex(USER_PHONE));

                    String USER_FULL_NAME_ = cursor.getString(cursor.getColumnIndex(USER_FULL_NAME));

                    User user = new User();
                    user.USER_USER_NAME = USER_USER_NAME_;
                    user.USER_PASSWORD = USER_PASSWORD_;
                    user.USER_PHONE = USER_PHONE_;
                    user.USER_FULL_NAME = USER_FULL_NAME_;

                    // add user vao array users

                    users.add(user);
                    // di chuyen toi vi tri tiep the0
                    cursor.moveToNext();

                }

                cursor.close();
                sqLiteDatabase.close();

            }
        }


        return users;
    }
}
