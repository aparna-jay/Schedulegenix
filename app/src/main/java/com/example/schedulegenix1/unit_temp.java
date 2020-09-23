package com.example.schedulegenix1;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class unit_temp extends AppCompatActivity {

    EditText ETn1 , ETn2;
    String FahrVal, CelVal;
    TextView answerInCel, answerInFahr;

    Double n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        ETn1 = findViewById(R.id.InputinFahr);
        ETn2 = findViewById(R.id.InputinCel);
        answerInCel = findViewById(R.id.AnswerInCel);
        answerInFahr = findViewById(R.id.AnswerInFahr);
    }

    public void convertTocel(View view){
        FahrVal = ETn1.getText().toString();
        if (FahrVal != null && !FahrVal.equals("")){
            n1 = Double.parseDouble(FahrVal);
            n1 = 5.0/9.0* (n1-32.0) ;

        }
        answerInCel.setText("" + n1 + " c");
    }

    public void convertToFahr(View view){
        CelVal = ETn2.getText().toString();
        if (CelVal != null && !CelVal.equals("")){
            n2 = Double.parseDouble(CelVal);
            n2 = 9.0/5.0*(n2) + 32;

        }
        answerInCel.setText("" + n2 + " F");
    }


}

