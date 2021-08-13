package com.rapidcartconsumers;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.carteasy.v1.lib.Carteasy;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class FruitsActivity extends AppCompatActivity {

    ImageView imageView;
    String user_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;
    private FruitsRecyclerAdapter notificationsAdapterx;
    private List<MainModel> NotifListx;


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


    ImageView cartimage1,cartimage2,cartimage3,cartimage4,cartimage5,cartimage6,cartimage7,cartimage8,cartimage9,cartimage10;
    ImageView cartimage11,cartimage12,cartimage13,cartimage14,cartimage15,cartimage16,cartimage17,cartimage18,cartimage19,cartimage20;
    ImageView cartimage21,cartimage22,cartimage23,cartimage24,cartimage25,cartimage26,cartimage27,cartimage28,cartimage29,cartimage30;
    ImageView cartimage31,cartimage32,cartimage33,cartimage34,cartimage35;

    ConstraintLayout c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    ConstraintLayout c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
    ConstraintLayout c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
    ConstraintLayout c31,c32,c33,c34,c35;

    SearchView searchView;
    String pinxsearchx;
    String shopidseachx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        TextView cart =findViewById(R.id.textView15);
        setOrientation(FruitsActivity.this);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setupIntent = new Intent(FruitsActivity.this, CheckoutActivity.class);
                startActivity(setupIntent);
            }
        });
        Carteasy cs = new Carteasy();
        searchView = findViewById(R.id.search_field);
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
        mAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        imageView=findViewById(R.id.imageView19);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // load fruit pic and prices from that store id

        Bundle bundle2 = getIntent().getExtras();
        if (bundle2 != null) {
            String shopid = bundle2.get("shopid").toString();
            firebaseFirestore.collection("Users").document(user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
            {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        if(task.getResult().exists()){
                            String namex = task.getResult().getString("name");
                            String phonenumberx = task.getResult().getString("Phonenumber");
                            String addressx = task.getResult().getString("address");
                            String pincodex = task.getResult().getString("pincode");
                            loaddata(pincodex,shopid);
                            pinxsearchx=pincodex;
                            shopidseachx=shopid;


                        }
                    }
                }
            });
        }

        // load cart items


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query,pinxsearchx,shopidseachx);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText,pinxsearchx,shopidseachx);
                return false;
            }
        });

        String itemname1 = cs.getString(p1, "itemname1",getApplicationContext());
        String price1 = cs.getString(p1, "price1", getApplicationContext());
        String storeid1 = cs.getString(p1, "storeid1", getApplicationContext());
        String itemurl1 = cs.getString(p1, "itemurl1", getApplicationContext());

        if (!itemurl1.equals(""))
        {
            Picasso.get().load(itemurl1).into(cartimage1);
            c1.setVisibility(View.VISIBLE);
        }


        String itemname2 = cs.getString(p2, "itemname2",getApplicationContext());
        String price2 = cs.getString(p2, "price2", getApplicationContext());
        String storeid2 = cs.getString(p2, "storeid2", getApplicationContext());
        String itemurl2 = cs.getString(p2, "itemurl2", getApplicationContext());

        if (!itemurl2.equals(""))
        {
            Picasso.get().load(itemurl2).into(cartimage2);
            c2.setVisibility(View.VISIBLE);
        }

        String itemname3 = cs.getString(p3, "itemname3",getApplicationContext());
        String price3 = cs.getString(p3, "price3", getApplicationContext());
        String storeid3 = cs.getString(p3, "storeid3", getApplicationContext());
        String itemurl3 = cs.getString(p3, "itemurl3", getApplicationContext());

        if (!itemurl3.equals(""))
        {
            Picasso.get().load(itemurl3).into(cartimage3);
            c3.setVisibility(View.VISIBLE);
        }




        String itemname4 = cs.getString(p4, "itemname4",getApplicationContext());
        String price4 = cs.getString(p4, "price4", getApplicationContext());
        String storeid4 = cs.getString(p4, "storeid4", getApplicationContext());
        String itemurl4 = cs.getString(p4, "itemurl4", getApplicationContext());


        if (!itemurl4.equals(""))
        {
            Picasso.get().load(itemurl4).into(cartimage4);
            c4.setVisibility(View.VISIBLE);
        }

        String itemname5 = cs.getString(p5, "itemname5",getApplicationContext());
        String price5 = cs.getString(p5, "price5", getApplicationContext());
        String storeid5 = cs.getString(p5, "storeid5", getApplicationContext());
        String itemurl5 = cs.getString(p5, "itemurl5", getApplicationContext());


        if (!itemurl5.equals(""))
        {
            Picasso.get().load(itemurl5).into(cartimage5);
            c5.setVisibility(View.VISIBLE);
        }



        String itemname6 = cs.getString(p6, "itemname6",getApplicationContext());
        String price6 = cs.getString(p6, "price6", getApplicationContext());
        String storeid6 = cs.getString(p6, "storeid6", getApplicationContext());
        String itemurl6 = cs.getString(p6, "itemurl6", getApplicationContext());


        if (!itemurl6.equals(""))
        {
            Picasso.get().load(itemurl6).into(cartimage6);
            c6.setVisibility(View.VISIBLE);
        }


        String itemname7 = cs.getString(p7, "itemname7",getApplicationContext());
        String price7 = cs.getString(p7, "price7", getApplicationContext());
        String storeid7 = cs.getString(p7, "storeid7", getApplicationContext());
        String itemurl7 = cs.getString(p7, "itemurl7", getApplicationContext());


        if (!itemurl7.equals(""))
        {
            Picasso.get().load(itemurl7).into(cartimage7);
            c7.setVisibility(View.VISIBLE);
        }

        String itemname8 = cs.getString(p8, "itemname8",getApplicationContext());
        String price8 = cs.getString(p8, "price8", getApplicationContext());
        String storeid8 = cs.getString(p8, "storeid8", getApplicationContext());
        String itemurl8 = cs.getString(p8, "itemurl8", getApplicationContext());


        if (!itemurl8.equals(""))
        {
            Picasso.get().load(itemurl8).into(cartimage8);
            c8.setVisibility(View.VISIBLE);
        }

        String itemname9 = cs.getString(p9, "itemname9",getApplicationContext());
        String price9 = cs.getString(p9, "price9", getApplicationContext());
        String storeid9 = cs.getString(p9, "storeid9", getApplicationContext());
        String itemurl9 = cs.getString(p9, "itemurl9", getApplicationContext());


        if (!itemurl9.equals(""))
        {
            Picasso.get().load(itemurl9).into(cartimage9);
            c9.setVisibility(View.VISIBLE);
        }

        String itemname10 = cs.getString(p10, "itemname10",getApplicationContext());
        String price10 = cs.getString(p10, "price10", getApplicationContext());
        String storeid10 = cs.getString(p10, "storeid10", getApplicationContext());
        String itemurl10 = cs.getString(p10, "itemurl10", getApplicationContext());

        if (!itemurl10.equals(""))
        {
            Picasso.get().load(itemurl10).into(cartimage10);
            c10.setVisibility(View.VISIBLE);
        }


        String itemname11 = cs.getString(p11, "itemname11",getApplicationContext());
        String price11 = cs.getString(p11, "price11", getApplicationContext());
        String storeid11 = cs.getString(p11, "storeid11", getApplicationContext());
        String itemurl11 = cs.getString(p11, "itemurl11", getApplicationContext());


        if (!itemurl11.equals(""))
        {
            Picasso.get().load(itemurl11).into(cartimage11);
            c11.setVisibility(View.VISIBLE);
        }

        String itemname12 = cs.getString(p12, "itemname12",getApplicationContext());
        String price12 = cs.getString(p12, "price12", getApplicationContext());
        String storeid12 = cs.getString(p12, "storeid12", getApplicationContext());
        String itemurl12 = cs.getString(p12, "itemurl12", getApplicationContext());


        if (!itemurl12.equals(""))
        {
            Picasso.get().load(itemurl12).into(cartimage12);
            c12.setVisibility(View.VISIBLE);
        }


        String itemname13 = cs.getString(p13, "itemname13",getApplicationContext());
        String price13 = cs.getString(p13, "price13", getApplicationContext());
        String storeid13 = cs.getString(p13, "storeid13", getApplicationContext());
        String itemurl13 = cs.getString(p13, "itemurl13", getApplicationContext());


        if (!itemurl13.equals(""))
        {
            Picasso.get().load(itemurl13).into(cartimage13);
            c13.setVisibility(View.VISIBLE);
        }

        String itemname14 = cs.getString(p14, "itemname14",getApplicationContext());
        String price14 = cs.getString(p14, "price14", getApplicationContext());
        String storeid14 = cs.getString(p14, "storeid14", getApplicationContext());
        String itemurl14 = cs.getString(p14, "itemurl14", getApplicationContext());


        if (!itemurl14.equals(""))
        {
            Picasso.get().load(itemurl14).into(cartimage14);
            c14.setVisibility(View.VISIBLE);
        }


        String itemname15 = cs.getString(p15, "itemname15",getApplicationContext());
        String price15 = cs.getString(p15, "price15", getApplicationContext());
        String storeid15 = cs.getString(p15, "storeid15", getApplicationContext());
        String itemurl15 = cs.getString(p15, "itemurl15", getApplicationContext());


        if (!itemurl15.equals(""))
        {
            Picasso.get().load(itemurl15).into(cartimage15);
            c15.setVisibility(View.VISIBLE);
        }




        String itemname16 = cs.getString(p16, "itemname16",getApplicationContext());
        String price16 = cs.getString(p16, "price16", getApplicationContext());
        String storeid16 = cs.getString(p16, "storeid16", getApplicationContext());
        String itemurl16 = cs.getString(p16, "itemurl16", getApplicationContext());


        if (!itemurl16.equals(""))
        {
            Picasso.get().load(itemurl16).into(cartimage16);
            c16.setVisibility(View.VISIBLE);
        }


        String itemname17 = cs.getString(p17, "itemname17",getApplicationContext());
        String price17 = cs.getString(p17, "price17", getApplicationContext());
        String storeid17 = cs.getString(p17, "storeid17", getApplicationContext());
        String itemurl17 = cs.getString(p17, "itemurl17", getApplicationContext());


        if (!itemurl17.equals(""))
        {
            Picasso.get().load(itemurl17).into(cartimage17);
            c17.setVisibility(View.VISIBLE);
        }


        String itemname18 = cs.getString(p18, "itemname18",getApplicationContext());
        String price18 = cs.getString(p18, "price18", getApplicationContext());
        String storeid18 = cs.getString(p18, "storeid18", getApplicationContext());
        String itemurl18 = cs.getString(p18, "itemurl18", getApplicationContext());


        if (!itemurl18.equals(""))
        {
            Picasso.get().load(itemurl18).into(cartimage18);
            c18.setVisibility(View.VISIBLE);
        }

        String itemname19 = cs.getString(p19, "itemname19",getApplicationContext());
        String price19 = cs.getString(p19, "price19", getApplicationContext());
        String storeid19 = cs.getString(p19, "storeid19", getApplicationContext());
        String itemurl19 = cs.getString(p19, "itemurl19", getApplicationContext());


        if (!itemurl19.equals(""))
        {
            Picasso.get().load(itemurl19).into(cartimage19);
            c19.setVisibility(View.VISIBLE);
        }


        String itemname20 = cs.getString(p20, "itemname20",getApplicationContext());
        String price20 = cs.getString(p20, "price20", getApplicationContext());
        String storeid20 = cs.getString(p20, "storeid20", getApplicationContext());
        String itemurl20 = cs.getString(p20, "itemurl20", getApplicationContext());


        if (!itemurl20.equals(""))
        {
            Picasso.get().load(itemurl20).into(cartimage20);
            c20.setVisibility(View.VISIBLE);
        }


        String itemname21 = cs.getString(p21, "itemname21",getApplicationContext());
        String price21 = cs.getString(p21, "price21", getApplicationContext());
        String storeid21 = cs.getString(p21, "storeid21", getApplicationContext());
        String itemurl21 = cs.getString(p21, "itemurl21", getApplicationContext());


        if (!itemurl21.equals(""))
        {
            Picasso.get().load(itemurl21).into(cartimage21);
            c21.setVisibility(View.VISIBLE);
        }



        String itemname22 = cs.getString(p22, "itemname22",getApplicationContext());
        String price22 = cs.getString(p22, "price22", getApplicationContext());
        String storeid22 = cs.getString(p22, "storeid22", getApplicationContext());
        String itemurl22 = cs.getString(p22, "itemurl22", getApplicationContext());

        if (!itemurl22.equals(""))
        {
            Picasso.get().load(itemurl22).into(cartimage22);
            c22.setVisibility(View.VISIBLE);
        }



        String itemname23 = cs.getString(p23, "itemname23",getApplicationContext());
        String price23 = cs.getString(p23, "price23", getApplicationContext());
        String storeid23 = cs.getString(p23, "storeid23", getApplicationContext());
        String itemurl23 = cs.getString(p23, "itemurl23", getApplicationContext());


        if (!itemurl23.equals(""))
        {
            Picasso.get().load(itemurl23).into(cartimage23);
            c23.setVisibility(View.VISIBLE);
        }


        String itemname24 = cs.getString(p24, "itemname24",getApplicationContext());
        String price24 = cs.getString(p24, "price24", getApplicationContext());
        String storeid24 = cs.getString(p24, "storeid24", getApplicationContext());
        String itemurl24 = cs.getString(p24, "itemurl24", getApplicationContext());


        if (!itemurl24.equals(""))
        {
            Picasso.get().load(itemurl24).into(cartimage24);
            c24.setVisibility(View.VISIBLE);
        }


        String itemname25 = cs.getString(p25, "itemname25",getApplicationContext());
        String price25 = cs.getString(p25, "price25", getApplicationContext());
        String storeid25 = cs.getString(p25, "storeid25", getApplicationContext());
        String itemurl25 = cs.getString(p25, "itemurl25", getApplicationContext());


        if (!itemurl25.equals(""))
        {
            Picasso.get().load(itemurl25).into(cartimage25);
            c25.setVisibility(View.VISIBLE);
        }



        String itemname26 = cs.getString(p26, "itemname26",getApplicationContext());
        String price26 = cs.getString(p26, "price26", getApplicationContext());
        String storeid26 = cs.getString(p26, "storeid6", getApplicationContext());
        String itemurl26 = cs.getString(p6, "itemurl6", getApplicationContext());

        if (!itemurl26.equals(""))
        {
            Picasso.get().load(itemurl26).into(cartimage26);
            c26.setVisibility(View.VISIBLE);
        }





        String itemname27 = cs.getString(p27, "itemname27",getApplicationContext());
        String price27 = cs.getString(p27, "price27", getApplicationContext());
        String storeid27 = cs.getString(p27, "storeid27", getApplicationContext());
        String itemurl27 = cs.getString(p27, "itemurl27", getApplicationContext());


        if (!itemurl27.equals(""))
        {
            Picasso.get().load(itemurl27).into(cartimage27);
            c27.setVisibility(View.VISIBLE);
        }


        String itemname28 = cs.getString(p28, "itemname28",getApplicationContext());
        String price28 = cs.getString(p28, "price28", getApplicationContext());
        String storeid28 = cs.getString(p28, "storeid28", getApplicationContext());
        String itemurl28 = cs.getString(p28, "itemurl28", getApplicationContext());


        if (!itemurl28.equals(""))
        {
            Picasso.get().load(itemurl28).into(cartimage28);
            c28.setVisibility(View.VISIBLE);
        }


        String itemname29 = cs.getString(p29, "itemname29",getApplicationContext());
        String price29 = cs.getString(p29, "price29", getApplicationContext());
        String storeid29 = cs.getString(p29, "storeid29", getApplicationContext());
        String itemurl29 = cs.getString(p29, "itemurl29", getApplicationContext());


        if (!itemurl29.equals(""))
        {
            Picasso.get().load(itemurl29).into(cartimage29);
            c29.setVisibility(View.VISIBLE);
        }


        String itemname30 = cs.getString(p30, "itemname30",getApplicationContext());
        String price30 = cs.getString(p30, "price30", getApplicationContext());
        String storeid30 = cs.getString(p30, "storeid30", getApplicationContext());
        String itemurl30 = cs.getString(p30, "itemurl30", getApplicationContext());


        if (!itemurl30.equals(""))
        {
            Picasso.get().load(itemurl30).into(cartimage30);
            c30.setVisibility(View.VISIBLE);
        }




        String itemname31 = cs.getString(p31, "itemname31",getApplicationContext());
        String price31 = cs.getString(p31, "price31", getApplicationContext());
        String storeid31 = cs.getString(p31, "storeid31", getApplicationContext());
        String itemurl31 = cs.getString(p31, "itemurl31", getApplicationContext());


        if (!itemurl31.equals(""))
        {
            Picasso.get().load(itemurl31).into(cartimage31);
            c31.setVisibility(View.VISIBLE);
        }

        String itemname32 = cs.getString(p32, "itemname32",getApplicationContext());
        String price32 = cs.getString(p32, "price32", getApplicationContext());
        String storeid32 = cs.getString(p32, "storeid32", getApplicationContext());
        String itemurl32 = cs.getString(p32, "itemurl32", getApplicationContext());


        if (!itemurl32.equals(""))
        {
            Picasso.get().load(itemurl32).into(cartimage32);
            c32.setVisibility(View.VISIBLE);
        }


        String itemname33 = cs.getString(p33, "itemname33",getApplicationContext());
        String price33 = cs.getString(p33, "price33", getApplicationContext());
        String storeid33 = cs.getString(p33, "storeid33", getApplicationContext());
        String itemurl33 = cs.getString(p33, "itemurl33", getApplicationContext());


        if (!itemurl33.equals(""))
        {
            Picasso.get().load(itemurl33).into(cartimage33);
            c33.setVisibility(View.VISIBLE);
        }



        String itemname34 = cs.getString(p34, "itemname34",getApplicationContext());
        String price34 = cs.getString(p34, "price34", getApplicationContext());
        String storeid34 = cs.getString(p34, "storeid34", getApplicationContext());
        String itemurl34 = cs.getString(p34, "itemurl34", getApplicationContext());


        if (!itemurl34.equals(""))
        {
            Picasso.get().load(itemurl34).into(cartimage34);
            c34.setVisibility(View.VISIBLE);
        }


        String itemname35 = cs.getString(p35, "itemname35",getApplicationContext());
        String price35 = cs.getString(p35, "price35", getApplicationContext());
        String storeid35 = cs.getString(p35, "storeid35", getApplicationContext());
        String itemurl35 = cs.getString(p35, "itemurl35", getApplicationContext());


        if (!itemurl35.equals(""))
        {
            Picasso.get().load(itemurl35).into(cartimage35);
            c35.setVisibility(View.VISIBLE);
        }

    }






    // load pics and data into recycler view

    private void loaddata(String pincodex, String shopid) {
        NotifListx = new ArrayList<>();
        RecyclerView notificationList = findViewById(R.id.fruits);
        notificationsAdapterx = new FruitsRecyclerAdapter(NotifListx);
        notificationList.setHasFixedSize(true);
        notificationList.setItemViewCacheSize(20);
        notificationList.setDrawingCacheEnabled(true);
        notificationList.setItemAnimator(null);
        notificationList.setNestedScrollingEnabled(false);
        notificationList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        notificationList.setAdapter(notificationsAdapterx);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection(pincodex+shopid+"fruits").addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()) {

                    MainModel notifications = doc.getDocument().toObject(MainModel.class);
                    NotifListx.add(notifications);
                    notificationsAdapterx.notifyDataSetChanged();

                }
            }
        });
    }



    private void firebaseSearch(String searchText,String pincodex, String shopid) {
        NotifListx.clear();
        String query = searchText.toLowerCase();
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection(pincodex+shopid+"fruits").orderBy("itemname").startAt(query).endAt(query +"\uf8ff").limit(5).addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                for (DocumentChange doc : documentSnapshots.getDocumentChanges()) {
                    if (doc.getType() == DocumentChange.Type.ADDED) {
                        MainModel notifications = doc.getDocument().toObject(MainModel.class);
                        NotifListx.add(notifications);
                        notificationsAdapterx.notifyDataSetChanged();
                    }
                }
            }
        });
    }


    private void setOrientation(FruitsActivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }


}