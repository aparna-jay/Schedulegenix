package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnitConverter extends AppCompatActivity {
    Button mass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);
        mass = findViewById(R.id.massbutton);
        mass.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(UnitConverter.this, Cm_inch.class);
                startActivity(intent);
            }
        });
    }
}