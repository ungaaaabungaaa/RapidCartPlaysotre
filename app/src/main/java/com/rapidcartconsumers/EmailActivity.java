package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class EmailActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        setOrientation(EmailActivity.this);
        mAuth = FirebaseAuth.getInstance();
        Button floatingActionButton=findViewById(R.id.floatingActionButton);
        EditText editmail=findViewById(R.id.mailid);
        EditText editpassword=findViewById(R.id.password);
        String email=editmail.getText().toString();
        String password=editpassword.getText().toString();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email!=null&&password!=null)
                {
                    String email=editmail.getText().toString();
                    String password=editpassword.getText().toString();
                    mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            Intent intent = new Intent(EmailActivity.this,ProfileActivity.class);
                            startActivity(intent);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(EmailActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
                else
                {
                    Toast.makeText(EmailActivity.this,"Missing Something ?", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setOrientation(EmailActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }


}