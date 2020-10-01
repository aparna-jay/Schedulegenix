package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Litte_Gallon extends AppCompatActivity {

    EditText ETn1 , ETn2;
    String lVal, gallonVal;
    TextView answerIngallon, answerInl;
    Double n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litte__gallon);

        ETn1 = findViewById(R.id.Inputinl);
        ETn2 = findViewById(R.id.Inputingallon);
        answerInl = findViewById(R.id.answerInl);
        answerIngallon = findViewById(R.id.AnswerIngallon);

    }

    public void convertTogallon(View view){
        lVal = ETn1.getText().toString();
        if (lVal != null && !lVal.equals("")) {
            getgallonVal(lVal);
        }
        answerIngallon.setText("" + n1 + " gallon");
    }

    public void convertTol(View view){
        gallonVal = ETn2.getText().toString();
        if (gallonVal != null && !gallonVal.equals("")){
            getlVal(gallonVal);
        }
        answerInl.setText("" + n2 + " l");
    }

    public double getgallonVal(String lVal){
        n1 = Double.parseDouble(lVal);
        n1 = n1 / 3.785;
        return n1;
    }
    public double getlVal(String gallonVal){
        n2 = Double.parseDouble(gallonVal);
        n2 = n2 * 3.785;
        return n2;
    }
}