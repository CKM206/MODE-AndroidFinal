package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AddEmployeeFulltime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_fulltime);
    }

    public void handleSubmitAddFullTime(View view) {
        Toast toast = Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_SHORT);

        toast.show();
    }
}