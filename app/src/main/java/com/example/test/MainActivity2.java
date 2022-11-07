package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button datePickerButton = findViewById(R.id.datePickerButton);
        Button monthViewButton = findViewById(R.id.monthViewButton);
        Button calendarViewButton = findViewById(R.id.calendarViewButton);

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, DatePickerActivity.class));
            }
        });

        monthViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Not implemented yet in Java!", Toast.LENGTH_LONG).show();
            }
        });

        calendarViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Not implemented yet in Java!", Toast.LENGTH_LONG).show();
            }
        });
    }
}