package com.example.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FindDoctorActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_find_doctor);

    CardView exit = findViewById(R.id.cardFDBack);
    exit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
      }
    });

    CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
    familyphysician.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
        it.putExtra("title","Family Physicians");
        startActivity(it);
      }
    });

    CardView dietitian = findViewById(R.id.cardFDDietician);
    dietitian.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
        it.putExtra("title","Dietitian");
        startActivity(it);
      }
    });


    CardView Dentist = findViewById(R.id.cardFDDentist);
    Dentist.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
        it.putExtra("title","Dentists");
        startActivity(it);
      }
    });



    CardView cardiologists = findViewById(R.id.cardFDCardiologists);
    cardiologists.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent it = new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
        it.putExtra("title","Cardiologists");
        startActivity(it);
      }
    });


  }
}
