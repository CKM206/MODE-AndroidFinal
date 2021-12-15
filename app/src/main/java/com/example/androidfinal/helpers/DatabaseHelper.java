package com.example.androidfinal.helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

import com.example.androidfinal.Models.Employee;
import com.example.androidfinal.Models.FullTime;
import com.example.androidfinal.Models.PartTime;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Static Variables
    //-Employee
    public static final String EMPLOYEE_TABLE = "EMPLOYEE_TABLE";
    public static final String COLUMN_EMPLOYEE_NAME = "EMPLOYEE_NAME";
    public static final String COLUMN_EMPLOYEE_BIRTH = "EMPLOYEE_DATE_OF_BIRTH";
    public static final String COLUMN_TYPE = "COLUMN_TYPE";
    public static final String COLUMN_ID = "ID";

    //-Full time
    public static final String FULL_TIME_TABLE = "FULL_TIME_TABLE";
    public static final String EMPLOYEE_ID = "EMPLOYEE_ID";
    public static final String SALARY = "SALARY";
    public static final String BONUS = "BONUS";

    //-Part time
    public static final String PART_TIME_TABLE = "PART_TIME_TABLE";
    //public static final String EMPLOYEE_ID = "EMPLOYEE_ID";
    public static final String HOURS_WORKED = "HOURS_WORKED";
    public static final String RATE = "RATE";

    //-VEHICLES
    public static final String VEHICLE = "VEHICLE_TABLE";
    //public static final String EMPLOYEE_ID = "EMPLOYEE_ID";
    public static final String MAKE = "VEHICLE_MAKE";
    public static final String PLATE_NUMBER = "VEHICLE_PLATE_NUMBER";

    // Constructor - Builds Tables
    public DatabaseHelper(@Nullable Context context) {
        super(context, "AndroidFinal.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Employee Table
        String createEmployee = "CREATE TABLE EMPLOYEE_TABLE(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EMPLOYEE_NAME + " TEXT, " + COLUMN_EMPLOYEE_BIRTH + " DATE, " + COLUMN_TYPE + " TEXT)";
        String createFullTime = "CREATE TABLE FULL_TIME_TABLE(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SALARY + " DOUBLE, " +
                BONUS + " FLOAT, " +
                EMPLOYEE_ID + " INTEGER, " +
                "FOREIGN KEY(" + EMPLOYEE_ID + ") REFERENCES " + EMPLOYEE_TABLE + "(" + COLUMN_ID + "));";

        String createPartTime = "CREATE TABLE PART_TIME_TABLE(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HOURS_WORKED + " DOUBLE, " +
                RATE + " FLOAT, " +
                EMPLOYEE_ID + " INTEGER, " +
                "FOREIGN KEY(" + EMPLOYEE_ID + ") REFERENCES " + EMPLOYEE_TABLE + "(" + COLUMN_ID + "));";

        String createVehicle = "CREATE TABLE VEHICLE_TABLE(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                MAKE + " TEXT, " +
                PLATE_NUMBER + " TEXT, " +
                EMPLOYEE_ID + " INTEGER, " +
                "FOREIGN KEY(" + EMPLOYEE_ID + ") REFERENCES " + EMPLOYEE_TABLE + "(" + COLUMN_ID + "));";

        db.execSQL(createEmployee);
        db.execSQL(createFullTime);
        db.execSQL(createPartTime);
        db.execSQL(createVehicle);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private long addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_EMPLOYEE_NAME, employee.getFirstName() + " " + employee.getLastName());
        cv.put(COLUMN_EMPLOYEE_BIRTH, employee.getBirthYear());
        cv.put(COLUMN_TYPE, employee.getType());

        return db.insert(EMPLOYEE_TABLE,null ,cv);

    }

    public boolean addFullTime(FullTime employee) {

        long result = this.addEmployee(employee);

        if(result > -1) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(EMPLOYEE_ID, (int)result);
            cv.put(SALARY, employee.getSalary());
            cv.put(BONUS, employee.getBonus());

            long ftResult = db.insert(FULL_TIME_TABLE,null ,cv);

            return ftResult != -1;

        }

        return false;
    }

    public boolean addPartTime(PartTime employee) {

        long result = this.addEmployee(employee);

        if(result > -1) {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put(EMPLOYEE_ID, (int)result);
            cv.put(HOURS_WORKED, employee.getRate());
            cv.put(RATE, employee.getHoursWorked());

            long ftResult = db.insert(PART_TIME_TABLE,null ,cv);

            return ftResult != -1;

        }

        return false;
    }

//    public boolean deleteEmployee(Employee employee) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String deleteStatement = "DELETE FROM " + EMPLOYEE_TABLE + " WHERE " + COLUMN_ID + " = " + employee.getId();
//
//        db.rawQuery(deleteStatement, null);
//
//
//        return false;
//    }




}
