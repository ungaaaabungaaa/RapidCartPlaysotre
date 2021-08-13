package com.rapidcartconsumers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentMode extends AppCompatActivity {


    Button cashondilivery;
    Button Onlinepayment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_mode);
        setOrientation(PaymentMode.this);
        cashondilivery=findViewById(R.id.button7);
        cashondilivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(PaymentMode.this, DeliveryTypeActivity.class);
                startActivity(setupIntent);
            }
        });


        Onlinepayment=findViewById(R.id.button4);
        Onlinepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent setupIntent = new Intent(PaymentMode.this, Comingsoon.class);
                startActivity(setupIntent);

            }
        });
    }



    private void setOrientation(PaymentMode context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
    }