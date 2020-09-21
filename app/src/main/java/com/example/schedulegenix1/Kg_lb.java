package com.example.schedulegenix1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Kg_lb extends AppCompatActivity {

    EditText ETn1 , ETn2;
    String kgVal, lbVal;
    TextView answerInlb, answerInkg;

    Double n1, n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kg_lb);

        ETn1 = findViewById(R.id.InputinKG);
        ETn2 = findViewById(R.id.Inputinlb);
        answerInlb = findViewById(R.id.answerInlb);
        answerInkg = findViewById(R.id.AnswerInkg);
    }

    public void convertTolb(View view){
        kgVal = ETn1.getText().toString();
        if (kgVal != null && !kgVal.equals("")){
            n1 = Double.parseDouble(kgVal);
            n1 = n1 * 2.2046;

        }
        answerInlb.setText("" + n1 + " lb");
    }

    public void convertTokg(View view){
        lbVal = ETn2.getText().toString();
        if (lbVal != null && !lbVal.equals("")){
            n2 = Double.parseDouble(lbVal);
            n2 = n2 / 2.2046;

        }
        answerInkg.setText("" + n2 + " kg");
    }


}