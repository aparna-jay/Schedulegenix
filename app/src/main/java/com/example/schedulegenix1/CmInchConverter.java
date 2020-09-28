package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CmInchConverter extends AppCompatActivity {

    EditText ETn1 , ETn2;
    String CmVal, InchVal;
    TextView answerInInch, answerInCm;

    Double n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cm_inch_converter);

        ETn1 = findViewById(R.id.InputinCm);
        ETn2 = findViewById(R.id.InputinInch);
        answerInInch = findViewById(R.id.answerInInch);
        answerInCm = findViewById(R.id.AnswerInCm);
    }

    public void convertToInch(View view){
        CmVal = ETn1.getText().toString();
        if (CmVal != null && !CmVal.equals("")){
            getinchVal(CmVal);

        }
        answerInInch.setText("" + n1 + " Inches");
    }

    public void convertToCm(View view){
        InchVal = ETn2.getText().toString();
        if (InchVal != null && !InchVal.equals("")){
           getcmVal(InchVal );

        }
        answerInCm.setText("" + n2 + " cm");
    }

    public double getcmVal(String InchVal){
        n2 = Double.parseDouble(InchVal);
        n2 = n2 / 0.39370;
        return n2;
    }

    public double getinchVal(String CmVal){
        n1 = Double.parseDouble(CmVal);
        n1 = n1 * 0.39370;
        return n1;
    }
}