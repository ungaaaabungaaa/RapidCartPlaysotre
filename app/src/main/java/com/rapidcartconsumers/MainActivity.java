package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private String TAG = "SignupActivity";
    private  int RC_SIGN_IN=1;
    private GoogleSignInClient googleSignInClient;
    TextView register;
    ProgressBar progressBar;
    Button Phoneauth;
    Button emaillogin;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.mainlayout);
        emaillogin=findViewById(R.id.button8);
        emaillogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, EmailActivity.class);
                startActivity(mainIntent);
            }
        });
        progressBar=findViewById(R.id.progressBar);
        Phoneauth=findViewById(R.id.button10);
        register=findViewById(R.id.textView);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://forms.gle/bWWyQbRfS4pYpa2D6";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });


        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleSignInClient= GoogleSignIn.getClient(this,gso);
        Button googlebutton=findViewById(R.id.button3);
        googlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();
                progressBar.setVisibility(View.VISIBLE);
            }
        });


        Phoneauth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Phone auth login duh
                Intent mainIntent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(mainIntent);

            }
        });



    }

    private void signin() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                Log.w(TAG, "Google sign in failed", e);
                progressBar.setVisibility(View.INVISIBLE);

            }
        }
    }


    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "signInWithCredential:success");
                    finshtask();
                } else {
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                }
            }
        });
    }

    private void finshtask() {
        progressBar.setVisibility(View.INVISIBLE);
        Intent mainIntent = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(mainIntent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent mainIntent = new Intent(MainActivity.this, SplashScreen.class);
            startActivity(mainIntent);
        }
        else
        {
            constraintLayout.setVisibility(View.VISIBLE);
        }
    }

    private void setOrientation(MainActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}
