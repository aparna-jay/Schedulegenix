package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        if (FahrVal != null && !FahrVal.equals("")) {
            getFahrVal(FahrVal);
        }
        answerInCel.setText("" + n1 + " C");
    }

    public void convertToFahr(View view){
        CelVal = ETn2.getText().toString();
        if (CelVal != null && !CelVal.equals("")){
            getCelVal(CelVal);
        }
        answerInFahr.setText("" + n2 + " F");
    }

    public double getFahrVal(String CelVal){
        n1 = Double.parseDouble(CelVal);
        n1 = 5.0/9.0* (n1-32.0);
        return n1;
    }
    public double getCelVal(String FahrVal){
        n2 = Double.parseDouble(FahrVal);
        n2 = 9.0/5.0*(n2) + 32;
        return n2;
    }

}