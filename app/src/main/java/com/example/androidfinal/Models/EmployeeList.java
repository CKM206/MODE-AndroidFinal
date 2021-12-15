package com.example.androidfinal.Models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.androidfinal.R;

import java.util.List;

public class EmployeeList extends ArrayAdapter {

    private Integer imageId;
    private Activity context;
    private List employees;

    public EmployeeList(@NonNull Activity context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.imageId = R.drawable.smile1;
        this.context = context;
        this.employees = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.row_item, null, true);


        ImageView employeeImage = (ImageView) row.findViewById(R.id.ivEmployeeImage);
        TextView employeeInfo = (TextView) row.findViewById(R.id.txtEmployeeInfo);


        employeeInfo.setText(employees.get(position).toString());
        employeeImage.setImageResource(imageId);

        return  row;
    }


}
