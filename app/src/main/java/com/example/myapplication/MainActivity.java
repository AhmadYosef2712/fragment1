package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
public static FrameLayout frHome,frFirst,frSecond;
private BottomNavigationView nav1;
private second homeFrag;
private firstFrag firstFrag;
private home secondFrag;
private EditText p,u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frHome = findViewById(R.id.fr1);
        frFirst = findViewById(R.id.fr2);
        frSecond = findViewById(R.id.fr3);


        homeFrag = new second();
        firstFrag = new firstFrag();
        secondFrag = new home();

        getSupportFragmentManager().beginTransaction().replace(R.id.fr1, homeFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fr2, firstFrag).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.fr3, secondFrag).commit();

        nav1 = findViewById(R.id.nav);


        nav1.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.mnuHome) {
                    frFirst.setVisibility(View.INVISIBLE);
                    frSecond.setVisibility(View.INVISIBLE);
                    frHome.setVisibility(View.VISIBLE);
                }
                if (item.getItemId() == R.id.mnuFrag1) {
                    frFirst.setVisibility(View.VISIBLE);
                    frSecond.setVisibility(View.INVISIBLE);
                    frHome.setVisibility(View.INVISIBLE);
                }
                if (item.getItemId() == R.id.mnuFrag2) {
                    frSecond.setVisibility(View.VISIBLE);
                    frFirst.setVisibility(View.INVISIBLE);
                    frHome.setVisibility(View.INVISIBLE);
                }

                return true;
            }

        });





    }

    @Override
    public void onClick(View v) {
    }
    public void exit(View v) {
        finish();
        System.exit(0);
    }
}