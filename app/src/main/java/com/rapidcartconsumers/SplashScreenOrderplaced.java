package com.rapidcartconsumers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreenOrderplaced extends AppCompatActivity {


    Button checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_orderplaced);
        setOrientation(SplashScreenOrderplaced.this);
        checkout = findViewById(R.id.button2);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    private void setOrientation(SplashScreenOrderplaced context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}

