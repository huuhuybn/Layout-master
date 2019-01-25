package vn.edu.poly.layout.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import vn.edu.poly.layout.BaseActivity;
import vn.edu.poly.layout.BillDAO;
import vn.edu.poly.layout.R;
import vn.edu.poly.layout.model.Bill;

public class BillActivity extends BaseActivity {

    private EditText edtBillID;
    private Button btnDate;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        initViews();


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(BillActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        btnAdd.setText(year + "-" + month + "-" + dayOfMonth);
                        //?????

                    }
                }, year, month, day);


                datePickerDialog.show();
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String billID = edtBillID.getText().toString().trim();
                if (billID.matches("") | billID.length() >7){
                    edtBillID.setError(getString(R.string.notify_wrong_text));
                    return;
                }

                String date = btnAdd.getText().toString().trim();

                if (date.equals(getString(R.string.bill_btn_click_date))){
                    showMessage(getString(R.string.notify_choose_input));
                    return;
                }


                BillDAO billDAO = new BillDAO(BillActivity.this);

                Bill bill = new Bill();
                bill.id = billID;
                bill.date = date;

                long result = billDAO.insertBill(bill);

                if (result > 0){
                    showMessage(getString(R.string.notify_input_succesful));
                }else {
                    showMessage(getString(R.string.notify_error));
                }

            }
        });


    }

    public void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        edtBillID = findViewById(R.id.edtBillID);
        btnDate = findViewById(R.id.btnDate);
        btnAdd = findViewById(R.id.btnAdd);
    }

}
