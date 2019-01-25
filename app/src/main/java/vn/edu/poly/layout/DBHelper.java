package vn.edu.poly.layout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.layout.model.User;

import static vn.edu.poly.layout.Constants.BILL_DATE;
import static vn.edu.poly.layout.Constants.BILL_TABLE;
import static vn.edu.poly.layout.Constants.CREATE_BILL_TABLE;
import static vn.edu.poly.layout.Constants.CREATE_USER_TABLE;
import static vn.edu.poly.layout.Constants.USER_FULL_NAME;
import static vn.edu.poly.layout.Constants.USER_PASSWORD;
import static vn.edu.poly.layout.Constants.USER_PHONE;
import static vn.edu.poly.layout.Constants.USER_TABLE;
import static vn.edu.poly.layout.Constants.USER_USER_NAME;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "qls.sql", null, 1);

        if (Constants.isDEBUG) Log.e("CREATE_USER_TABLE", CREATE_USER_TABLE);

        if (Constants.isDEBUG) Log.e("CREATE_BILL_TABLE", CREATE_BILL_TABLE);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(CREATE_BILL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BILL_TABLE);
    }





}
