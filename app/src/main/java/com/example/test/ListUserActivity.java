package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.test.Adapter.UserAdapter;
import com.example.test.database.AppDatabase;
import com.example.test.database.User;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {

    RecyclerView rvUser;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        db = AppDatabase.getAppDatabase(this);
        List<User> list = db.userDao().getAllUser();

        UserAdapter adapter = new UserAdapter(this, list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);
    }
}