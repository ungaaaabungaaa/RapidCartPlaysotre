package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import android.Manifest;
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
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ShopSelectActivity extends AppCompatActivity {

    public FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    String user_id;
    TextView addressdisplay;
    ImageView menu;
    private ShopSelectAdapter notificationsAdapter;
    private List<Shoppickmodel> NotifList;
    TextView noshop;
    public static final String SHARED_PREFS2 = "sharedPref2";
    public static final String TEXT2 = "text2";
    public static final String SWITCH1 = "switch2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_select);
        setOrientation(ShopSelectActivity.this);
        loadData();
        noshop=findViewById(R.id.textView3);
        addressdisplay=findViewById(R.id.textView7);
        addressdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ShopSelectActivity.this,ProfileActivity.class);
                startActivity(mainIntent);
            }
        });
        menu=findViewById(R.id.imageView9);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ShopSelectActivity.this,OdersAcitivity.class);
                startActivity(mainIntent);
            }
        });


        mAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
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
                        loadrecycler(pincode);
                        checkloadrecycler(pincode);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShopSelectActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(ShopSelectActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }

        };

        TedPermission.with(this).setPermissionListener(permissionlistener).setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE).check();

    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
        String text = sharedPreferences.getString(TEXT2, "");
        if (text.equals(""))
        {
            TapTargetView.showFor(this,
                    TapTarget.forView(findViewById(R.id.imageView9), "Check Your Orders here", "Thank You For Installing Rapid Cart")
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
                            SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS2, MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(TEXT2, "hey");
                            editor.apply();
                        }
                    });
        }
    }


    private void checkloadrecycler(String pincode) {
        RecyclerView notificationList = findViewById(R.id.shopselectrecycler);
        firebaseFirestore.collection(pincode).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (!documentSnapshots.isEmpty()) {
                    int count = documentSnapshots.size();
                    notificationList.setVisibility(View.VISIBLE);
                } else if (documentSnapshots.isEmpty())
                {
                    noshop.setVisibility(View.VISIBLE);
                    notificationList.setVisibility(View.INVISIBLE);
                    Map<String, Object> userMap = new HashMap<>();
                    userMap.put("pincode",pincode);
                    firebaseFirestore.collection("Shopneedinthislocation").add(userMap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(ShopSelectActivity.this, " Requesting Shop at Your Location Completed", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    private void loadrecycler(String pincode) {
        NotifList = new ArrayList<>();
        RecyclerView notificationList = findViewById(R.id.shopselectrecycler);
        notificationsAdapter = new ShopSelectAdapter(NotifList);
        notificationList.setHasFixedSize(true);
        notificationList.setItemViewCacheSize(20);
        notificationList.setDrawingCacheEnabled(true);
        notificationList.setItemAnimator(null);
        notificationList.setNestedScrollingEnabled(false);
        notificationList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        notificationList.setAdapter(notificationsAdapter);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection(pincode).addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                    Shoppickmodel notifications = doc.getDocument().toObject(Shoppickmodel.class);
                    NotifList.add(notifications);
                    notificationsAdapter.notifyDataSetChanged();
                }
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
            Intent mainIntent = new Intent(ShopSelectActivity.this, MainActivity.class);
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
                            Intent setupIntent = new Intent(ShopSelectActivity.this, ProfileActivity.class);
                            startActivity(setupIntent);
                            finish();
                        }
                    } else {
                        String errorMessage = Objects.requireNonNull(task.getException()).getMessage();
                        Toast.makeText(ShopSelectActivity.this, "Error : " + errorMessage, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }


    private void setOrientation(ShopSelectActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}