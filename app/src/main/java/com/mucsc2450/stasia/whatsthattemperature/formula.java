package com.mucsc2450.stasia.whatsthattemperature;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class formula extends AppCompatActivity {
    private TextView mText;
    private String EXTRA_Temp, EXTRA_Type;
    private Float n,degrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formula);
        EXTRA_Temp=getIntent().getExtras().getString("Temp");
        EXTRA_Type=getIntent().getExtras().getString("Type");

        mText=(TextView)findViewById(R.id.text);



       n= Float.parseFloat(EXTRA_Temp);

        if (EXTRA_Type.equals("f")) {

            degrees = ((n * (9 / 5)) + 32);
            mText.setText("Fahrenheit to Celsius: " + (Float.toString(degrees)));
        }
        if (EXTRA_Type.equals("c")) {
            degrees = ((n - 32) * 5 / 9);
            mText.setText("Celsius to Fahrenheit: " + (Float.toString(degrees)));
        }


    }

}