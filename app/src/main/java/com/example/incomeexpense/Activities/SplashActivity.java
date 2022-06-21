package com.example.incomeexpense.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.incomeexpense.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    FirebaseUser currentUser;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

            mAuth = FirebaseAuth.getInstance();
            if (mAuth != null) {
                currentUser = mAuth.getCurrentUser();
            }
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    FirebaseUser user = mAuth.getCurrentUser();
                    if (user == null) {
                        Intent intent = new Intent(getApplicationContext(),LoginRegistrationActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Intent mainIntent = new Intent(getApplicationContext(),HomeActivity.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mainIntent);
                        finish();
                    }
                }
            }, 1000);
        }
    }

