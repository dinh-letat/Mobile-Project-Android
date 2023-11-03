package com.example.cardplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = findViewById(R.id.startButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve selected countdown time and button click limit
                int countdownTime = 10; // Replace with the actual value
                int buttonClickLimit = 5; // Replace with the actual value

                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                intent.putExtra("countdownTime", countdownTime);
                intent.putExtra("buttonClickLimit", buttonClickLimit);

                startActivity(intent);
            }
        });
    }
}