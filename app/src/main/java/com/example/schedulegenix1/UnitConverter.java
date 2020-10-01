package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnitConverter extends AppCompatActivity {


    Button mass, temp,liter, length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        mass = findViewById(R.id.massbutton);
        mass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UnitConverter.this, Kg_lb.class);
                startActivity(intent);
            }
        });


        temp = findViewById(R.id.TemperatureButton);
        temp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UnitConverter.this, unit_temp.class);
                startActivity(intent);
            }
        });


        liter = findViewById(R.id.LiterButton);
        liter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UnitConverter.this, Litte_Gallon.class);
                startActivity(intent);
            }
        });


        length = findViewById(R.id.LengthButton);
        length.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UnitConverter.this, CmInchConverter.class);

                startActivity(intent);
            }
        });
    }

}