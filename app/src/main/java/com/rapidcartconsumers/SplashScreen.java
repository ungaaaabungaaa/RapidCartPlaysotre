package com.rapidcartconsumers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setOrientation(SplashScreen.this);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashScreen.this, ShopSelectActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() { // TODO Auto-generated method stub
        super.onPause();
        finish();
    }


    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser == null) {
            Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }

    private void setOrientation(SplashScreen context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}