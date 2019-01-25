package vn.edu.poly.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Random;

import vn.edu.poly.layout.activity.BillActivity;
import vn.edu.poly.layout.activity.UserActivity;
import vn.edu.poly.layout.adapter.UserAdapter;
import vn.edu.poly.layout.model.Bill;
import vn.edu.poly.layout.model.User;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openUser(View view) {
        navigate(UserActivity.class);
    }

    public void openBill(View view) {
        navigate(BillActivity.class);
    }


}
