package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    ImageView cart;
    TextView addressdisplay;
    ImageView fruits,vegitables,meat,clothes,essentail,dairy,dryfruits,staniory,snaks,bevrages,personalcare;
    public FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    String user_id;
    ImageView menu;

    
    // check target is displayed or not


    public static final String SHARED_PREFS2 = "sharedPrefs";
    public static final String TEXT2 = "text";
    public static final String SWITCH1 = "switch1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mAuth = FirebaseAuth.getInstance();
        setOrientation(HomeActivity.this);
        loadData();
        menu=findViewById(R.id.imageView6);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(setupIntent);
            }
        });

        FirebaseMessaging.getInstance().subscribeToTopic("weather");
        addressdisplay=findViewById(R.id.textView7);
        cart=findViewById(R.id.imageView9);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
        fruits=findViewById(R.id.imageView17);
        vegitables=findViewById(R.id.imageView16);
        meat=findViewById(R.id.imageView15);
        clothes=findViewById(R.id.imageView19);
        essentail=findViewById(R.id.imageView20);
        dairy=findViewById(R.id.imageView18);
        dryfruits=findViewById(R.id.imageView21);
        staniory=findViewById(R.id.imageView22);
        snaks=findViewById(R.id.imageView23);
        bevrages=findViewById(R.id.imageView24);
        personalcare=findViewById(R.id.imageView25);
        Bundle bundle2 = getIntent().getExtras();

        if (bundle2 != null) {
            String shopid=bundle2.get("shopid").toString();

            fruits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, FruitsActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });

            vegitables.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, vegitablesActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });
            meat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, meatActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });
            clothes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, cothesActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });
            essentail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, essentailActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });
            dairy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, dairyActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });
            dryfruits.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, dryfruitsActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });
            staniory.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, stationeryActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);

                }
            });
            snaks.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, SnacksActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);

                }
            });

            personalcare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this,personalActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });


            bevrages.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intent = new Intent(HomeActivity.this, bevragesActivity.class);
                    Intent.putExtra("shopid",shopid);
                    startActivity(Intent);
                }
            });



        }




        firebaseFirestore = FirebaseFirestore.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        firebaseFirestore.setFirestoreSettings(settings);
        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        String name = task.getResult().getString("name");
                        String phonenumber = task.getResult().getString("Phonenumber");
                        String address = task.getResult().getString("address");
                        String pincode = task.getResult().getString("pincode");
                        addressdisplay.setText(address);

                    }

                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(HomeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
        String text = sharedPreferences.getString(TEXT2, "");
        if (text.equals(""))
        {
            TapTargetView.showFor(this,
                    TapTarget.forView(findViewById(R.id.imageView9), "Your cart", "Items are stored in cart for checking out ")
                            .outerCircleColor(R.color.purple_200)
                            .outerCircleAlpha(0.96f)
                            .targetCircleColor(R.color.white)
                            .titleTextSize(30)
                            .titleTextColor(R.color.white)
                            .descriptionTextSize(18)
                            .descriptionTextColor(R.color.colorPrimary)
                            .textColor(R.color.white)
                            .dimColor(R.color.black)
                            .drawShadow(true)
                            .cancelable(true)
                            .tintTarget(false)
                            .transparentTarget(false)
                            .targetRadius(60),
                    new TapTargetView.Listener() {
                        @Override
                        public void onTargetClick(TapTargetView view) {
                            super.onTargetClick(view);
                            view.dismiss(true);
                            displaymenutraget();
                        }
                    });
        }

    }

    private void displaymenutraget() {
        TapTargetView.showFor(this,
                TapTarget.forView(findViewById(R.id.imageView6), "Profile tab", "Edit or update your details").outerCircleColor(R.color.purple_200)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(30)
                        .titleTextColor(R.color.white)
                        .descriptionTextSize(18)
                        .descriptionTextColor(R.color.colorPrimary)
                        .textColor(R.color.white)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(true)
                        .tintTarget(false)
                        .transparentTarget(false)
                        .targetRadius(60),
                new TapTargetView.Listener() {
                    @Override
                    public void onTargetClick(TapTargetView view) {
                        super.onTargetClick(view);
                        view.dismiss(true);
                        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString(TEXT2, "sexy");
                        editor.apply();
                    }
                });

    }


    @Override
    protected void onStart()
    {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser == null)
        {
            Intent mainIntent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
        else
        {
            String current_user_id = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
            firebaseFirestore.collection("Users").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        if(!Objects.requireNonNull(task.getResult()).exists()){
                            Intent setupIntent = new Intent(HomeActivity.this, ProfileActivity.class);
                            startActivity(setupIntent);
                            finish();
                        }
                    } else {
                        String errorMessage = Objects.requireNonNull(task.getException()).getMessage();
                        Toast.makeText(HomeActivity.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void setOrientation(HomeActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
    
}

