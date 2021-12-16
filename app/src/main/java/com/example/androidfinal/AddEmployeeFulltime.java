package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidfinal.Models.FullTime;
import com.example.androidfinal.Models.PartTime;
import com.example.androidfinal.helpers.DatabaseHelper;

public class AddEmployeeFulltime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee_fulltime);
    }

    public void handleSubmitAddFullTime(View view) {
        EditText firstName = findViewById(R.id.etFirstName);
        EditText lastName = findViewById(R.id.etLastName);
        EditText birthday = findViewById(R.id.etBirthDay);
        String type = "F";
        EditText salary = findViewById(R.id.etSalary);
        EditText bonus = findViewById(R.id.etBonus);

        DatabaseHelper dataBaseHelper;
        FullTime employee;

        try {
            //int employeeID, String firstName, String lastName, int birthYear, String type, int hoursWorked, int rate
            employee = new FullTime(-1, firstName.getText().toString(), lastName.getText().toString(), Integer.parseInt(birthday.getText().toString()), type, Integer.parseInt(salary.getText().toString()), Integer.parseInt(bonus.getText().toString()));
            // Toast.makeText(MainActivity.this, "Customer Inserted", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(AddEmployeeFulltime.this, "Error creating full time employee", Toast.LENGTH_LONG).show();
            employee = new FullTime(-1, "error", "error", 0, type, 0 , 0);
        }

        dataBaseHelper = new DatabaseHelper(AddEmployeeFulltime.this);
        boolean success = dataBaseHelper.addFullTime(employee);

        if (!success) {
            Toast.makeText(AddEmployeeFulltime.this, "Error creating full time employee", Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(AddEmployeeFulltime.this, ManageEmployees.class);

            startActivity(intent);
        }
    }
}