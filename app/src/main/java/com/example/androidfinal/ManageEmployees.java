package com.example.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
    private Employee clickedEmployee = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_employees);
        lstvEmployees = findViewById(R.id.lstvEmployees);

        dataBaseHelper = new DatabaseHelper(ManageEmployees.this);

        employeeAdapter = new EmployeeList(ManageEmployees.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEmployee());

        lstvEmployees.setAdapter(employeeAdapter);



        lstvEmployees.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clickedEmployee = (Employee) parent.getItemAtPosition(position);

                double earnings = clickedEmployee.calcEarnings();

                TextView payroll = findViewById(R.id.txtPayrollDisplay);

                payroll.setText(String.valueOf(earnings));

            }
        });

        // binding event
        btnDelete = findViewById(R.id.btnDeleteEmployee);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickedEmployee != null) {
                    dataBaseHelper.deleteEmployee(clickedEmployee);

                    employeeAdapter = new EmployeeList(ManageEmployees.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEmployee());

                    lstvEmployees.setAdapter(employeeAdapter);
                    Toast.makeText(ManageEmployees.this, "Employee: " + clickedEmployee.getFirstName() + ", ID: " + clickedEmployee.getEmployeeID() + " deleted.", Toast.LENGTH_LONG).show();

                    clickedEmployee = null;
                }
                else
                    Toast.makeText(ManageEmployees.this, "Please select an Employee to delete!", Toast.LENGTH_LONG).show();
            }
        });


    }
}