package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.carteasy.v1.lib.Carteasy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.squareup.picasso.Picasso;

public class CheckoutActivity extends AppCompatActivity {

    ImageView home;

    String user_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;
    Button delete;
    Button checkout;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    String namex;
    String phonenumberx;
    String addressx;
    String pincodex;
    TextView total;

    String p1 = "e400";
    String p2= "e401";
    String p3 = "e402";
    String p4= "e403";
    String p5 = "e404";
    String p6= "e405";
    String p7 = "e406";
    String p8= "e407";
    String p9= "e408";
    String p10= "e409";

    String p11 = "e410";
    String p12= "e411";
    String p13 = "e412";
    String p14= "e413";
    String p15 = "e414";
    String p16= "e415";
    String p17 = "e416";
    String p18= "e417";
    String p19= "e418";
    String p20= "e419";

    String p21 = "e420";
    String p22= "e421";
    String p23 = "e422";
    String p24= "e423";
    String p25 = "e424";
    String p26= "e425";
    String p27 = "e426";
    String p28= "e427";
    String p29= "e428";
    String p30= "e429";

    String p31 = "e430";
    String p32= "e431";
    String p33 = "e432";
    String p34= "e433";
    String p35="e434";


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





    ImageView cartimage1,cartimage2,cartimage3,cartimage4,cartimage5,cartimage6,cartimage7,cartimage8,cartimage9,cartimage10;
    ImageView cartimage11,cartimage12,cartimage13,cartimage14,cartimage15,cartimage16,cartimage17,cartimage18,cartimage19,cartimage20;
    ImageView cartimage21,cartimage22,cartimage23,cartimage24,cartimage25,cartimage26,cartimage27,cartimage28,cartimage29,cartimage30;
    ImageView cartimage31,cartimage32,cartimage33,cartimage34,cartimage35;

    TextView cartitemname1,cartitemname2,cartitemname3,cartitemname4,cartitemname5,cartitemname6,cartitemname7,cartitemname8,cartitemname9,cartitemname10;
    TextView cartitemname11,cartitemname12,cartitemname13,cartitemname14,cartitemname15,cartitemname16,cartitemname17,cartitemname18,cartitemname19,cartitemname20;
    TextView cartitemname21,cartitemname22,cartitemname23,cartitemname24,cartitemname25,cartitemname26,cartitemname27,cartitemname28,cartitemname29,cartitemname30;
    TextView cartitemname31,cartitemname32,cartitemname33,cartitemname34,cartitemname35;

    TextView cartprice1,cartprice2,cartprice3,cartprice4,cartprice5,cartprice6,cartprice7,cartprice8,cartprice9,cartprice10;
    TextView cartprice11,cartprice12,cartprice13,cartprice14,cartprice15,cartprice16,cartprice17,cartprice18,cartprice19,cartprice20;
    TextView cartprice21,cartprice22,cartprice23,cartprice24,cartprice25,cartprice26,cartprice27,cartprice28,cartprice29,cartprice30;
    TextView cartprice31,cartprice32,cartprice33,cartprice34,cartprice35;


    ConstraintLayout c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    ConstraintLayout c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
    ConstraintLayout c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
    ConstraintLayout c31,c32,c33,c34,c35;


