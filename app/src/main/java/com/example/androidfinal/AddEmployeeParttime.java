package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidfinal.Models.EmployeeList;
import com.example.androidfinal.helpers.DatabaseHelper;

import com.example.androidfinal.Models.PartTime;

public class AddEmployeeParttime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_parttime);
    }

    public void handleSubmitAddPartTime(View view) {
        EditText firstName = findViewById(R.id.etFirstName);
        EditText lastName = findViewById(R.id.etLastName);
        EditText birthday = findViewById(R.id.etBirthDay);
        String type = "P";
        EditText rate = findViewById(R.id.etRate);
        EditText hours = findViewById(R.id.etHours);

        DatabaseHelper dataBaseHelper;
        PartTime employee;

        try {
            //int employeeID, String firstName, String lastName, int birthYear, String type, int hoursWorked, int rate
            employee = new PartTime(-1, firstName.getText().toString(), lastName.getText().toString(), Integer.parseInt(birthday.getText().toString()), type, Integer.parseInt(rate.getText().toString()), Integer.parseInt(hours.getText().toString()));
            // Toast.makeText(MainActivity.this, "Customer Inserted", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(AddEmployeeParttime.this, "Error creating part time employee", Toast.LENGTH_LONG).show();
            employee = new PartTime(-1, "error", "error", 0, type, 0 , 0);
        }

        dataBaseHelper = new DatabaseHelper(AddEmployeeParttime.this);
        boolean success = dataBaseHelper.addPartTime(employee);

        if (!success) {
            Toast.makeText(AddEmployeeParttime.this, "Error creating part time employee", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(AddEmployeeParttime.this, ManageEmployees.class);

            startActivity(intent);
        }


    }
}