package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {


    private ImageButton schedule, contacts, personal, Card;

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
        contacts = findViewById(R.id.btn_contacts);
        contacts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewContactDetails();
            }
        });
        personal = findViewById(R.id.personalButton);
        personal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewPersonalInformation();
            }
        });

        units = findViewById(R.id.UnitConverter);
        units.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    ViewUnitConverter();
                }

                });

        Card = findViewById(R.id.Card);
        Card.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ViewCard();
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

    private void ViewContactDetails(){
        Intent intent = new Intent(MainActivity.this, Contact.class);
        startActivity(intent);
    }



    private void ViewPersonalInformation(){
        Intent intent = new Intent(MainActivity.this, PersonalInfo.class);
        startActivity(intent);
    }

    private void ViewCard(){
        Intent intent = new Intent(MainActivity.this, MainActivityCard.class);
        startActivity(intent);
    }


}