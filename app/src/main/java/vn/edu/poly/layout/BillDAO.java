package vn.edu.poly.layout;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import vn.edu.poly.layout.model.Bill;

import static vn.edu.poly.layout.Constants.BILL_DATE;
import static vn.edu.poly.layout.Constants.BILL_ID;
import static vn.edu.poly.layout.Constants.BILL_TABLE;

public class BillDAO {

    private DBHelper dbHelper;

    public BillDAO(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public long insertBill(Bill bill) {

        ContentValues contentValues = new ContentValues();

        contentValues.put(BILL_ID, bill.id);
        contentValues.put(BILL_DATE, bill.date);

        // xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        long result = sqLiteDatabase.insert(BILL_TABLE, null, contentValues);

        sqLiteDatabase.close();

        return result;
    }

    public long updateBill(Bill bill) {

        long result = -1;

        ContentValues contentValues = new ContentValues();

        contentValues.put(BILL_ID, bill.id);
        contentValues.put(BILL_DATE, bill.date);

        // xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        result = sqLiteDatabase.update(BILL_TABLE, contentValues, BILL_ID + "=?",
                new String[]{bill.id});

        sqLiteDatabase.close();

        return result;
    }

    public long delBill(String billID) {

        long result = -1;
        // xin quyen ghi vao bang
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        result = sqLiteDatabase.delete(BILL_TABLE, BILL_ID + "=?",
                new String[]{billID});

        return result;
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = null;

        String QUERY = "SELECT * FROM " + BILL_TABLE;

        // xin quyen doc ghi

        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(QUERY, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                bills = new ArrayList<>();

                // di chuyen toi vi tri dau tien cua con tro cursor
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    String id = cursor.getString(cursor.getColumnIndex(BILL_ID));

                    String date = cursor.getString(cursor.getColumnIndex(BILL_DATE));

                    Bill bill = new Bill();
                    bill.id = id;
                    bill.date = date;

                    // add user vao array users
                    bills.add(bill);
                    // di chuyen toi vi tri tiep the0
                    cursor.moveToNext();

                }

                cursor.close();
                sqLiteDatabase.close();

            }
        }
        return bills;
    }
}
