package com.example.androidfinal;

import android.os.Bundle;

import com.example.androidfinal.helpers.DatabaseHelper;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.androidfinal.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import com.example.androidfinal.Models.*;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
         databaseHelper = new DatabaseHelper(MainActivity.this);

         FullTime employee = new FullTime(1, "Eduardo", "San Martin Celi", 1995, "F", 65000, 250);
         PartTime employee2 = new PartTime(1, "Tom", "Zielinski", 1990, "P",48, 35);

         boolean result = databaseHelper.addFullTime(employee);
         result = databaseHelper.addPartTime(employee2);

    }

}