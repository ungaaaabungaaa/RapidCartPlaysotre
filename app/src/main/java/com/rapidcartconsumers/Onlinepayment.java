package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.carteasy.v1.lib.Carteasy;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Onlinepayment extends AppCompatActivity implements PaymentResultWithDataListener {


    Button button;
    private static final String TAG = MainActivity.class.getSimpleName();
    TextView totalprice;
    Button placeorderbutton;
    String user_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    String namex;
    String phonenumberx;
    String addressx;
    String pincodex;
    TextView total;
    String p1 = "e400";
    String p2 = "e401";
    String p3 = "e402";
    String p4 = "e403";
    String p5 = "e404";
    String p6 = "e405";
    String p7 = "e406";
    String p8 = "e407";
    String p9 = "e408";
    String p10 = "e409";
    String p11 = "e410";
    String p12 = "e411";
    String p13 = "e412";
    String p14 = "e413";
    String p15 = "e414";
    String p16 = "e415";
    String p17 = "e416";
    String p18 = "e417";
    String p19 = "e418";
    String p20 = "e419";
    String p21 = "e420";
    String p22 = "e421";
    String p23 = "e422";
    String p24 = "e423";
    String p25 = "e424";
    String p26 = "e425";
    String p27 = "e426";
    String p28 = "e427";
    String p29 = "e428";
    String p30 = "e429";
    String p31 = "e430";
    String p32 = "e431";
    String p33 = "e432";
    String p34 = "e433";
    String p35 = "e434";
    int result1;
    int result2;
    int result3;
    int result4;
    int result5;
    int result6;
    int result7;
    int result8;
    int result9;
    int result10;
    int result11;
    int result12;
    int result13;
    int result14;
    int result15;
    int result16;
    int result17;
    int result18;
    int result19;
    int result20;
    int result21;
    int result22;
    int result23;
    int result24;
    int result25;
    int result26;
    int result27;
    int result28;
    int result29;
    int result30;
    int result31;
    int result32;
    int result33;
    int result34;
    int result35;
    TextView totaltextview;
    TextView summaryprice;
    TextView ordertype;
    String deliverytype;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinepayment);
        setOrientation(Onlinepayment.this);
        progressBar=findViewById(R.id.progressBar2);
        summaryprice = findViewById(R.id.textView41);
        totaltextview = findViewById(R.id.textView42);
        placeorderbutton = findViewById(R.id.button2);
        mAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        Carteasy cs = new Carteasy();
        user_id = firebaseAuth.getCurrentUser().getUid();
        ordertype = findViewById(R.id.textView43);

        Bundle bundle2 = getIntent().getExtras();
        if (bundle2 != null) {
            String shopid = bundle2.get("shopid").toString();
            if (shopid.equals("Shoppick")) {
                ordertype.setText("Shoppick");
                deliverytype = "Shoppick";
            } else if (shopid.equals("Homedelivery")) {
                ordertype.setText("HomeDelivery");
                deliverytype = "HomeDelivery";
            }
        }





        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        namex = task.getResult().getString("name");
                        phonenumberx = task.getResult().getString("Phonenumber");
                        addressx = task.getResult().getString("address");
                        pincodex = task.getResult().getString("pincode");



                        // loading all data from cart
                        String itemname1 = cs.getString(p1, "itemname1", getApplicationContext());
                        String price1 = cs.getString(p1, "price1", getApplicationContext());
                        String storeid1 = cs.getString(p1, "storeid1", getApplicationContext());
                        String itemurl1 = cs.getString(p1, "itemurl1", getApplicationContext());

                        if (!price1.equals("")) {
                            result1 = Integer.parseInt(price1);

                        }
                        String itemname2 = cs.getString(p2, "itemname2", getApplicationContext());
                        String price2 = cs.getString(p2, "price2", getApplicationContext());
                        String storeid2 = cs.getString(p2, "storeid2", getApplicationContext());
                        String itemurl2 = cs.getString(p2, "itemurl2", getApplicationContext());

                        if (!price2.equals("")) {
                            result2 = Integer.parseInt(price2);

                        }


                        String itemname3 = cs.getString(p3, "itemname3", getApplicationContext());
                        String price3 = cs.getString(p3, "price3", getApplicationContext());
                        String storeid3 = cs.getString(p3, "storeid3", getApplicationContext());
                        String itemurl3 = cs.getString(p3, "itemurl3", getApplicationContext());

                        if (!price3.equals("")) {
                            result3 = Integer.parseInt(price3);

                        }

                        String itemname4 = cs.getString(p4, "itemname4", getApplicationContext());
                        String price4 = cs.getString(p4, "price4", getApplicationContext());
                        String storeid4 = cs.getString(p4, "storeid4", getApplicationContext());
                        String itemurl4 = cs.getString(p4, "itemurl4", getApplicationContext());

                        if (!price4.equals("")) {
                            result4 = Integer.parseInt(price4);

                        }


                        String itemname5 = cs.getString(p5, "itemname5", getApplicationContext());
                        String price5 = cs.getString(p5, "price5", getApplicationContext());
                        String storeid5 = cs.getString(p5, "storeid5", getApplicationContext());
                        String itemurl5 = cs.getString(p5, "itemurl5", getApplicationContext());

                        if (!price5.equals("")) {
                            result5 = Integer.parseInt(price5);
                        }


                        String itemname6 = cs.getString(p6, "itemname6", getApplicationContext());
                        String price6 = cs.getString(p6, "price6", getApplicationContext());
                        String storeid6 = cs.getString(p6, "storeid6", getApplicationContext());
                        String itemurl6 = cs.getString(p6, "itemurl6", getApplicationContext());

                        if (!price6.equals("")) {
                            result6 = Integer.parseInt(price6);

                        }


                        String itemname7 = cs.getString(p7, "itemname7", getApplicationContext());
                        String price7 = cs.getString(p7, "price7", getApplicationContext());
                        String storeid7 = cs.getString(p7, "storeid7", getApplicationContext());
                        String itemurl7 = cs.getString(p7, "itemurl7", getApplicationContext());

                        if (!price7.equals("")) {
                            result7 = Integer.parseInt(price7);
                        }


                        String itemname8 = cs.getString(p8, "itemname8", getApplicationContext());
                        String price8 = cs.getString(p8, "price8", getApplicationContext());
                        String storeid8 = cs.getString(p8, "storeid8", getApplicationContext());
                        String itemurl8 = cs.getString(p8, "itemurl8", getApplicationContext());

                        if (!price8.equals("")) {
                            result8 = Integer.parseInt(price8);

                        }


                        String itemname9 = cs.getString(p9, "itemname9", getApplicationContext());
                        String price9 = cs.getString(p9, "price9", getApplicationContext());
                        String storeid9 = cs.getString(p9, "storeid9", getApplicationContext());
                        String itemurl9 = cs.getString(p9, "itemurl9", getApplicationContext());

                        if (!price9.equals("")) {
                            result9 = Integer.parseInt(price9);

                        }


                        String itemname10 = cs.getString(p10, "itemname10", getApplicationContext());
                        String price10 = cs.getString(p10, "price10", getApplicationContext());
                        String storeid10 = cs.getString(p10, "storeid10", getApplicationContext());
                        String itemurl10 = cs.getString(p10, "itemurl10", getApplicationContext());

                        if (!price10.equals("")) {
                            result10 = Integer.parseInt(price10);

                        }


                        String itemname11 = cs.getString(p11, "itemname11", getApplicationContext());
                        String price11 = cs.getString(p11, "price11", getApplicationContext());
                        String storeid11 = cs.getString(p11, "storeid11", getApplicationContext());
                        String itemurl11 = cs.getString(p11, "itemurl11", getApplicationContext());

                        if (!price11.equals("")) {
                            result11 = Integer.parseInt(price11);

                        }

                        String itemname12 = cs.getString(p12, "itemname12", getApplicationContext());
                        String price12 = cs.getString(p12, "price12", getApplicationContext());
                        String storeid12 = cs.getString(p12, "storeid12", getApplicationContext());
                        String itemurl12 = cs.getString(p12, "itemurl12", getApplicationContext());

                        if (!price12.equals("")) {
                            result12 = Integer.parseInt(price12);

                        }


                        String itemname13 = cs.getString(p13, "itemname13", getApplicationContext());
                        String price13 = cs.getString(p13, "price13", getApplicationContext());
                        String storeid13 = cs.getString(p13, "storeid13", getApplicationContext());
                        String itemurl13 = cs.getString(p13, "itemurl13", getApplicationContext());

                        if (!price13.equals("")) {
                            result13 = Integer.parseInt(price13);

                        }

                        String itemname14 = cs.getString(p14, "itemname14", getApplicationContext());
                        String price14 = cs.getString(p14, "price14", getApplicationContext());
                        String storeid14 = cs.getString(p14, "storeid14", getApplicationContext());
                        String itemurl14 = cs.getString(p14, "itemurl14", getApplicationContext());

                        if (!price14.equals("")) {
                            result14 = Integer.parseInt(price14);

                        }


                        String itemname15 = cs.getString(p15, "itemname15", getApplicationContext());
                        String price15 = cs.getString(p15, "price15", getApplicationContext());
                        String storeid15 = cs.getString(p15, "storeid15", getApplicationContext());
                        String itemurl15 = cs.getString(p15, "itemurl15", getApplicationContext());

                        if (!price15.equals("")) {
                            result15 = Integer.parseInt(price15);

                        }


                        String itemname16 = cs.getString(p16, "itemname16", getApplicationContext());
                        String price16 = cs.getString(p16, "price16", getApplicationContext());
                        String storeid16 = cs.getString(p16, "storeid16", getApplicationContext());
                        String itemurl16 = cs.getString(p16, "itemurl16", getApplicationContext());

                        if (!price16.equals("")) {
                            result16 = Integer.parseInt(price16);

                        }


                        String itemname17 = cs.getString(p17, "itemname17", getApplicationContext());
                        String price17 = cs.getString(p17, "price17", getApplicationContext());
                        String storeid17 = cs.getString(p17, "storeid17", getApplicationContext());
                        String itemurl17 = cs.getString(p17, "itemur17", getApplicationContext());

                        if (!price17.equals("")) {
                            result17 = Integer.parseInt(price17);

                        }


                        String itemname18 = cs.getString(p18, "itemname18", getApplicationContext());
                        String price18 = cs.getString(p18, "price18", getApplicationContext());
                        String storeid18 = cs.getString(p18, "storeid18", getApplicationContext());
                        String itemurl18 = cs.getString(p18, "itemurl18", getApplicationContext());

                        if (!price18.equals("")) {
                            result18 = Integer.parseInt(price18);

                        }


                        String itemname19 = cs.getString(p19, "itemname19", getApplicationContext());
                        String price19 = cs.getString(p19, "price19", getApplicationContext());
                        String storeid19 = cs.getString(p19, "storeid19", getApplicationContext());
                        String itemurl19 = cs.getString(p19, "itemurl19", getApplicationContext());

                        if (!price19.equals("")) {
                            result19 = Integer.parseInt(price19);

                        }


                        String itemname20 = cs.getString(p20, "itemname20", getApplicationContext());
                        String price20 = cs.getString(p20, "price20", getApplicationContext());
                        String storeid20 = cs.getString(p20, "storeid20", getApplicationContext());
                        String itemurl20 = cs.getString(p20, "itemurl20", getApplicationContext());

                        if (!price20.equals("")) {
                            result20 = Integer.parseInt(price20);

                        }


                        String itemname21 = cs.getString(p21, "itemname21", getApplicationContext());
                        String price21 = cs.getString(p21, "price21", getApplicationContext());
                        String storeid21 = cs.getString(p21, "storeid21", getApplicationContext());
                        String itemurl21 = cs.getString(p21, "itemurl21", getApplicationContext());

                        if (!price21.equals("")) {
                            result21 = Integer.parseInt(price21);

                        }
                        String itemname22 = cs.getString(p22, "itemname22", getApplicationContext());
                        String price22 = cs.getString(p22, "price22", getApplicationContext());
                        String storeid22 = cs.getString(p22, "storeid22", getApplicationContext());
                        String itemurl22 = cs.getString(p22, "itemurl22", getApplicationContext());

                        if (!price22.equals("")) {
                            result22 = Integer.parseInt(price22);

                        }


                        String itemname23 = cs.getString(p23, "itemname23", getApplicationContext());
                        String price23 = cs.getString(p23, "price23", getApplicationContext());
                        String storeid23 = cs.getString(p23, "storeid23", getApplicationContext());
                        String itemurl23 = cs.getString(p23, "itemurl23", getApplicationContext());

                        if (!price23.equals("")) {
                            result23 = Integer.parseInt(price23);

                        }

                        String itemname24 = cs.getString(p24, "itemname24", getApplicationContext());
                        String price24 = cs.getString(p24, "price24", getApplicationContext());
                        String storeid24 = cs.getString(p24, "storeid24", getApplicationContext());
                        String itemurl24 = cs.getString(p24, "itemurl24", getApplicationContext());

                        if (!price24.equals("")) {
                            result24 = Integer.parseInt(price24);

                        }


                        String itemname25 = cs.getString(p25, "itemname25", getApplicationContext());
                        String price25 = cs.getString(p25, "price25", getApplicationContext());
                        String storeid25 = cs.getString(p25, "storeid25", getApplicationContext());
                        String itemurl25 = cs.getString(p25, "itemurl25", getApplicationContext());

                        if (!price25.equals("")) {
                            result25 = Integer.parseInt(price25);

                        }


                        String itemname26 = cs.getString(p26, "itemname26", getApplicationContext());
                        String price26 = cs.getString(p26, "price26", getApplicationContext());
                        String storeid26 = cs.getString(p26, "storeid6", getApplicationContext());
                        String itemurl26 = cs.getString(p6, "itemurl6", getApplicationContext());

                        if (!price26.equals("")) {
                            result26 = Integer.parseInt(price26);

                        }


                        String itemname27 = cs.getString(p27, "itemname27", getApplicationContext());
                        String price27 = cs.getString(p27, "price27", getApplicationContext());
                        String storeid27 = cs.getString(p27, "storeid27", getApplicationContext());
                        String itemurl27 = cs.getString(p27, "itemurl27", getApplicationContext());

                        if (!price27.equals("")) {
                            result27 = Integer.parseInt(price27);

                        }


                        String itemname28 = cs.getString(p28, "itemname28", getApplicationContext());
                        String price28 = cs.getString(p28, "price28", getApplicationContext());
                        String storeid28 = cs.getString(p28, "storeid28", getApplicationContext());
                        String itemurl28 = cs.getString(p28, "itemurl28", getApplicationContext());

                        if (!price28.equals("")) {
                            result28 = Integer.parseInt(price28);

                        }


                        String itemname29 = cs.getString(p29, "itemname29", getApplicationContext());
                        String price29 = cs.getString(p29, "price29", getApplicationContext());
                        String storeid29 = cs.getString(p29, "storeid29", getApplicationContext());
                        String itemurl29 = cs.getString(p29, "itemurl29", getApplicationContext());

                        if (!price29.equals("")) {
                            result29 = Integer.parseInt(price29);

                        }


                        String itemname30 = cs.getString(p30, "itemname30", getApplicationContext());
                        String price30 = cs.getString(p30, "price30", getApplicationContext());
                        String storeid30 = cs.getString(p30, "storeid30", getApplicationContext());
                        String itemurl30 = cs.getString(p30, "itemurl30", getApplicationContext());

                        if (!price30.equals("")) {
                            result30 = Integer.parseInt(price30);

                        }


                        String itemname31 = cs.getString(p31, "itemname31", getApplicationContext());
                        String price31 = cs.getString(p31, "price31", getApplicationContext());
                        String storeid31 = cs.getString(p31, "storeid31", getApplicationContext());
                        String itemurl31 = cs.getString(p31, "itemurl31", getApplicationContext());

                        if (!price31.equals("")) {
                            result31 = Integer.parseInt(price31);


                        }
                        String itemname32 = cs.getString(p32, "itemname32", getApplicationContext());
                        String price32 = cs.getString(p32, "price32", getApplicationContext());
                        String storeid32 = cs.getString(p32, "storeid32", getApplicationContext());
                        String itemurl32 = cs.getString(p32, "itemurl32", getApplicationContext());

                        if (!price32.equals("")) {
                            result32 = Integer.parseInt(price32);

                        }


                        String itemname33 = cs.getString(p33, "itemname33", getApplicationContext());
                        String price33 = cs.getString(p33, "price33", getApplicationContext());
                        String storeid33 = cs.getString(p33, "storeid33", getApplicationContext());
                        String itemurl33 = cs.getString(p33, "itemurl33", getApplicationContext());

                        if (!price33.equals("")) {
                            result33 = Integer.parseInt(price33);

                        }

                        String itemname34 = cs.getString(p34, "itemname34", getApplicationContext());
                        String price34 = cs.getString(p34, "price34", getApplicationContext());
                        String storeid34 = cs.getString(p34, "storeid34", getApplicationContext());
                        String itemurl34 = cs.getString(p34, "itemurl34", getApplicationContext());

                        if (!price34.equals("")) {
                            result34 = Integer.parseInt(price34);

                        }

                        String itemname35 = cs.getString(p35, "itemname35", getApplicationContext());
                        String price35 = cs.getString(p35, "price35", getApplicationContext());
                        String storeid35 = cs.getString(p35, "storeid35", getApplicationContext());
                        String itemurl35 = cs.getString(p35, "itemurl35", getApplicationContext());

                        if (!price35.equals("")) {
                            result35 = Integer.parseInt(price35);
                        }
                        int totalprice = result1 + result2 + result3 + result4 + result5 + result6 + result7 + result8 + result9 + result10 +
                                result11 + result12 + result13 + result14 + result15 + result16 + result17 + result18 + result19 + result20 +
                                result21 + result22 + result23 + result24 + result25 + result26 + result27 + result28 + result29 + result30 +
                                result31 + result32 + result33 + result34 + result35;
                        String totalx = String.valueOf(totalprice);
                        totaltextview.setText(totalx);
                        firebaseFirestore.collection("Owner").document(storeid1).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                if (task.isSuccessful()) {
                                    if (task.getResult().exists()) {
                                        String shopphonenumber = task.getResult().getString("shopphonenumber");
                                        String minimumorderx = task.getResult().getString("minimumorder");
                                        String Email=task.getResult().getString("email");
                                        String shopname = task.getResult().getString("shopname");
                                        String merchantid=task.getResult().getString("merchantid");
                                        String merchantnamex=task.getResult().getString("merchantname");
                                        button=findViewById(R.id.appCompatButton);
                                        button.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                int miniorderprise=Integer.parseInt(minimumorderx);
                                                int amount=Integer.parseInt(totalx);
                                                if (amount>miniorderprise)
                                                {
                                                    startPayment(shopphonenumber,minimumorderx,Email,shopname,totalx,merchantid,merchantnamex);
                                                }
                                                else
                                                {
                                                    YoYo.with(Techniques.Shake)
                                                            .duration(650)
                                                            .repeat(2)
                                                            .playOn(findViewById(R.id.appCompatButton));
                                                    Toast.makeText(Onlinepayment.this, "Minimum Amount is "+minimumorderx, Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        });
                    }
                }
            }
        });
    }

    private void startPayment(String shopphonenumber, String minimumorderx, String email, String shopname, String totalx, String merchantid, String merchantnamex) {
        int amount=Math.round(Float.parseFloat(totalx)*100);
        Checkout checkout = new Checkout();
        Checkout.preload(getApplicationContext());
        checkout.setKeyID("rzp_test_2Pj5Bi3m6FOVZH");
        checkout.setImage(R.drawable.rapid_cart_logo);
        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();
            options.put("name",merchantnamex);
            options.put("key",merchantid);
            options.put("description", "Thank You For shoping");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            options.put("theme.color", "#5DC049");
            options.put("currency", "INR");
            options.put("amount", amount);
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);
            checkout.open(activity, options);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {
        progressBar.setVisibility(View.VISIBLE);
        Carteasy cs = new Carteasy();
        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        namex = task.getResult().getString("name");
                        phonenumberx = task.getResult().getString("Phonenumber");
                        addressx = task.getResult().getString("address");
                        pincodex = task.getResult().getString("pincode");


                        String itemname1 = cs.getString(p1, "itemname1", getApplicationContext());
                        String price1 = cs.getString(p1, "price1", getApplicationContext());
                        String storeid1 = cs.getString(p1, "storeid1", getApplicationContext());
                        String itemurl1 = cs.getString(p1, "itemurl1", getApplicationContext());

                        if (!price1.equals(""))
                        {
                            result1 = Integer.parseInt(price1);
                        }


                        String itemname2 = cs.getString(p2, "itemname2", getApplicationContext());
                        String price2 = cs.getString(p2, "price2", getApplicationContext());
                        String storeid2 = cs.getString(p2, "storeid2", getApplicationContext());
                        String itemurl2 = cs.getString(p2, "itemurl2", getApplicationContext());

                        if (!price2.equals(""))
                        {
                            result2 = Integer.parseInt(price2);
                        }

                        String itemname3 = cs.getString(p3, "itemname3", getApplicationContext());
                        String price3 = cs.getString(p3, "price3", getApplicationContext());
                        String storeid3 = cs.getString(p3, "storeid3", getApplicationContext());
                        String itemurl3 = cs.getString(p3, "itemurl3", getApplicationContext());

                        if (!price3.equals("")) {
                            result3 = Integer.parseInt(price3);

                        }

                        String itemname4 = cs.getString(p4, "itemname4", getApplicationContext());
                        String price4 = cs.getString(p4, "price4", getApplicationContext());
                        String storeid4 = cs.getString(p4, "storeid4", getApplicationContext());
                        String itemurl4 = cs.getString(p4, "itemurl4", getApplicationContext());

                        if (!price4.equals("")) {
                            result4 = Integer.parseInt(price4);

                        }


                        String itemname5 = cs.getString(p5, "itemname5", getApplicationContext());
                        String price5 = cs.getString(p5, "price5", getApplicationContext());
                        String storeid5 = cs.getString(p5, "storeid5", getApplicationContext());
                        String itemurl5 = cs.getString(p5, "itemurl5", getApplicationContext());

                        if (!price5.equals("")) {
                            result5 = Integer.parseInt(price5);
                        }


                        String itemname6 = cs.getString(p6, "itemname6", getApplicationContext());
                        String price6 = cs.getString(p6, "price6", getApplicationContext());
                        String storeid6 = cs.getString(p6, "storeid6", getApplicationContext());
                        String itemurl6 = cs.getString(p6, "itemurl6", getApplicationContext());

                        if (!price6.equals("")) {
                            result6 = Integer.parseInt(price6);

                        }


                        String itemname7 = cs.getString(p7, "itemname7", getApplicationContext());
                        String price7 = cs.getString(p7, "price7", getApplicationContext());
                        String storeid7 = cs.getString(p7, "storeid7", getApplicationContext());
                        String itemurl7 = cs.getString(p7, "itemurl7", getApplicationContext());

                        if (!price7.equals("")) {
                            result7 = Integer.parseInt(price7);
                        }


                        String itemname8 = cs.getString(p8, "itemname8", getApplicationContext());
                        String price8 = cs.getString(p8, "price8", getApplicationContext());
                        String storeid8 = cs.getString(p8, "storeid8", getApplicationContext());
                        String itemurl8 = cs.getString(p8, "itemurl8", getApplicationContext());

                        if (!price8.equals("")) {
                            result8 = Integer.parseInt(price8);

                        }


                        String itemname9 = cs.getString(p9, "itemname9", getApplicationContext());
                        String price9 = cs.getString(p9, "price9", getApplicationContext());
                        String storeid9 = cs.getString(p9, "storeid9", getApplicationContext());
                        String itemurl9 = cs.getString(p9, "itemurl9", getApplicationContext());

                        if (!price9.equals("")) {
                            result9 = Integer.parseInt(price9);

                        }


                        String itemname10 = cs.getString(p10, "itemname10", getApplicationContext());
                        String price10 = cs.getString(p10, "price10", getApplicationContext());
                        String storeid10 = cs.getString(p10, "storeid10", getApplicationContext());
                        String itemurl10 = cs.getString(p10, "itemurl10", getApplicationContext());

                        if (!price10.equals("")) {
                            result10 = Integer.parseInt(price10);

                        }


                        String itemname11 = cs.getString(p11, "itemname11", getApplicationContext());
                        String price11 = cs.getString(p11, "price11", getApplicationContext());
                        String storeid11 = cs.getString(p11, "storeid11", getApplicationContext());
                        String itemurl11 = cs.getString(p11, "itemurl11", getApplicationContext());

                        if (!price11.equals("")) {
                            result11 = Integer.parseInt(price11);

                        }

                        String itemname12 = cs.getString(p12, "itemname12", getApplicationContext());
                        String price12 = cs.getString(p12, "price12", getApplicationContext());
                        String storeid12 = cs.getString(p12, "storeid12", getApplicationContext());
                        String itemurl12 = cs.getString(p12, "itemurl12", getApplicationContext());

                        if (!price12.equals("")) {
                            result12 = Integer.parseInt(price12);

                        }


                        String itemname13 = cs.getString(p13, "itemname13", getApplicationContext());
                        String price13 = cs.getString(p13, "price13", getApplicationContext());
                        String storeid13 = cs.getString(p13, "storeid13", getApplicationContext());
                        String itemurl13 = cs.getString(p13, "itemurl13", getApplicationContext());

                        if (!price13.equals("")) {
                            result13 = Integer.parseInt(price13);

                        }

                        String itemname14 = cs.getString(p14, "itemname14", getApplicationContext());
                        String price14 = cs.getString(p14, "price14", getApplicationContext());
                        String storeid14 = cs.getString(p14, "storeid14", getApplicationContext());
                        String itemurl14 = cs.getString(p14, "itemurl14", getApplicationContext());

                        if (!price14.equals("")) {
                            result14 = Integer.parseInt(price14);

                        }


                        String itemname15 = cs.getString(p15, "itemname15", getApplicationContext());
                        String price15 = cs.getString(p15, "price15", getApplicationContext());
                        String storeid15 = cs.getString(p15, "storeid15", getApplicationContext());
                        String itemurl15 = cs.getString(p15, "itemurl15", getApplicationContext());

                        if (!price15.equals("")) {
                            result15 = Integer.parseInt(price15);

                        }


                        String itemname16 = cs.getString(p16, "itemname16", getApplicationContext());
                        String price16 = cs.getString(p16, "price16", getApplicationContext());
                        String storeid16 = cs.getString(p16, "storeid16", getApplicationContext());
                        String itemurl16 = cs.getString(p16, "itemurl16", getApplicationContext());

                        if (!price16.equals("")) {
                            result16 = Integer.parseInt(price16);

                        }


                        String itemname17 = cs.getString(p17, "itemname17", getApplicationContext());
                        String price17 = cs.getString(p17, "price17", getApplicationContext());
                        String storeid17 = cs.getString(p17, "storeid17", getApplicationContext());
                        String itemurl17 = cs.getString(p17, "itemur17", getApplicationContext());

                        if (!price17.equals("")) {
                            result17 = Integer.parseInt(price17);

                        }


                        String itemname18 = cs.getString(p18, "itemname18", getApplicationContext());
                        String price18 = cs.getString(p18, "price18", getApplicationContext());
                        String storeid18 = cs.getString(p18, "storeid18", getApplicationContext());
                        String itemurl18 = cs.getString(p18, "itemurl18", getApplicationContext());

                        if (!price18.equals("")) {
                            result18 = Integer.parseInt(price18);

                        }


                        String itemname19 = cs.getString(p19, "itemname19", getApplicationContext());
                        String price19 = cs.getString(p19, "price19", getApplicationContext());
                        String storeid19 = cs.getString(p19, "storeid19", getApplicationContext());
                        String itemurl19 = cs.getString(p19, "itemurl19", getApplicationContext());

                        if (!price19.equals("")) {
                            result19 = Integer.parseInt(price19);

                        }


                        String itemname20 = cs.getString(p20, "itemname20", getApplicationContext());
                        String price20 = cs.getString(p20, "price20", getApplicationContext());
                        String storeid20 = cs.getString(p20, "storeid20", getApplicationContext());
                        String itemurl20 = cs.getString(p20, "itemurl20", getApplicationContext());

                        if (!price20.equals("")) {
                            result20 = Integer.parseInt(price20);

                        }


                        String itemname21 = cs.getString(p21, "itemname21", getApplicationContext());
                        String price21 = cs.getString(p21, "price21", getApplicationContext());
                        String storeid21 = cs.getString(p21, "storeid21", getApplicationContext());
                        String itemurl21 = cs.getString(p21, "itemurl21", getApplicationContext());

                        if (!price21.equals("")) {
                            result21 = Integer.parseInt(price21);

                        }
                        String itemname22 = cs.getString(p22, "itemname22", getApplicationContext());
                        String price22 = cs.getString(p22, "price22", getApplicationContext());
                        String storeid22 = cs.getString(p22, "storeid22", getApplicationContext());
                        String itemurl22 = cs.getString(p22, "itemurl22", getApplicationContext());

                        if (!price22.equals("")) {
                            result22 = Integer.parseInt(price22);

                        }


                        String itemname23 = cs.getString(p23, "itemname23", getApplicationContext());
                        String price23 = cs.getString(p23, "price23", getApplicationContext());
                        String storeid23 = cs.getString(p23, "storeid23", getApplicationContext());
                        String itemurl23 = cs.getString(p23, "itemurl23", getApplicationContext());

                        if (!price23.equals("")) {
                            result23 = Integer.parseInt(price23);

                        }

                        String itemname24 = cs.getString(p24, "itemname24", getApplicationContext());
                        String price24 = cs.getString(p24, "price24", getApplicationContext());
                        String storeid24 = cs.getString(p24, "storeid24", getApplicationContext());
                        String itemurl24 = cs.getString(p24, "itemurl24", getApplicationContext());

                        if (!price24.equals("")) {
                            result24 = Integer.parseInt(price24);

                        }


                        String itemname25 = cs.getString(p25, "itemname25", getApplicationContext());
                        String price25 = cs.getString(p25, "price25", getApplicationContext());
                        String storeid25 = cs.getString(p25, "storeid25", getApplicationContext());
                        String itemurl25 = cs.getString(p25, "itemurl25", getApplicationContext());

                        if (!price25.equals("")) {
                            result25 = Integer.parseInt(price25);

                        }


                        String itemname26 = cs.getString(p26, "itemname26", getApplicationContext());
                        String price26 = cs.getString(p26, "price26", getApplicationContext());
                        String storeid26 = cs.getString(p26, "storeid6", getApplicationContext());
                        String itemurl26 = cs.getString(p6, "itemurl6", getApplicationContext());

                        if (!price26.equals("")) {
                            result26 = Integer.parseInt(price26);

                        }


                        String itemname27 = cs.getString(p27, "itemname27", getApplicationContext());
                        String price27 = cs.getString(p27, "price27", getApplicationContext());
                        String storeid27 = cs.getString(p27, "storeid27", getApplicationContext());
                        String itemurl27 = cs.getString(p27, "itemurl27", getApplicationContext());

                        if (!price27.equals("")) {
                            result27 = Integer.parseInt(price27);

                        }


                        String itemname28 = cs.getString(p28, "itemname28", getApplicationContext());
                        String price28 = cs.getString(p28, "price28", getApplicationContext());
                        String storeid28 = cs.getString(p28, "storeid28", getApplicationContext());
                        String itemurl28 = cs.getString(p28, "itemurl28", getApplicationContext());

                        if (!price28.equals("")) {
                            result28 = Integer.parseInt(price28);

                        }


                        String itemname29 = cs.getString(p29, "itemname29", getApplicationContext());
                        String price29 = cs.getString(p29, "price29", getApplicationContext());
                        String storeid29 = cs.getString(p29, "storeid29", getApplicationContext());
                        String itemurl29 = cs.getString(p29, "itemurl29", getApplicationContext());

                        if (!price29.equals("")) {
                            result29 = Integer.parseInt(price29);

                        }


                        String itemname30 = cs.getString(p30, "itemname30", getApplicationContext());
                        String price30 = cs.getString(p30, "price30", getApplicationContext());
                        String storeid30 = cs.getString(p30, "storeid30", getApplicationContext());
                        String itemurl30 = cs.getString(p30, "itemurl30", getApplicationContext());

                        if (!price30.equals("")) {
                            result30 = Integer.parseInt(price30);

                        }


                        String itemname31 = cs.getString(p31, "itemname31", getApplicationContext());
                        String price31 = cs.getString(p31, "price31", getApplicationContext());
                        String storeid31 = cs.getString(p31, "storeid31", getApplicationContext());
                        String itemurl31 = cs.getString(p31, "itemurl31", getApplicationContext());

                        if (!price31.equals("")) {
                            result31 = Integer.parseInt(price31);


                        }
                        String itemname32 = cs.getString(p32, "itemname32", getApplicationContext());
                        String price32 = cs.getString(p32, "price32", getApplicationContext());
                        String storeid32 = cs.getString(p32, "storeid32", getApplicationContext());
                        String itemurl32 = cs.getString(p32, "itemurl32", getApplicationContext());

                        if (!price32.equals("")) {
                            result32 = Integer.parseInt(price32);

                        }


                        String itemname33 = cs.getString(p33, "itemname33", getApplicationContext());
                        String price33 = cs.getString(p33, "price33", getApplicationContext());
                        String storeid33 = cs.getString(p33, "storeid33", getApplicationContext());
                        String itemurl33 = cs.getString(p33, "itemurl33", getApplicationContext());

                        if (!price33.equals("")) {
                            result33 = Integer.parseInt(price33);

                        }

                        String itemname34 = cs.getString(p34, "itemname34", getApplicationContext());
                        String price34 = cs.getString(p34, "price34", getApplicationContext());
                        String storeid34 = cs.getString(p34, "storeid34", getApplicationContext());
                        String itemurl34 = cs.getString(p34, "itemurl34", getApplicationContext());

                        if (!price34.equals("")) {
                            result34 = Integer.parseInt(price34);

                        }

                        String itemname35 = cs.getString(p35, "itemname35", getApplicationContext());
                        String price35 = cs.getString(p35, "price35", getApplicationContext());
                        String storeid35 = cs.getString(p35, "storeid35", getApplicationContext());
                        String itemurl35 = cs.getString(p35, "itemurl35", getApplicationContext());

                        if (!price35.equals("")) {
                            result35 = Integer.parseInt(price35);
                        }

                        // calculating price
                        int totalprice = result1 + result2 + result3 + result4 + result5 + result6 + result7 + result8 + result9 + result10 +
                                result11 + result12 + result13 + result14 + result15 + result16 + result17 + result18 + result19 + result20 +
                                result21 + result22 + result23 + result24 + result25 + result26 + result27 + result28 + result29 + result30 +
                                result31 + result32 + result33 + result34 + result35;
                        String string = String.valueOf(totalprice);
                        String totalx = String.valueOf(totalprice);
                        totaltextview.setText(totalx);
                        String cod = "Online Pay";
                        if (pincodex != null && phonenumberx != null && namex != null && addressx != null) {
                            Random r = new Random();
                            int randomNumber = r.nextInt(10000000);
                            String randonString=String.valueOf(randomNumber);
                            Map<String, Object> userMap = new HashMap<>();
                            userMap.put("name", namex);
                            userMap.put("Phonenumber", phonenumberx);
                            userMap.put("address", addressx);
                            userMap.put("p1name", itemname1);
                            userMap.put("p1price", price1);
                            userMap.put("P2name", itemname2);
                            userMap.put("p2price", price2);
                            userMap.put("p3name", itemname3);
                            userMap.put("p3price", price3);
                            userMap.put("P4name", itemname4);
                            userMap.put("p4price", price4);
                            userMap.put("p5name", itemname5);
                            userMap.put("p5price", price5);
                            userMap.put("P6name", itemname6);
                            userMap.put("p6price", price6);
                            userMap.put("p7name", itemname7);
                            userMap.put("p7price", price7);
                            userMap.put("P8name", itemname8);
                            userMap.put("p8price", price8);
                            userMap.put("p9name", itemname9);
                            userMap.put("p9price", price9);
                            userMap.put("P10name", itemname10);
                            userMap.put("p10price", price10);
                            userMap.put("p11name", itemname11);
                            userMap.put("p11price", price11);
                            userMap.put("P12name", itemname12);
                            userMap.put("p12price", price12);
                            userMap.put("p13name", itemname13);
                            userMap.put("p13price", price13);
                            userMap.put("P14name", itemname14);
                            userMap.put("p14price", price14);
                            userMap.put("p15name", itemname15);
                            userMap.put("p15price", price15);
                            userMap.put("P16name", itemname16);
                            userMap.put("p16price", price16);
                            userMap.put("p17name", itemname17);
                            userMap.put("p17price", price17);
                            userMap.put("P18name", itemname18);
                            userMap.put("p18price", price18);
                            userMap.put("p19name", itemname19);
                            userMap.put("p19price", price19);
                            userMap.put("P20name", itemname20);
                            userMap.put("p20price", price20);
                            userMap.put("p21name", itemname21);
                            userMap.put("p21price", price21);
                            userMap.put("P22name", itemname22);
                            userMap.put("p22price", price22);
                            userMap.put("p23name", itemname23);
                            userMap.put("p23price", price23);
                            userMap.put("P24name", itemname24);
                            userMap.put("p24price", price24);
                            userMap.put("p25name", itemname25);
                            userMap.put("p25price", price25);
                            userMap.put("P26name", itemname26);
                            userMap.put("p26price", price26);
                            userMap.put("p27name", itemname27);
                            userMap.put("p27price", price27);
                            userMap.put("P28name", itemname28);
                            userMap.put("p28price", price28);
                            userMap.put("p29name", itemname29);
                            userMap.put("p29price", price29);
                            userMap.put("P30name", itemname30);
                            userMap.put("p30price", price30);
                            userMap.put("p31name", itemname31);
                            userMap.put("p31price", price31);
                            userMap.put("P32name", itemname32);
                            userMap.put("p32price", price32);
                            userMap.put("p33name", itemname33);
                            userMap.put("p33price", price33);
                            userMap.put("P34name", itemname34);
                            userMap.put("p34price", price34);
                            userMap.put("p35name", itemname35);
                            userMap.put("p35price", price35);
                            userMap.put("timestamp", FieldValue.serverTimestamp());
                            userMap.put("storeid", storeid1);
                            userMap.put("total", totalx);
                            userMap.put("deliverytype", deliverytype);
                            userMap.put("paymentmode", cod);
                            userMap.put("uniqueid",randonString);// need to make updates in the adapter
                            firebaseFirestore.collection(storeid1 + "orders").add(userMap).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(Onlinepayment.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.INVISIBLE);
                                }
                            }).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    firebaseFirestore.collection(user_id + "orders").add(userMap).addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Onlinepayment.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                            progressBar.setVisibility(View.INVISIBLE);
                                        }
                                    }).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentReference> task) {
                                            Map<String, Object> Razormap = new HashMap<>();
                                            Razormap.put("RazorpaypaymentID", s);
                                            Razormap.put("name", namex);
                                            Razormap.put("Phonenumber", phonenumberx);
                                            Razormap.put("address", addressx);
                                            Razormap.put("timestamp", FieldValue.serverTimestamp());
                                            Razormap.put("uniqueid",user_id+FieldValue.serverTimestamp());
                                            firebaseFirestore.collection("Razorpayid").add(Razormap).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                                    cs.clearCart(Onlinepayment.this);
                                                    progressBar.setVisibility(View.INVISIBLE);
                                                    sendsms(storeid1,randonString);
                                                }
                                            });

                                        }
                                    });
                                }
                            });
                        }
                    }

                }
            }
        });
    }


    private void sendsms(String storeid1, String randonString) {
        firebaseFirestore.collection("Owner").document(storeid1).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        String shopphonenumber = task.getResult().getString("shopphonenumber");
                        SmsManager sms=SmsManager.getDefault();
                        String msg="Alert Rapid Cart New Order Placed"+"\n"+"Order id :"+randonString;
                        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
                        sms.sendTextMessage("+91"+shopphonenumber, null, msg, pi,null);
                        Toast.makeText(getApplicationContext(), "Message Sent successfully!", Toast.LENGTH_LONG).show();
                        Intent setupIntent = new Intent(Onlinepayment.this, SplashScreenOrderplaced.class);
                        startActivity(setupIntent);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Onlinepayment.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {
        Toast.makeText(Onlinepayment.this, s, Toast.LENGTH_SHORT).show();
    }
    private void setOrientation(Onlinepayment context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}




