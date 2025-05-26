package com.example.health;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogainActivity extends AppCompatActivity {

    private Button btnLogin,register;
   EditText Email,Password;
   FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logain2);
Email=findViewById(R.id.editTextText);
Password=findViewById(R.id.editTextTextPassword2);
mAuth=FirebaseAuth.getInstance();
        btnLogin = findViewById(R.id.button);
        register= findViewById(R.id.Signup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LogainActivity.this, "You Have Successfully Logged In", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LogainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LogainActivity.this, "Error", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                // Display a toast message indicating successful login
              /*  Toast.makeText(LogainActivity.this, "You Have Successfully Logged In", Toast.LENGTH_LONG).show();



                // Start the RegisterActivity (or HomeActivity if it is the actual target)
                Intent intent = new Intent(LogainActivity.this, RegisterActivity.class); // Replace RegisterActivity.class with HomeActivity.class if needed
                startActivity(intent);*/
            }
        });
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(LogainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
});

    }


}
