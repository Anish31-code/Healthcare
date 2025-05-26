package com.example.health;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LabTestActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lab_test);




        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, LabTestDetailsActivity.class));
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView bloodTests = findViewById(R.id.cardBloodTests);
        bloodTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("title", "Blood Tests");
                startActivity(it);
            }
        });




        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView imagingTests = findViewById(R.id.cardImagingTests);
        imagingTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("title", "Imaging Tests");
                startActivity(it);
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CardView cardiacTests = findViewById(R.id.cardCardiacTests);
        cardiacTests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("title", "Cardiac Tests");
                startActivity(it);
            }
        });
    }
}