    Button del1,del2,del3,del4,del5,del6,del7,del8,del9,del10;
    Button del11,del12,del13,del14,del15,del16,del17,del18,del19,del20;
    Button del21,del22,del23,del24,del25,del26,del27,del28,del29,del30;
    Button del31,del32,del33,del34,del35;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        checkout=findViewById(R.id.button5);
        setOrientation(CheckoutActivity.this);
        total=findViewById(R.id.textView25);
        cartitemname1=findViewById(R.id.textView27);
        cartitemname2=findViewById(R.id.textView272);
        cartitemname3=findViewById(R.id.textView273);
        cartitemname4=findViewById(R.id.textView274);
        cartitemname5=findViewById(R.id.textView275);
        cartitemname6=findViewById(R.id.textView276);
        cartitemname7=findViewById(R.id.textView277);
        cartitemname8=findViewById(R.id.textView278);
        cartitemname9=findViewById(R.id.textView279);
        cartitemname10=findViewById(R.id.textView2710);
        cartitemname11=findViewById(R.id.textView2711);
        cartitemname12=findViewById(R.id.textView2712);
        cartitemname13=findViewById(R.id.textView2713);
        cartitemname14=findViewById(R.id.textView2714);
        cartitemname15=findViewById(R.id.textView2715);
        cartitemname16=findViewById(R.id.textView2716);
        cartitemname17=findViewById(R.id.textView2717);
        cartitemname18=findViewById(R.id.textView2718);
        cartitemname19=findViewById(R.id.textView2719);
        cartitemname20=findViewById(R.id.textView2720);
        cartitemname21=findViewById(R.id.textView2721);
        cartitemname22=findViewById(R.id.textView2722);
        cartitemname23=findViewById(R.id.textView2723);
        cartitemname24=findViewById(R.id.textView2724);
        cartitemname25=findViewById(R.id.textView2725);
        cartitemname26=findViewById(R.id.textView2726);
        cartitemname27=findViewById(R.id.textView2727);
        cartitemname28=findViewById(R.id.textView2728);
        cartitemname29=findViewById(R.id.textView2729);
        cartitemname30=findViewById(R.id.textView2730);
        cartitemname31=findViewById(R.id.textView2731);
        cartitemname32=findViewById(R.id.textView2732);
        cartitemname33=findViewById(R.id.textView2733);
        cartitemname34=findViewById(R.id.textView2734);
        cartitemname35=findViewById(R.id.textView2735);
        cartimage1=findViewById(R.id.cartimage1);
        cartimage2=findViewById(R.id.cartimage2);
        cartimage3=findViewById(R.id.cartimage3);
        cartimage4=findViewById(R.id.cartimage4);
        cartimage5=findViewById(R.id.cartimage5);
        cartimage6=findViewById(R.id.cartimage6);
        cartimage7=findViewById(R.id.cartimage7);
        cartimage8=findViewById(R.id.cartimage8);
        cartimage9=findViewById(R.id.cartimage9);
        cartimage10=findViewById(R.id.cartimage10);
        cartimage11=findViewById(R.id.cartimage11);
        cartimage12=findViewById(R.id.cartimage12);
        cartimage13=findViewById(R.id.cartimage13);
        cartimage14=findViewById(R.id.cartimage14);
        cartimage15=findViewById(R.id.cartimage15);
        cartimage16=findViewById(R.id.cartimage16);
        cartimage17=findViewById(R.id.cartimage17);
        cartimage18=findViewById(R.id.cartimage18);
        cartimage19=findViewById(R.id.cartimage19);
        cartimage20=findViewById(R.id.cartimage20);
        cartimage21=findViewById(R.id.cartimage21);
        cartimage22=findViewById(R.id.cartimage22);
        cartimage23=findViewById(R.id.cartimage23);
        cartimage24=findViewById(R.id.cartimage24);
        cartimage25=findViewById(R.id.cartimage25);
        cartimage26=findViewById(R.id.cartimage26);
        cartimage27=findViewById(R.id.cartimage27);
        cartimage28=findViewById(R.id.cartimage28);
        cartimage29=findViewById(R.id.cartimage29);
        cartimage30=findViewById(R.id.cartimage30);
        cartimage31=findViewById(R.id.cartimage31);
        cartimage32=findViewById(R.id.cartimage32);
        cartimage33=findViewById(R.id.cartimage33);
        cartimage34=findViewById(R.id.cartimage34);
        cartimage35=findViewById(R.id.cartimage35);
        cartprice1=findViewById(R.id.textView28);
        cartprice2=findViewById(R.id.textView282);
        cartprice3=findViewById(R.id.textView283);
        cartprice4=findViewById(R.id.textView284);
        cartprice5=findViewById(R.id.textView285);
        cartprice6=findViewById(R.id.textView286);
        cartprice7=findViewById(R.id.textView287);
        cartprice8=findViewById(R.id.textView288);
        cartprice9=findViewById(R.id.textView289);
        cartprice10=findViewById(R.id.textView2810);
        cartprice11=findViewById(R.id.textView2811);
        cartprice12=findViewById(R.id.textView2812);
        cartprice13=findViewById(R.id.textView2813);
        cartprice14=findViewById(R.id.textView2814);
        cartprice15=findViewById(R.id.textView2815);
        cartprice16=findViewById(R.id.textView2816);
        cartprice17=findViewById(R.id.textView2817);
        cartprice18=findViewById(R.id.textView2818);
        cartprice19=findViewById(R.id.textView2819);
        cartprice20=findViewById(R.id.textView2820);
        cartprice21=findViewById(R.id.textView2821);
        cartprice22=findViewById(R.id.textView2822);
        cartprice23=findViewById(R.id.textView2823);
        cartprice24=findViewById(R.id.textView2824);
        cartprice25=findViewById(R.id.textView2825);
        cartprice26=findViewById(R.id.textView2826);
        cartprice27=findViewById(R.id.textView2827);
        cartprice28=findViewById(R.id.textView2828);
        cartprice29=findViewById(R.id.textView2829);
        cartprice30=findViewById(R.id.textView2830);
        cartprice31=findViewById(R.id.textView2831);
        cartprice32=findViewById(R.id.textView2832);
        cartprice33=findViewById(R.id.textView2833);
        cartprice34=findViewById(R.id.textView2834);
        cartprice35=findViewById(R.id.textView2835);
        c1=findViewById(R.id.constraincart1);
        c2=findViewById(R.id.constraincart2);
        c3=findViewById(R.id.constraincart3);
        c4=findViewById(R.id.constraincart4);
        c5=findViewById(R.id.constraincart5);
        c6=findViewById(R.id.constraincart6);
        c7=findViewById(R.id.constraincart7);
        c8=findViewById(R.id.constraincart8);
        c9=findViewById(R.id.constraincart9);
        c10=findViewById(R.id.constraincart10);
        c11=findViewById(R.id.constraincart11);
        c12=findViewById(R.id.constraincart12);
        c13=findViewById(R.id.constraincart13);
        c14=findViewById(R.id.constraincart14);
        c15=findViewById(R.id.constraincart15);
        c16=findViewById(R.id.constraincart16);
        c17=findViewById(R.id.constraincart17);
        c18=findViewById(R.id.constraincart18);
        c19=findViewById(R.id.constraincart19);
        c20=findViewById(R.id.constraincart20);
        c21=findViewById(R.id.constraincart21);
        c22=findViewById(R.id.constraincart22);
        c23=findViewById(R.id.constraincart23);
        c24=findViewById(R.id.constraincart24);
        c25=findViewById(R.id.constraincart25);
        c26=findViewById(R.id.constraincart26);
        c27=findViewById(R.id.constraincart27);
        c28=findViewById(R.id.constraincart28);
        c29=findViewById(R.id.constraincart29);
        c30=findViewById(R.id.constraincart30);
        c31=findViewById(R.id.constraincart31);
        c32=findViewById(R.id.constraincart32);
        c33=findViewById(R.id.constraincart33);
        c34=findViewById(R.id.constraincart34);
        c35=findViewById(R.id.constraincart35);


