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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.shivtechs.maplocationpicker.LocationPickerActivity;
import com.shivtechs.maplocationpicker.MapUtility;
import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends AppCompatActivity {

    EditText name,phonenumber;
    TextView address;
    ImageView locationpicker;
    Button next;
    String user_id;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String  postalcode=null;
    ImageView home;
    private static final int ADDRESS_PICKER_REQUEST = 1020;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        home = findViewById(R.id.imageView);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ProfileActivity.this, ShopSelectActivity.class);
                startActivity(mainIntent);
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore = FirebaseFirestore.getInstance();
        name = findViewById(R.id.mailid);
        phonenumber = findViewById(R.id.password);
        address = findViewById(R.id.textView26);
        locationpicker = findViewById(R.id.imageView3);
        next = findViewById(R.id.button);
        MapUtility.apiKey = getResources().getString(R.string.your_api_key);
        locationpicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, LocationPickerActivity.class);
                startActivityForResult(i, ADDRESS_PICKER_REQUEST);
            }
        });

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build();
        firebaseFirestore.setFirestoreSettings(settings);
        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        String namex = task.getResult().getString("name");
                        String phonenumberx = task.getResult().getString("Phonenumber");
                        String addressx = task.getResult().getString("address");
                        String pincodex = task.getResult().getString("pincode");
                        name.setText(namex);
                        phonenumber.setText(phonenumberx);
                        address.setText(addressx);
                        pincodex = postalcode;
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent mainIntent = new Intent(ProfileActivity.this, ShopSelectActivity.class);
                                startActivity(mainIntent);
                            }
                        });
                    } else {
                        next.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String user_name = name.getText().toString();
                                String Phone_number = phonenumber.getText().toString();
                                String Address_user = address.getText().toString();
                                String pin_code = postalcode;
                                if (user_name != null && Phone_number != null && Address_user != null && pin_code != null && !user_name.equals("") && !Phone_number.equals("")) {
                                    Map<String, String> userMap = new HashMap<>();
                                    userMap.put("name", user_name);
                                    userMap.put("Phonenumber", Phone_number);
                                    userMap.put("address", Address_user);
                                    userMap.put("pincode", pin_code);
                                    firebaseFirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Intent mainIntent = new Intent(ProfileActivity.this, ShopSelectActivity.class);
                                            startActivity(mainIntent);
                                            finish();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                } else {
                                    YoYo.with(Techniques.Shake)
                                            .duration(650)
                                            .repeat(2)
                                            .playOn(findViewById(R.id.mailid));
                                    YoYo.with(Techniques.Shake)
                                            .duration(650)
                                            .repeat(2)
                                            .playOn(findViewById(R.id.password));
                                    YoYo.with(Techniques.Shake)
                                            .duration(650)
                                            .repeat(2)
                                            .playOn(findViewById(R.id.imageView3));
                                    YoYo.with(Techniques.Shake)
                                            .duration(650)
                                            .repeat(2)
                                            .playOn(findViewById(R.id.textView26));
                                    Toast.makeText(ProfileActivity.this, "Add profile , username, Location to avoid error", Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                next.setVisibility(View.INVISIBLE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADDRESS_PICKER_REQUEST) {
            try {
                if (data != null && data.getStringExtra(MapUtility.ADDRESS) != null) {
                    // String address = data.getStringExtra(MapUtility.ADDRESS);
                    double currentLatitude = data.getDoubleExtra(MapUtility.LATITUDE, 0.0);
                    double currentLongitude = data.getDoubleExtra(MapUtility.LONGITUDE, 0.0);
                    Bundle completeAddress = data.getBundleExtra("fullAddress");

                    address.setText(new StringBuilder().append("address: ").append
                            (completeAddress.getString("addressline2")).append("\ncity: ").append
                            (completeAddress.getString("city")).append("\npostalcode: ").append
                            (completeAddress.getString("postalcode")).append("\nstate: ").append
                            (completeAddress.getString("state")).toString());

                    postalcode = completeAddress.getString("postalcode");
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String user_name = name.getText().toString();
                            String Phone_number = phonenumber.getText().toString();
                            String Address_user = address.getText().toString();
                            String pin_code = postalcode;

                            if (user_name != null && Phone_number != null && Address_user != null && pin_code != null) {
                                Map<String, String> userMap = new HashMap<>();
                                userMap.put("name", user_name);
                                userMap.put("Phonenumber", Phone_number);
                                userMap.put("address", Address_user);
                                userMap.put("pincode", pin_code);
                                firebaseFirestore.collection("Users").document(user_id).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Intent mainIntent = new Intent(ProfileActivity.this, ShopSelectActivity.class);
                                        startActivity(mainIntent);
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(ProfileActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private void setOrientation(ProfileActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O) {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}