package com.example.akshay.sqlliteloginregister;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Akshay on 07-02-2018.
 */

public class RegisterActivity extends AppCompatActivity {
    EditText etName,etEmail,etPassword;
    RadioGroup rgGender;
    RadioButton rbMale,rbFemale;
    MyDatabaseHelper myDB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        rgGender = (RadioGroup) findViewById(R.id.rgGender);

        myDB = new MyDatabaseHelper(this,null,null,1);

    }

    public void register(View view){
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        int rCheckId = rgGender.getCheckedRadioButtonId();
        RadioButton rb = findViewById(rCheckId);
        String gender = rb.getText().toString();

       /* boolean isInserted = myDB.insertData(name,email,password,gender);
        if (isInserted == true)
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Data not Inserted", Toast.LENGTH_SHORT).show();

            */

        launchActivity();


    }

    private void launchActivity() {
        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);
    }


}
