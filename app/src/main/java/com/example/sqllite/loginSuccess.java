package com.example.sqllite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.List;

public class loginSuccess extends Activity {

    private ListView userListView;
    private UserAdapter userAdapter;
    private Sqlite_DB_handler dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        userListView = findViewById(R.id.userListView);
        Button signout = findViewById(R.id.signout);

        // Initialiser la base de données et l'adaptateur
        dbHelper = new Sqlite_DB_handler(this);
        List<User> userList = dbHelper.getAllUsers();
        userAdapter = new UserAdapter(this, userList);
        userListView.setAdapter(userAdapter);

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(SignInActivity.signinCredentials, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent signin = new Intent(loginSuccess.this, SignInActivity.class);
                startActivity(signin);
            }
        });
    }
}
