package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button schedule;
    private Button units;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        schedule = findViewById(R.id.btn_Schedules);
        schedule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewScheduleDetails();
            }
        });
        units = findViewById(R.id.UnitConverter);
        units.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewUnitConverter();
            }
        });

    }

    private void ViewScheduleDetails(){
        Intent intent = new Intent(MainActivity.this, Schedule.class);
        startActivity(intent);
    }

    private void ViewUnitConverter(){
        Intent intent = new Intent(MainActivity.this, UnitConverter.class);
        startActivity(intent);
    }


}