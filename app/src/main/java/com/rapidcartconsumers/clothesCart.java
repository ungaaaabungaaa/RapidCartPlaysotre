package com.rapidcartconsumers;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.carteasy.v1.lib.Carteasy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class clothesCart extends AppCompatActivity {
    TextView desc;
    TextView pricex;
    ImageView imageView;
    Button cartaddbutton;
    public FirebaseAuth mAuth;
    private FirebaseFirestore firebaseFirestore;
    String user_id;
    String storename = null;
    String storeid = null;
    String price = null;
    String storepin = null;
    String storephonenumber = null;
    String itemname = null;
    String itemimage = null;
    String itemdesc = null;
    String delivarymessage = null;
    String quantity = null;
    String x;
    ImageView back;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes_cart);
        ImageView back = findViewById(R.id.imageView19);
        Carteasy cs = new Carteasy();
        x = "del";
        setOrientation(clothesCart.this);
        desc = findViewById(R.id.textView23);
        pricex = findViewById(R.id.textView22);
        imageView = findViewById(R.id.imageView21);
        firebaseFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    if (task.getResult().exists()) {
                        String name = task.getResult().getString("name");
                        String phonenumber = task.getResult().getString("Phonenumber");
                        String address = task.getResult().getString("address");
                        String pincode = task.getResult().getString("pincode");

                        Bundle bundle2 = getIntent().getExtras();
                        if (bundle2 != null) {
                            storename = bundle2.get("1").toString();
                            storeid = bundle2.get("2").toString();
                            storepin = bundle2.get("3").toString();
                            storephonenumber = bundle2.get("4").toString();
                            itemname = bundle2.get("5").toString();
                            price = bundle2.get("6").toString();
                            delivarymessage = bundle2.get("7").toString();
                            itemimage = bundle2.get("8").toString();
                            itemdesc = bundle2.get("9").toString();
                            desc.setText(itemdesc);
                            pricex.setText(price);
                            Glide.with(clothesCart.this).load(itemimage).thumbnail(0.25f).into(imageView);
                        }

                        String value1 = cs.getString(p1, "itemname1", getApplicationContext());
                        String value2 = cs.getString(p2, "itemname2", getApplicationContext());
                        String value3 = cs.getString(p3, "itemname3", getApplicationContext());
                        String value4 = cs.getString(p4, "itemname4", getApplicationContext());
                        String value5 = cs.getString(p5, "itemname5", getApplicationContext());
                        String value6 = cs.getString(p6, "itemname6", getApplicationContext());
                        String value7 = cs.getString(p7, "itemname7", getApplicationContext());
                        String value8 = cs.getString(p8, "itemname8", getApplicationContext());
                        String value9 = cs.getString(p9, "itemname9", getApplicationContext());
                        String value10 = cs.getString(p10, "itemname10", getApplicationContext());


                        String value11 = cs.getString(p11, "itemname11", getApplicationContext());
                        String value12 = cs.getString(p12, "itemname12", getApplicationContext());
                        String value13 = cs.getString(p13, "itemname13", getApplicationContext());
                        String value14 = cs.getString(p14, "itemname14", getApplicationContext());
                        String value15 = cs.getString(p15, "itemname15", getApplicationContext());
                        String value16 = cs.getString(p16, "itemname16", getApplicationContext());
                        String value17 = cs.getString(p17, "itemname17", getApplicationContext());
                        String value18 = cs.getString(p18, "itemname18", getApplicationContext());
                        String value19 = cs.getString(p19, "itemname19", getApplicationContext());
                        String value20 = cs.getString(p20, "itemname20", getApplicationContext());


                        String value21 = cs.getString(p21, "itemname21", getApplicationContext());
                        String value22 = cs.getString(p22, "itemname22", getApplicationContext());
                        String value23 = cs.getString(p23, "itemname23", getApplicationContext());
                        String value24 = cs.getString(p24, "itemname24", getApplicationContext());
                        String value25 = cs.getString(p25, "itemname25", getApplicationContext());
                        String value26 = cs.getString(p26, "itemname26", getApplicationContext());
                        String value27 = cs.getString(p27, "itemname27", getApplicationContext());
                        String value28 = cs.getString(p28, "itemname28", getApplicationContext());
                        String value29 = cs.getString(p29, "itemname29", getApplicationContext());
                        String value30 = cs.getString(p30, "itemname30", getApplicationContext());

                        String value31 = cs.getString(p31, "itemname31", getApplicationContext());
                        String value32 = cs.getString(p32, "itemname32", getApplicationContext());
                        String value33 = cs.getString(p33, "itemname33", getApplicationContext());
                        String value34 = cs.getString(p34, "itemname34", getApplicationContext());
                        String value35 = cs.getString(p35, "itemname35", getApplicationContext());


                        cartaddbutton = findViewById(R.id.button2);
                        cartaddbutton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                // check data and store according

                                if (value1.equals("")) {
                                    cs.add(p1, "itemname1", itemname);
                                    cs.add(p1, "price1", price);
                                    cs.add(p1, "storeid1", storeid);
                                    cs.add(p1, "itemurl1", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 1", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value2.equals("")) {

                                    cs.add(p2, "itemname2", itemname);
                                    cs.add(p2, "price2", price);
                                    cs.add(p2, "storeid2", storeid);
                                    cs.add(p2, "itemurl2", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 2", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value3.equals("")) {

                                    cs.add(p3, "itemname3", itemname);
                                    cs.add(p3, "price3", price);
                                    cs.add(p3, "storeid3", storeid);
                                    cs.add(p3, "itemurl3", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 3", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value4.equals("")) {

                                    cs.add(p4, "itemname4", itemname);
                                    cs.add(p4, "price4", price);
                                    cs.add(p4, "storeid4", storeid);
                                    cs.add(p4, "itemurl4", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 4", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value5.equals("")) {

                                    cs.add(p5, "itemname5", itemname);
                                    cs.add(p5, "price5", price);
                                    cs.add(p5, "storeid5", storeid);
                                    cs.add(p5, "itemurl5", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 5", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value6.equals("")) {

                                    cs.add(p6, "itemname6", itemname);
                                    cs.add(p6, "price6", price);
                                    cs.add(p6, "storeid6", storeid);
                                    cs.add(p6, "itemurl6", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 6", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value7.equals("")) {

                                    cs.add(p7, "itemname7", itemname);
                                    cs.add(p7, "price7", price);
                                    cs.add(p7, "storeid7", storeid);
                                    cs.add(p7, "itemurl7", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 7", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value8.equals("")) {

                                    cs.add(p8, "itemname8", itemname);
                                    cs.add(p8, "price8", price);
                                    cs.add(p8, "storeid8", storeid);
                                    cs.add(p8, "itemurl8", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 8", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value9.equals("")) {

                                    cs.add(p9, "itemname9", itemname);
                                    cs.add(p9, "price9", price);
                                    cs.add(p9, "storeid9", storeid);
                                    cs.add(p9, "itemurl9", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 9", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value10.equals("")) {

                                    cs.add(p10, "itemname10", itemname);
                                    cs.add(p10, "price10", price);
                                    cs.add(p10, "storeid10", storeid);
                                    cs.add(p10, "itemurl10", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 10", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value11.equals("")) {
                                    cs.add(p11, "itemname11", itemname);
                                    cs.add(p11, "price11", price);
                                    cs.add(p11, "storeid11", storeid);
                                    cs.add(p11, "itemurl11", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 11", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value12.equals("")) {

                                    cs.add(p12, "itemname12", itemname);
                                    cs.add(p12, "price12", price);
                                    cs.add(p12, "storeid12", storeid);
                                    cs.add(p12, "itemurl12", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 12", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value13.equals("")) {

                                    cs.add(p13, "itemname13", itemname);
                                    cs.add(p13, "price13", price);
                                    cs.add(p13, "storeid13", storeid);
                                    cs.add(p13, "itemurl13", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 13", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value14.equals("")) {

                                    cs.add(p14, "itemname14", itemname);
                                    cs.add(p14, "price14", price);
                                    cs.add(p14, "storeid14", storeid);
                                    cs.add(p14, "itemurl14", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 14", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value15.equals("")) {

                                    cs.add(p15, "itemname15", itemname);
                                    cs.add(p15, "price15", price);
                                    cs.add(p15, "storeid15", storeid);
                                    cs.add(p15, "itemurl15", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 15", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value16.equals("")) {

                                    cs.add(p16, "itemname16", itemname);
                                    cs.add(p16, "price16", price);
                                    cs.add(p16, "storeid16", storeid);
                                    cs.add(p16, "itemurl16", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 16", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value17.equals("")) {

                                    cs.add(p17, "itemname17", itemname);
                                    cs.add(p17, "price17", price);
                                    cs.add(p17, "storeid17", storeid);
                                    cs.add(p17, "itemur17", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 17", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value18.equals("")) {

                                    cs.add(p18, "itemname18", itemname);
                                    cs.add(p18, "price18", price);
                                    cs.add(p18, "storeid18", storeid);
                                    cs.add(p18, "itemurl18", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 18", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value19.equals("")) {

                                    cs.add(p19, "itemname19", itemname);
                                    cs.add(p19, "price19", price);
                                    cs.add(p19, "storeid19", storeid);
                                    cs.add(p19, "itemurl19", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 19", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value20.equals("")) {

                                    cs.add(p20, "itemname20", itemname);
                                    cs.add(p20, "price20", price);
                                    cs.add(p20, "storeid20", storeid);
                                    cs.add(p20, "itemurl20", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 20", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value21.equals("")) {
                                    cs.add(p21, "itemname21", itemname);
                                    cs.add(p21, "price21", price);
                                    cs.add(p21, "storeid21", storeid);
                                    cs.add(p21, "itemurl21", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 21", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value22.equals("")) {

                                    cs.add(p22, "itemname22", itemname);
                                    cs.add(p22, "price22", price);
                                    cs.add(p22, "storeid22", storeid);
                                    cs.add(p22, "itemurl22", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 22", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value23.equals("")) {

                                    cs.add(p23, "itemname23", itemname);
                                    cs.add(p23, "price23", price);
                                    cs.add(p23, "storeid23", storeid);
                                    cs.add(p23, "itemurl23", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 23", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value24.equals("")) {

                                    cs.add(p24, "itemname24", itemname);
                                    cs.add(p24, "price24", price);
                                    cs.add(p24, "storeid24", storeid);
                                    cs.add(p24, "itemurl24", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 24", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value25.equals("")) {

                                    cs.add(p25, "itemname25", itemname);
                                    cs.add(p25, "price25", price);
                                    cs.add(p25, "storeid25", storeid);
                                    cs.add(p25, "itemurl25", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 25", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value26.equals("")) {

                                    cs.add(p26, "itemname26", itemname);
                                    cs.add(p26, "price26", price);
                                    cs.add(p26, "storeid26", storeid);
                                    cs.add(p26, "itemurl26", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 26", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value27.equals("")) {

                                    cs.add(p27, "itemname27", itemname);
                                    cs.add(p27, "price27", price);
                                    cs.add(p27, "storeid27", storeid);
                                    cs.add(p27, "itemurl27", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 27", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value28.equals("")) {

                                    cs.add(p28, "itemname28", itemname);
                                    cs.add(p28, "price28", price);
                                    cs.add(p28, "storeid28", storeid);
                                    cs.add(p28, "itemurl28", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 28", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value29.equals("")) {

                                    cs.add(p29, "itemname29", itemname);
                                    cs.add(p29, "price29", price);
                                    cs.add(p29, "storeid29", storeid);
                                    cs.add(p29, "itemurl29", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 29", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value30.equals("")) {

                                    cs.add(p30, "itemname30", itemname);
                                    cs.add(p30, "price30", price);
                                    cs.add(p30, "storeid30", storeid);
                                    cs.add(p30, "itemurl30", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 30", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if
                                (value31.equals("")) {
                                    cs.add(p31, "itemname31", itemname);
                                    cs.add(p31, "price31", price);
                                    cs.add(p31, "storeid31", storeid);
                                    cs.add(p31, "itemurl31", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 31", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value32.equals("")) {

                                    cs.add(p32, "itemname32", itemname);
                                    cs.add(p32, "price32", price);
                                    cs.add(p32, "storeid32", storeid);
                                    cs.add(p32, "itemurl32", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 32", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value33.equals("")) {

                                    cs.add(p33, "itemname33", itemname);
                                    cs.add(p33, "price33", price);
                                    cs.add(p33, "storeid33", storeid);
                                    cs.add(p33, "itemurl33", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 33", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value34.equals("")) {

                                    cs.add(p34, "itemname34", itemname);
                                    cs.add(p34, "price34", price);
                                    cs.add(p34, "storeid34", storeid);
                                    cs.add(p34, "itemurl34", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 34", Toast.LENGTH_LONG).show();
                                    finish();
                                } else if (value35.equals("")) {

                                    cs.add(p35, "itemname35", itemname);
                                    cs.add(p35, "price35", price);
                                    cs.add(p35, "storeid35", storeid);
                                    cs.add(p35, "itemurl35", itemimage);
                                    cs.commit(getApplicationContext());
                                    cs.persistData(clothesCart.this, true);
                                    Toast.makeText(clothesCart.this, itemname + "Added to cart 35", Toast.LENGTH_LONG).show();
                                    finish();
                                } else {
                                    Toast.makeText(clothesCart.this, "Max item in cart ", Toast.LENGTH_LONG).show();
                                    finish();
                                }

                            }
                        });
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(clothesCart.this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void setOrientation(clothesCart context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}


