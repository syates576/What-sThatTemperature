package com.mucsc2450.stasia.whatsthattemperature;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class google extends AppCompatActivity {
    private EditText editTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google1);}

    public void onSearchClick(View v) {


        try {
            Intent i = new Intent(Intent.ACTION_WEB_SEARCH);
            String term = editTextInput.getText().toString();
            i.putExtra(SearchManager.QUERY, term);
            startActivity(i);
        } catch (Exception e) {
        }
    }
}
