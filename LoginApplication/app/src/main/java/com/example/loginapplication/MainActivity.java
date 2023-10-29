package com.example.loginapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit_user = findViewById(R.id.edit_user);
        EditText edit_pass = findViewById(R.id.edit_pass);
        Button btn_signin = findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edit_user.getText().toString();
                String pass = edit_pass.getText().toString();
                if(user.equals("admin") && pass.equals("123456") ||
                        user.equals("user") && pass.equals("123456")){
                    Intent intent = new Intent(MainActivity.this, Home.class);
                    intent.putExtra("user", user);
                    intent.putExtra("pass", pass);
                    startActivity(intent);
                }
            }
        });




    }



}