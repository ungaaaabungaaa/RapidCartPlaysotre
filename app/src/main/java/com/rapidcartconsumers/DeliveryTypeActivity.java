package com.rapidcartconsumers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DeliveryTypeActivity extends AppCompatActivity {

    Button shoppick;
    Button homedelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_type);
        setOrientation(DeliveryTypeActivity.this);
        shoppick=findViewById(R.id.button4);
        homedelivery=findViewById(R.id.button7);
        shoppick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send a new string
                String Shopid="Shoppick";
                Intent Intent = new Intent(DeliveryTypeActivity.this, SummartActivity.class);
                Intent.putExtra("shopid",Shopid);
                startActivity(Intent);

            }
        });
        homedelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send a new string
                String Shopid="Homedelivery";
                Intent Intent = new Intent(DeliveryTypeActivity.this, SummartActivity.class);
                Intent.putExtra("shopid",Shopid);
                startActivity(Intent);
            }
        });
    }

    private void setOrientation(DeliveryTypeActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}
