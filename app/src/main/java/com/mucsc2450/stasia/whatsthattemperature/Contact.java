package com.mucsc2450.stasia.whatsthattemperature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends AppCompatActivity {
    private String EXTRA_contactName;
    private Button mSendButton, mCancelButton;
    private EditText mNameEdit, mEmailEdit, mSubjectEdit, mMessageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        mNameEdit = (EditText) findViewById(R.id.contactName);
        mEmailEdit = (EditText) findViewById(R.id.contactEmail);
        mSubjectEdit = (EditText) findViewById(R.id.contactSubject);
        mMessageEdit = (EditText) findViewById(R.id.contactMessage);
        mCancelButton = (Button) findViewById(R.id.cancel_button);
        mSendButton = (Button) findViewById(R.id.send_button);

        EXTRA_contactName = getIntent().getExtras().getString("name");
        mNameEdit.setText(EXTRA_contactName);


        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{ mEmailEdit.getText().toString()});
                i.putExtra(Intent.EXTRA_SUBJECT, mSubjectEdit.getText().toString());
                i.putExtra(Intent.EXTRA_TEXT   , mMessageEdit.getText().toString());

                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(Contact.this,
                            "There are no email clients installed.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
