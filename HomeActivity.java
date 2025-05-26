package com.example.health;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HomeActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private CardView cardViewExit;
    private CardView cardViewFindDoctor;
    private CardView cardViewLabTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("sharedPreferences", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "");
        if (!username.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Welcome " + username, Toast.LENGTH_SHORT).show();
        }

        initializeViews();
        setListeners();
    }

    private void initializeViews() {
        cardViewExit = findViewById(R.id.cardExit);
        cardViewFindDoctor = findViewById(R.id.cardFindDoctor);
        cardViewLabTest = findViewById(R.id.cardLabTest);
    }

    private void setListeners() {
        cardViewExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleExit();
            }
        });

        cardViewFindDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFindDoctor();
            }
        });

        cardViewLabTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToLabTest();
            }
        });
    }

    private void handleExit() {
        sharedPreferences.edit().clear().apply();
        startActivity(new Intent(HomeActivity.this, LogainActivity.class)); // Navigate to LoginActivity or appropriate start activity
        finish(); // Close the current activity
    }

    private void navigateToFindDoctor() {
        startActivity(new Intent(HomeActivity.this, FindDoctorActivity.class));
    }

    private void navigateToLabTest() {
        startActivity(new Intent(HomeActivity.this, LabTestActivity.class));
    }
}
