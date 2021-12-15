package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidfinal.Models.EmployeeList;
import com.example.androidfinal.Models.FullTime;
import com.example.androidfinal.Models.PartTime;
import com.example.androidfinal.Models.Employee;
import com.example.androidfinal.helpers.DatabaseHelper;

import java.util.List;

public class ManageEmployees extends AppCompatActivity {

    EmployeeList employeeAdapter;
    DatabaseHelper dataBaseHelper;
    //Employee employee;
    ListView lstvEmployees;
    int Payroll;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employees);
        lstvEmployees = findViewById(R.id.lstvEmployees);

        // binding event
        btnDelete = findViewById(R.id.btnDeleteEmployee);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ManageEmployees.this, "test", Toast.LENGTH_SHORT).show();
            }
        });


        dataBaseHelper = new DatabaseHelper(ManageEmployees.this);

        employeeAdapter = new EmployeeList(ManageEmployees.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEmployee());

        lstvEmployees.setAdapter(employeeAdapter);
    }
}