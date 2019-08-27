package com.example.practiceandroidinschool;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentContainer;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolBar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigationView);

        if (savedInstanceState != null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.fragment_container, homeFragment);
            fragmentTransaction.commit();
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.perimeter_acreage: {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        PerimeterAcreage perimeterAcreage = new PerimeterAcreage();
                        fragmentTransaction.add(R.id.fragment_container, perimeterAcreage);
                        fragmentTransaction.commit();


                        menuItem.setChecked(true);
                        displayMessage("Tính chu vi và diện tích");
                        break;

                    }
                    case R.id.compute_calendar: {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        ComputeCalender computeCalender = new ComputeCalender();
                        fragmentTransaction.add(R.id.fragment_container, computeCalender);
                        fragmentTransaction.commit();

                        menuItem.setChecked(true);
                        displayMessage("Tính năm âm lịch");
                        break;
                    }

                    case R.id.simple_equation: {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        SimpleEquation simpleEquation = new SimpleEquation();
                        fragmentTransaction.add(R.id.fragment_container, simpleEquation);
                        fragmentTransaction.commit();
                        menuItem.setChecked(true);
                        displayMessage("Phương trình bậc nhất");
                        break;
                    }

                    case R.id.multiplication_table: {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        MultiplicationTables multiplicationTables = new MultiplicationTables();
                        fragmentTransaction.add(R.id.fragment_container, multiplicationTables);
                        fragmentTransaction.commit();
                        menuItem.setChecked(true);
                        displayMessage("Bảng cửu chương");
                        break;
                    }

                    case R.id.splite_fullname: {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        SplitFullName splitFullName = new SplitFullName();
                        fragmentTransaction.add(R.id.fragment_container, splitFullName);
                        fragmentTransaction.commit();
                        menuItem.setChecked(true);
                        displayMessage("Họ và tên riêng");
                        break;
                    }

                    case R.id.format_aray: {
                        fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        HandleWithArrayRandom handleWithArrayRandom = new HandleWithArrayRandom();
                        fragmentTransaction.add(R.id.fragment_container, handleWithArrayRandom);
                        fragmentTransaction.commit();
                        menuItem.setChecked(true);
                        displayMessage("Thao tác với mảng");
                        break;
                    }
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void displayMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void computeAcreage(View view) {
    }
}