        del1=findViewById(R.id.del1);
        del2=findViewById(R.id.del2);
        del3=findViewById(R.id.del3);
        del4=findViewById(R.id.del4);
        del5=findViewById(R.id.del5);
        del6=findViewById(R.id.del6);
        del7=findViewById(R.id.del7);
        del8=findViewById(R.id.del8);
        del9=findViewById(R.id.del9);
        del10=findViewById(R.id.del10);


        del11=findViewById(R.id.del11);
        del12=findViewById(R.id.del12);
        del13=findViewById(R.id.del13);
        del14=findViewById(R.id.del14);
        del15=findViewById(R.id.del15);
        del16=findViewById(R.id.del16);
        del17=findViewById(R.id.del17);
        del18=findViewById(R.id.del18);
        del19=findViewById(R.id.del19);
        del20=findViewById(R.id.del20);

        del21=findViewById(R.id.del21);
        del22=findViewById(R.id.del22);
        del23=findViewById(R.id.del23);
        del24=findViewById(R.id.del24);
        del25=findViewById(R.id.del25);
        del26=findViewById(R.id.del26);
        del27=findViewById(R.id.del27);
        del28=findViewById(R.id.del28);
        del29=findViewById(R.id.del29);
        del30=findViewById(R.id.del30);

        del31=findViewById(R.id.del31);
        del32=findViewById(R.id.del32);
        del33=findViewById(R.id.del33);
        del34=findViewById(R.id.del34);
        del35=findViewById(R.id.del35);


        mAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        Carteasy cs = new Carteasy();
        user_id = firebaseAuth.getCurrentUser().getUid();
        home=findViewById(R.id.imageView19);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // get user details from firebase
        firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        namex = task.getResult().getString("name");
                        phonenumberx = task.getResult().getString("Phonenumber");
                        addressx = task.getResult().getString("address");
                        pincodex = task.getResult().getString("pincode");
                        delete=findViewById(R.id.button9);
                        delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                cs.clearCart(CheckoutActivity.this);
                                Intent setupIntent = new Intent(CheckoutActivity.this, ShopSelectActivity.class);
                                startActivity(setupIntent);
                                Toast.makeText(CheckoutActivity.this,"cart empty", Toast.LENGTH_LONG).show();
                            }
                        });


                        String itemname1 = cs.getString(p1, "itemname1",getApplicationContext());
                        String price1 = cs.getString(p1, "price1", getApplicationContext());
                        String storeid1 = cs.getString(p1, "storeid1", getApplicationContext());
                        String itemurl1 = cs.getString(p1, "itemurl1", getApplicationContext());

                        if (!price1.equals(""))
                        {
                            result1 = Integer.parseInt(price1);
                            c1.setVisibility(View.VISIBLE);
                            cartitemname1.setText(itemname1);
                            cartprice1.setText("₹"+price1);
                            Picasso.get().load(itemurl1).into(cartimage1);
                            checkout.setVisibility(View.VISIBLE);
                            del1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p1, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                        String itemname2 = cs.getString(p2, "itemname2",getApplicationContext());
                        String price2 = cs.getString(p2, "price2", getApplicationContext());
                        String storeid2 = cs.getString(p2, "storeid2", getApplicationContext());
                        String itemurl2 = cs.getString(p2, "itemurl2", getApplicationContext());

                        if (!price2.equals(""))
                        {
                            result2 = Integer.parseInt(price2);
                            c2.setVisibility(View.VISIBLE);
                            cartitemname2.setText(itemname2);
                            cartprice2.setText("₹"+price2);
                            Picasso.get().load(itemurl2).into(cartimage2);

                            del2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p2, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname3 = cs.getString(p3, "itemname3",getApplicationContext());
                        String price3 = cs.getString(p3, "price3", getApplicationContext());
                        String storeid3 = cs.getString(p3, "storeid3", getApplicationContext());
                        String itemurl3 = cs.getString(p3, "itemurl3", getApplicationContext());

                        if (!price3.equals(""))
                        {
                            result3 = Integer.parseInt(price3);
                            c3.setVisibility(View.VISIBLE);
                            cartitemname3.setText(itemname3);
                            cartprice3.setText("₹"+price3);
                            Picasso.get().load(itemurl3).into(cartimage3);

                            del3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p3, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        String itemname4 = cs.getString(p4, "itemname4",getApplicationContext());
                        String price4 = cs.getString(p4, "price4", getApplicationContext());
                        String storeid4 = cs.getString(p4, "storeid4", getApplicationContext());
                        String itemurl4 = cs.getString(p4, "itemurl4", getApplicationContext());

                        if (!price4.equals(""))
                        {
                            result4 = Integer.parseInt(price4);
                            c4.setVisibility(View.VISIBLE);
                            cartitemname4.setText(itemname4);
                            cartprice4.setText("₹"+price4);
                            Picasso.get().load(itemurl4).into(cartimage4);

                            del4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p4, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname5 = cs.getString(p5, "itemname5",getApplicationContext());
                        String price5 = cs.getString(p5, "price5", getApplicationContext());
                        String storeid5 = cs.getString(p5, "storeid5", getApplicationContext());
                        String itemurl5 = cs.getString(p5, "itemurl5", getApplicationContext());

                        if (!price5.equals(""))
                        {
                            result5 = Integer.parseInt(price5);
                            c5.setVisibility(View.VISIBLE);
                            cartitemname5.setText(itemname5);
                            cartprice5.setText("₹"+price5);
                            Picasso.get().load(itemurl5).into(cartimage5);

                            del5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p5, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });

                        }



                        String itemname6 = cs.getString(p6, "itemname6",getApplicationContext());
                        String price6 = cs.getString(p6, "price6", getApplicationContext());
                        String storeid6 = cs.getString(p6, "storeid6", getApplicationContext());
                        String itemurl6 = cs.getString(p6, "itemurl6", getApplicationContext());

                        if (!price6.equals(""))
                        {
                            result6 = Integer.parseInt(price6);
                            c6.setVisibility(View.VISIBLE);
                            cartitemname6.setText(itemname6);
                            cartprice6.setText("₹"+price6);
                            Picasso.get().load(itemurl6).into(cartimage6);

                            del6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p6, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }

                            });
                        }




                        String itemname7 = cs.getString(p7, "itemname7",getApplicationContext());
                        String price7 = cs.getString(p7, "price7", getApplicationContext());
                        String storeid7 = cs.getString(p7, "storeid7", getApplicationContext());
                        String itemurl7 = cs.getString(p7, "itemurl7", getApplicationContext());

                        if (!price7.equals(""))
                        {
                            result7 = Integer.parseInt(price7);
                            c7.setVisibility(View.VISIBLE);
                            cartitemname7.setText(itemname7);
                            cartprice7.setText("₹"+price7);
                            Picasso.get().load(itemurl7).into(cartimage7);

                            del7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p7, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname8 = cs.getString(p8, "itemname8",getApplicationContext());
                        String price8 = cs.getString(p8, "price8", getApplicationContext());
                        String storeid8 = cs.getString(p8, "storeid8", getApplicationContext());
                        String itemurl8 = cs.getString(p8, "itemurl8", getApplicationContext());

                        if (!price8.equals(""))
                        {
                            result8 = Integer.parseInt(price8);
                            c8.setVisibility(View.VISIBLE);
                            cartitemname8.setText(itemname8);
                            cartprice8.setText("₹"+price8);
                            Picasso.get().load(itemurl8).into(cartimage8);

                            del8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p8, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname9 = cs.getString(p9, "itemname9",getApplicationContext());
                        String price9 = cs.getString(p9, "price9", getApplicationContext());
                        String storeid9 = cs.getString(p9, "storeid9", getApplicationContext());
                        String itemurl9 = cs.getString(p9, "itemurl9", getApplicationContext());

                        if (!price9.equals(""))
                        {
                            result9 = Integer.parseInt(price9);
                            c9.setVisibility(View.VISIBLE);
                            cartitemname9.setText(itemname9);
                            cartprice9.setText("₹"+price9);
                            Picasso.get().load(itemurl9).into(cartimage9);

                            del9.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p9, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname10 = cs.getString(p10, "itemname10",getApplicationContext());
                        String price10 = cs.getString(p10, "price10", getApplicationContext());
                        String storeid10 = cs.getString(p10, "storeid10", getApplicationContext());
                        String itemurl10 = cs.getString(p10, "itemurl10", getApplicationContext());

                        if (!price10.equals(""))
                        {
                            result10 = Integer.parseInt(price10);
                            c10.setVisibility(View.VISIBLE);
                            cartitemname10.setText(itemname10);
                            cartprice10.setText("₹"+price10);
                            Picasso.get().load(itemurl10).into(cartimage10);

                            del10.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p10, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname11 = cs.getString(p11, "itemname11",getApplicationContext());
                        String price11 = cs.getString(p11, "price11", getApplicationContext());
                        String storeid11 = cs.getString(p11, "storeid11", getApplicationContext());
                        String itemurl11 = cs.getString(p11, "itemurl11", getApplicationContext());

                        if (!price11.equals(""))
                        {
                            result11 = Integer.parseInt(price11);
                            c11.setVisibility(View.VISIBLE);
                            cartitemname11.setText(itemname11);
                            cartprice11.setText("₹"+price11);
                            Picasso.get().load(itemurl11).into(cartimage11);
                            del11.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p11, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        String itemname12 = cs.getString(p12, "itemname12",getApplicationContext());
                        String price12 = cs.getString(p12, "price12", getApplicationContext());
                        String storeid12 = cs.getString(p12, "storeid12", getApplicationContext());
                        String itemurl12 = cs.getString(p12, "itemurl12", getApplicationContext());

                        if (!price12.equals(""))
                        {
                            result12 = Integer.parseInt(price12);
                            c12.setVisibility(View.VISIBLE);
                            cartitemname12.setText(itemname12);
                            cartprice12.setText("₹"+price12);
                            Picasso.get().load(itemurl12).into(cartimage12);
                            del12.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p12, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname13 = cs.getString(p13, "itemname13",getApplicationContext());
                        String price13 = cs.getString(p13, "price13", getApplicationContext());
                        String storeid13 = cs.getString(p13, "storeid13", getApplicationContext());
                        String itemurl13 = cs.getString(p13, "itemurl13", getApplicationContext());

                        if (!price13.equals(""))
                        {
                            result13 = Integer.parseInt(price13);
                            c13.setVisibility(View.VISIBLE);
                            cartitemname13.setText(itemname13);
                            cartprice13.setText("₹"+price13);
                            Picasso.get().load(itemurl13).into(cartimage13);
                            del13.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p13, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        String itemname14 = cs.getString(p14, "itemname14",getApplicationContext());
                        String price14 = cs.getString(p14, "price14", getApplicationContext());
                        String storeid14 = cs.getString(p14, "storeid14", getApplicationContext());
                        String itemurl14 = cs.getString(p14, "itemurl14", getApplicationContext());

                        if (!price14.equals(""))
                        {
                            result14 = Integer.parseInt(price14);
                            c14.setVisibility(View.VISIBLE);
                            cartitemname14.setText(itemname14);
                            cartprice14.setText("₹"+price14);
                            Picasso.get().load(itemurl14).into(cartimage14);
                            del14.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p14, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname15 = cs.getString(p15, "itemname15",getApplicationContext());
                        String price15 = cs.getString(p15, "price15", getApplicationContext());
                        String storeid15 = cs.getString(p15, "storeid15", getApplicationContext());
                        String itemurl15 = cs.getString(p15, "itemurl15", getApplicationContext());

                        if (!price15.equals(""))
                        {
                            result15 = Integer.parseInt(price15);
                            c15.setVisibility(View.VISIBLE);
                            cartitemname15.setText(itemname15);
                            cartprice15.setText("₹"+price15);
                            Picasso.get().load(itemurl15).into(cartimage15);
                            del15.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p15, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname16 = cs.getString(p16, "itemname16",getApplicationContext());
                        String price16 = cs.getString(p16, "price16", getApplicationContext());
                        String storeid16 = cs.getString(p16, "storeid16", getApplicationContext());
                        String itemurl16 = cs.getString(p16, "itemurl16", getApplicationContext());

                        if (!price16.equals(""))
                        {
                            result16 = Integer.parseInt(price16);
                            c16.setVisibility(View.VISIBLE);
                            cartitemname16.setText(itemname16);
                            cartprice16.setText("₹"+price16);
                            Picasso.get().load(itemurl16).into(cartimage16);
                            del16.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p16, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }




                        String itemname17 = cs.getString(p17, "itemname17",getApplicationContext());
                        String price17 = cs.getString(p17, "price17", getApplicationContext());
                        String storeid17 = cs.getString(p17, "storeid17", getApplicationContext());
                        String itemurl17 = cs.getString(p17, "itemur17", getApplicationContext());

                        if (!price17.equals(""))
                        {
                            result17 = Integer.parseInt(price17);
                            c17.setVisibility(View.VISIBLE);
                            cartitemname17.setText(itemname17);
                            cartprice17.setText("₹"+price17);
                            Picasso.get().load(itemurl17).into(cartimage17);
                            del17.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p17, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname18 = cs.getString(p18, "itemname18",getApplicationContext());
                        String price18 = cs.getString(p18, "price18", getApplicationContext());
                        String storeid18 = cs.getString(p18, "storeid18", getApplicationContext());
                        String itemurl18 = cs.getString(p18, "itemurl18", getApplicationContext());

                        if (!price18.equals(""))
                        {
                            result18 = Integer.parseInt(price18);
                            c18.setVisibility(View.VISIBLE);
                            cartitemname18.setText(itemname18);
                            cartprice18.setText("₹"+price18);
                            Picasso.get().load(itemurl18).into(cartimage18);
                            del18.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p18, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname19 = cs.getString(p19, "itemname19",getApplicationContext());
                        String price19 = cs.getString(p19, "price19", getApplicationContext());
                        String storeid19 = cs.getString(p19, "storeid19", getApplicationContext());
                        String itemurl19 = cs.getString(p19, "itemurl19", getApplicationContext());

                        if (!price19.equals(""))
                        {
                            result19 = Integer.parseInt(price19);
                            c19.setVisibility(View.VISIBLE);
                            cartitemname19.setText(itemname19);
                            cartprice19.setText("₹"+price19);
                            Picasso.get().load(itemurl19).into(cartimage19);
                            del19.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p19, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname20 = cs.getString(p20, "itemname20",getApplicationContext());
                        String price20 = cs.getString(p20, "price20", getApplicationContext());
                        String storeid20 = cs.getString(p20, "storeid20", getApplicationContext());
                        String itemurl20 = cs.getString(p20, "itemurl20", getApplicationContext());

                        if (!price20.equals(""))
                        {
                            result20 = Integer.parseInt(price20);
                            c20.setVisibility(View.VISIBLE);
                            cartitemname20.setText(itemname20);
                            cartprice20.setText("₹"+price20);
                            Picasso.get().load(itemurl20).into(cartimage20);
                            del20.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p20, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname21 = cs.getString(p21, "itemname21",getApplicationContext());
                        String price21 = cs.getString(p21, "price21", getApplicationContext());
                        String storeid21 = cs.getString(p21, "storeid21", getApplicationContext());
                        String itemurl21 = cs.getString(p21, "itemurl21", getApplicationContext());

                        if (!price21.equals(""))
                        {
                            result21 = Integer.parseInt(price21);
                            c21.setVisibility(View.VISIBLE);
                            cartitemname21.setText(itemname21);
                            cartprice21.setText("₹"+price21);
                            Picasso.get().load(itemurl21).into(cartimage21);
                            del21.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p21, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                        String itemname22 = cs.getString(p22, "itemname22",getApplicationContext());
                        String price22 = cs.getString(p22, "price22", getApplicationContext());
                        String storeid22 = cs.getString(p22, "storeid22", getApplicationContext());
                        String itemurl22 = cs.getString(p22, "itemurl22", getApplicationContext());

                        if (!price22.equals(""))
                        {
                            result22 = Integer.parseInt(price22);
                            c22.setVisibility(View.VISIBLE);
                            cartitemname22.setText(itemname22);
                            cartprice22.setText("₹"+price22);
                            Picasso.get().load(itemurl22).into(cartimage22);
                            del22.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p22, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname23 = cs.getString(p23, "itemname23",getApplicationContext());
                        String price23 = cs.getString(p23, "price23", getApplicationContext());
                        String storeid23 = cs.getString(p23, "storeid23", getApplicationContext());
                        String itemurl23 = cs.getString(p23, "itemurl23", getApplicationContext());

                        if (!price23.equals(""))
                        {
                            result23 = Integer.parseInt(price23);
                            c23.setVisibility(View.VISIBLE);
                            cartitemname23.setText(itemname23);
                            cartprice23.setText("₹"+price23);
                            Picasso.get().load(itemurl23).into(cartimage23);
                            del23.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p23, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        String itemname24 = cs.getString(p24, "itemname24",getApplicationContext());
                        String price24 = cs.getString(p24, "price24", getApplicationContext());
                        String storeid24 = cs.getString(p24, "storeid24", getApplicationContext());
                        String itemurl24 = cs.getString(p24, "itemurl24", getApplicationContext());

                        if (!price24.equals(""))
                        {
                            result24 = Integer.parseInt(price24);
                            c24.setVisibility(View.VISIBLE);
                            cartitemname24.setText(itemname24);
                            cartprice24.setText("₹"+price24);
                            Picasso.get().load(itemurl24).into(cartimage24);
                            del24.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p24, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname25 = cs.getString(p25, "itemname25",getApplicationContext());
                        String price25 = cs.getString(p25, "price25", getApplicationContext());
                        String storeid25 = cs.getString(p25, "storeid25", getApplicationContext());
                        String itemurl25 = cs.getString(p25, "itemurl25", getApplicationContext());

                        if (!price25.equals(""))
                        {
                            result25 = Integer.parseInt(price25);
                            c25.setVisibility(View.VISIBLE);
                            cartitemname25.setText(itemname25);
                            cartprice25.setText("₹"+price25);
                            Picasso.get().load(itemurl25).into(cartimage25);
                            del25.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p25, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname26 = cs.getString(p26, "itemname26",getApplicationContext());
                        String price26 = cs.getString(p26, "price26", getApplicationContext());
                        String storeid26 = cs.getString(p26, "storeid6", getApplicationContext());
                        String itemurl26 = cs.getString(p6, "itemurl6", getApplicationContext());

                        if (!price26.equals(""))
                        {
                            result26 = Integer.parseInt(price26);
                            c26.setVisibility(View.VISIBLE);
                            cartitemname26.setText(itemname26);
                            cartprice6.setText("₹"+price26);
                            Picasso.get().load(itemurl26).into(cartimage26);
                            del26.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p26, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }




                        String itemname27 = cs.getString(p27, "itemname27",getApplicationContext());
                        String price27 = cs.getString(p27, "price27", getApplicationContext());
                        String storeid27 = cs.getString(p27, "storeid27", getApplicationContext());
                        String itemurl27 = cs.getString(p27, "itemurl27", getApplicationContext());

                        if (!price27.equals(""))
                        {
                            result27 = Integer.parseInt(price27);
                            c27.setVisibility(View.VISIBLE);
                            cartitemname27.setText(itemname27);
                            cartprice27.setText("₹"+price27);
                            Picasso.get().load(itemurl27).into(cartimage27);
                            del27.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p27, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }



                        String itemname28 = cs.getString(p28, "itemname28",getApplicationContext());
                        String price28 = cs.getString(p28, "price28", getApplicationContext());
                        String storeid28 = cs.getString(p28, "storeid28", getApplicationContext());
                        String itemurl28 = cs.getString(p28, "itemurl28", getApplicationContext());

                        if (!price28.equals(""))
                        {
                            result28 = Integer.parseInt(price28);
                            c28.setVisibility(View.VISIBLE);
                            cartitemname28.setText(itemname28);
                            cartprice28.setText("₹"+price28);
                            Picasso.get().load(itemurl28).into(cartimage28);
                            del28.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p28, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname29 = cs.getString(p29, "itemname29",getApplicationContext());
                        String price29 = cs.getString(p29, "price29", getApplicationContext());
                        String storeid29 = cs.getString(p29, "storeid29", getApplicationContext());
                        String itemurl29 = cs.getString(p29, "itemurl29", getApplicationContext());

                        if (!price29.equals(""))
                        {
                            result29 = Integer.parseInt(price29);
                            c29.setVisibility(View.VISIBLE);
                            cartitemname29.setText(itemname29);
                            cartprice29.setText("₹"+price29);
                            Picasso.get().load(itemurl29).into(cartimage29);
                            del28.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p29, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname30 = cs.getString(p30, "itemname30",getApplicationContext());
                        String price30 = cs.getString(p30, "price30", getApplicationContext());
                        String storeid30 = cs.getString(p30, "storeid30", getApplicationContext());
                        String itemurl30 = cs.getString(p30, "itemurl30", getApplicationContext());

                        if (!price30.equals(""))
                        {
                            result30 = Integer.parseInt(price30);
                            c30.setVisibility(View.VISIBLE);
                            cartitemname30.setText(itemname30);
                            cartprice30.setText("₹"+price30);
                            Picasso.get().load(itemurl30).into(cartimage30);
                            del30.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p30, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }




                        String itemname31 = cs.getString(p31, "itemname31",getApplicationContext());
                        String price31 = cs.getString(p31, "price31", getApplicationContext());
                        String storeid31 = cs.getString(p31, "storeid31", getApplicationContext());
                        String itemurl31 = cs.getString(p31, "itemurl31", getApplicationContext());

                        if (!price31.equals(""))
                        {
                            result31 = Integer.parseInt(price31);
                            c31.setVisibility(View.VISIBLE);
                            cartitemname31.setText(itemname31);
                            cartprice31.setText("₹"+price31);
                            Picasso.get().load(itemurl31).into(cartimage31);
                            del31.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p31, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });

                        }
                        String itemname32 = cs.getString(p32, "itemname32",getApplicationContext());
                        String price32 = cs.getString(p32, "price32", getApplicationContext());
                        String storeid32 = cs.getString(p32, "storeid32", getApplicationContext());
                        String itemurl32 = cs.getString(p32, "itemurl32", getApplicationContext());

                        if (!price32.equals(""))
                        {
                            result32 = Integer.parseInt(price32);
                            c32.setVisibility(View.VISIBLE);
                            cartitemname32.setText(itemname32);
                            cartprice32.setText("₹"+price32);
                            Picasso.get().load(itemurl32).into(cartimage32);
                            del32.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p32, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }


                        String itemname33 = cs.getString(p33, "itemname33",getApplicationContext());
                        String price33 = cs.getString(p33, "price33", getApplicationContext());
                        String storeid33 = cs.getString(p33, "storeid33", getApplicationContext());
                        String itemurl33 = cs.getString(p33, "itemurl33", getApplicationContext());

                        if (!price33.equals(""))
                        {
                            result33 = Integer.parseInt(price33);
                            c33.setVisibility(View.VISIBLE);
                            cartitemname33.setText(itemname33);
                            cartprice33.setText("₹"+price33);
                            Picasso.get().load(itemurl33).into(cartimage33);
                            del33.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p33, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        String itemname34 = cs.getString(p34, "itemname34",getApplicationContext());
                        String price34 = cs.getString(p34, "price34", getApplicationContext());
                        String storeid34 = cs.getString(p34, "storeid34", getApplicationContext());
                        String itemurl34 = cs.getString(p34, "itemurl34", getApplicationContext());

                        if (!price34.equals(""))
                        {
                            result34 = Integer.parseInt(price34);
                            c34.setVisibility(View.VISIBLE);
                            cartitemname34.setText(itemname34);
                            cartprice34.setText("₹"+price34);
                            Picasso.get().load(itemurl34).into(cartimage34);
                            del34.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p34, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        String itemname35 = cs.getString(p35, "itemname35",getApplicationContext());
                        String price35 = cs.getString(p35, "price35", getApplicationContext());
                        String storeid35 = cs.getString(p35, "storeid35", getApplicationContext());
                        String itemurl35 = cs.getString(p35, "itemurl35", getApplicationContext());

                        if (!price35.equals(""))
                        {
                            result35 = Integer.parseInt(price35);
                            c35.setVisibility(View.VISIBLE);
                            cartitemname35.setText(itemname35);
                            cartprice35.setText("₹"+price35);
                            Picasso.get().load(itemurl35).into(cartimage35);
                            del35.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    cs.RemoveId(p35, getApplicationContext());
                                    Toast.makeText(CheckoutActivity.this,"Item deleted refresh the page ", Toast.LENGTH_LONG).show();
                                }
                            });
                        }

                        int totalprice=result1+result2+result3+result4+result5+result6+result7+result8+result9+result10+
                                result11+result12+result13+result14+result15+result16+result17+result18+result19+result20+
                                result21+result22+result23+result24+result25+result26+result27+result28+result29+result30+
                                result31+result32+result33+result34+result35;
                        String string=String.valueOf(totalprice);
                        total.setText("₹"+string);
                        String totalx=String.valueOf(totalprice);
                        checkout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent setupIntent = new Intent(CheckoutActivity.this, PaymentMode.class);
                                startActivity(setupIntent);
                            }
                        });
                    }
                }
            }
        });
    }

    private void setOrientation(CheckoutActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }
}

