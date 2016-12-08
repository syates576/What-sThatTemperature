package com.mucsc2450.stasia.whatsthattemperature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mCalculate1;
    private Button mCalculate2;
    private Button mContactButton;
    private String EXTRA_Name;
    private EditText mFahrenheitEditText;
    private EditText mCelsiusEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EXTRA_Name = getIntent().getExtras().getString("name");

        mContactButton = (Button) findViewById(R.id.contact_button);

        mCalculate1 = (Button) findViewById(R.id.calculate1_button1);
        mCalculate2 = (Button) findViewById(R.id.calculate2_button2);
        mFahrenheitEditText = (EditText) findViewById(R.id.FahrenheitName);
        mCelsiusEditText = (EditText) findViewById(R.id.CelsiusName);

        mContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Contact.class);
                i.putExtra("name",EXTRA_Name);
                startActivity(i);
            }
        });

        mCalculate1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, formula.class);
                i.putExtra("Temp", mFahrenheitEditText.getText().toString());
                i.putExtra("Type", "f");
                startActivity(i);
            }
        });
        mCalculate2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MainActivity.this, formula.class);
            i.putExtra("Temp", mCelsiusEditText.getText().toString());
            i.putExtra("Type", "c");
            startActivity(i);
        }
    });
    }
    }
