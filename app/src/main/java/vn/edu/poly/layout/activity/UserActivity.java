package vn.edu.poly.layout.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.List;
import java.util.Random;

import vn.edu.poly.layout.MainActivity;
import vn.edu.poly.layout.R;
import vn.edu.poly.layout.UserDAO;
import vn.edu.poly.layout.adapter.UserAdapter;
import vn.edu.poly.layout.model.User;

public class UserActivity extends AppCompatActivity {

    private RecyclerView lvList;
    private UserAdapter userAdapter;
    private LinearLayoutManager linearLayoutManager;

    private List<User> users;


    private UserDAO userDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        userDAO = new UserDAO(UserActivity.this);

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.USER_USER_NAME = "Huy " + i;
            user.USER_FULL_NAME = "Huy " + new Random().nextInt(100);
            user.USER_PHONE = new Random().nextInt(100000) + "";
            user.USER_PASSWORD = "123456";
            userDAO.insertUser(user);
        }

        lvList = findViewById(R.id.lvList);

        users = userDAO.getAllUsers();
        userAdapter = new UserAdapter(this, users);
        linearLayoutManager = new LinearLayoutManager(this);
        lvList.setLayoutManager(linearLayoutManager);
        lvList.setAdapter(userAdapter);

    }

}
