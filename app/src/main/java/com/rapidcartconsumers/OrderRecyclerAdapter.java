package com.rapidcartconsumers;

import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;
import java.util.Locale;

public class OrderRecyclerAdapter extends RecyclerView.Adapter<OrderRecyclerAdapter.ViewHolder> {


    public List<OrderModel> mainList;
    public Context context;
    String user_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private FirebaseAuth mAuth;


    public OrderRecyclerAdapter(List<OrderModel> notifList) {
        this.mainList=notifList;
    }

    @NonNull
    @Override
    public OrderRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mAuth = FirebaseAuth.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
        firebaseFirestore = FirebaseFirestore.getInstance();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orderlayout, parent, false);
        context = parent.getContext();
        return new OrderRecyclerAdapter.ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String shopid=mainList.get(position).getStoreid();
        firebaseFirestore.collection("Owner").document(shopid).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>()
        {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().exists()){
                        String shopname = task.getResult().getString("shopname");
                        String shopphonenumber = task.getResult().getString("shopphonenumber");
                        String address = task.getResult().getString("address");
                        String minimumorderx = task.getResult().getString("minimumorder");
                        String pincodex = task.getResult().getString("pincode");
                        holder.name.setText(shopname);
                        holder.address.setText(address);
                        holder.phonenumber.setText(" "+shopphonenumber);
                        holder.phonenumber.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +shopphonenumber));
                                context.startActivity(intent);

                            }
                        });

                        holder.address.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Uri mapUri = Uri.parse("geo:0,0?q=" + Uri.encode(address));
                                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapUri);
                                mapIntent.setPackage("com.google.android.apps.maps");
                                context.startActivity(mapIntent);
                            }
                        });


                        holder.whatsapp.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Uri uri = Uri.parse("smsto:" + shopphonenumber);
                                Intent i = new Intent(Intent.ACTION_SENDTO, uri);
                                i.setPackage("com.whatsapp");
                                context.startActivity(i);
                            }
                        });


                    }
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {


            }
        });



        String name=mainList.get(position).getName();
        String addresss=mainList.get(position).getAddress();
        String phonenumber=mainList.get(position).getPhonenumber();
        long miliseond=mainList.get(position).getTimestamp().getTime();
        SimpleDateFormat timeZoneDate = new SimpleDateFormat("dd-MM-yy", Locale.getDefault());
        String timeZoneString = timeZoneDate.format(miliseond);
        String total=mainList.get(position).getTotal();
        String orderx=mainList.get(position).getDeliverytype();
        String paymentmode=mainList.get(position).getPaymentmode();
        holder.ordertype.setText(orderx+"\n"+paymentmode);


        String unqid=mainList.get(position).getUniqueid();
        holder.uniqueid.setText("Order ID"+"\n"+unqid);


        if (name!=""&&name!=null&&name!=""&&addresss!=null&&addresss!=""&&phonenumber!=null&&phonenumber!="")
        {

            holder.total.setText("Total : "+total);
            holder.date.setText(timeZoneString);
        }

        String pn1=mainList.get(position).getP1name();
        String p1=mainList.get(position).getP1price();

        String pn2=mainList.get(position).getP2name();
        String p2=mainList.get(position).getP2price();

        String pn3=mainList.get(position).getP3name();
        String p3=mainList.get(position).getP3price();

        String pn4=mainList.get(position).getP4name();
        String p4=mainList.get(position).getP4price();

        String pn5=mainList.get(position).getP5name();
        String p5=mainList.get(position).getP5price();


        String pn6=mainList.get(position).getP6name();
        String p6=mainList.get(position).getP6price();


        String pn7=mainList.get(position).getP7name();
        String p7=mainList.get(position).getP7price();


        String pn8=mainList.get(position).getP8name();
        String p8=mainList.get(position).getP8price();


        String pn9=mainList.get(position).getP9name();
        String p9=mainList.get(position).getP9price();


        String pn10=mainList.get(position).getP10name();
        String p10=mainList.get(position).getP10price();


        String pn11=mainList.get(position).getP11name();
        String p11=mainList.get(position).getP11price();

        String pn12=mainList.get(position).getP12name();
        String p12=mainList.get(position).getP12price();

        String pn13=mainList.get(position).getP13name();
        String p13=mainList.get(position).getP13price();

        String pn14=mainList.get(position).getP14name();
        String p14=mainList.get(position).getP14price();

        String pn15=mainList.get(position).getP15name();
        String p15=mainList.get(position).getP15price();


        String pn16=mainList.get(position).getP16name();
        String p16=mainList.get(position).getP16price();


        String pn17=mainList.get(position).getP17name();
        String p17=mainList.get(position).getP17price();


        String pn18=mainList.get(position).getP18name();
        String p18=mainList.get(position).getP18price();


        String pn19=mainList.get(position).getP19name();
        String p19=mainList.get(position).getP19price();


        String pn20=mainList.get(position).getP20name();
        String p20=mainList.get(position).getP20price();


        String pn21=mainList.get(position).getP21name();
        String p21=mainList.get(position).getP21price();

        String pn22=mainList.get(position).getP22name();
        String p22=mainList.get(position).getP22price();

        String pn23=mainList.get(position).getP23name();
        String p23=mainList.get(position).getP23price();

        String pn24=mainList.get(position).getP24name();
        String p24=mainList.get(position).getP24price();

        String pn25=mainList.get(position).getP25name();
        String p25=mainList.get(position).getP25price();


        String pn26=mainList.get(position).getP26name();
        String p26=mainList.get(position).getP26price();

        String pn27=mainList.get(position).getP27name();
        String p27=mainList.get(position).getP27price();


        String pn28=mainList.get(position).getP28name();
        String p28=mainList.get(position).getP28price();


        String pn29=mainList.get(position).getP29name();
        String p29=mainList.get(position).getP29price();


        String pn30=mainList.get(position).getP30name();
        String p30=mainList.get(position).getP30name();


        String pn31=mainList.get(position).getP31name();
        String p31=mainList.get(position).getP31price();

        String pn32=mainList.get(position).getP32name();
        String p32=mainList.get(position).getP32price();

        String pn33=mainList.get(position).getP33name();
        String p33=mainList.get(position).getP33price();

        String pn34=mainList.get(position).getP34name();
        String p34=mainList.get(position).getP34price();

        String pn35=mainList.get(position).getP35name();
        String p35=mainList.get(position).getP35price();


        if (!pn35.equals("")&&!p35.equals("")&&!pn34.equals("")&&!p34.equals("")&&!pn33.equals("")&&!p33.equals("")&&!pn32.equals("")&&!p32.equals("")&&!pn31.equals("")&&!p31.equals("")
                &&!pn30.equals("")&&!p30.equals("")&&!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {


            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+ pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29+"\n"+pn30+"\n"+pn31+"\n"+pn32+"\n"+pn33 +"\n"+pn34 +"\n"+pn35);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10 +"\n"+p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29+"\n"+p30+"\n"+p31+"\n"+p32+"\n"+p33 +"\n"+p34 +"\n"+p35);

            // seprate item name and price in two text view


        } else if (!pn34.equals("")&&!p34.equals("")&&!pn33.equals("")&&!p33.equals("")&&!pn32.equals("")&&!p32.equals("")&&!pn31.equals("")&&!p31.equals("")
                &&!pn30.equals("")&&!p30.equals("")&&!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29+"\n"+pn30+"\n"+pn31+"\n"+pn32+"\n"+pn33 +"\n"+pn34);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29+"\n"+p30+"\n"+p31+"\n"+p32+"\n"+p33 +"\n"+p34);


        }  else if (!pn33.equals("")&&!p33.equals("")&&!pn32.equals("")&&!p32.equals("")&&!pn31.equals("")&&!p31.equals("")
                &&!pn30.equals("")&&!p30.equals("")&&!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {


            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+ pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29+"\n"+pn30+"\n"+pn31+"\n"+pn32+"\n"+pn33);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29+"\n"+p30+"\n"+p31+"\n"+p32+"\n"+p33);

        } else if (!pn32.equals("")&&!p32.equals("")&&!pn31.equals("")&&!p31.equals("")
                &&!pn30.equals("")&&!p30.equals("")&&!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29+"\n"+pn30+"\n"+pn31+"\n"+pn32 );
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29+"\n"+p30+"\n"+p31+"\n"+p32 );

        }
        else if (!pn31.equals("")&&!p31.equals("")
                &&!pn30.equals("")&&!p30.equals("")&&!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+ pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+ pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29+"\n"+pn30+"\n"+pn31);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29+"\n"+p30+"\n"+p31);

        }
        else if (!pn30.equals("")&&!p30.equals("")&&!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29+"\n"+pn30);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29+"\n"+p30 );


        }

        else if (!pn29.equals("")&&!p29.equals("") &&!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28+"\n"+pn29);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28+"\n"+p29);

        }

        else if (!pn28.equals("")&&!p28.equals("") &&!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27+"\n"+pn28);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27+"\n"+p28);

        }
        else if (!pn27.equals("")&&!p27.equals("")&&!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26+"\n"+pn27);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26+"\n"+p27);

        }

        else if (!pn26.equals("")&&!p26.equals("")&&!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25+"\n"+pn26);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25+"\n"+p26);

        }
        else if (!pn25.equals("")&&!p25.equals("")&&!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24 +"\n"+pn25);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 +"\n"+p25);

        }

        else if (!pn24.equals("")&&!p24.equals("")&&!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23 +"\n"+pn24);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23 +"\n"+p24 );

        }


        else if (!pn23.equals("")&&!p23.equals("")&&!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22+"\n"+pn23);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22+"\n"+p23  );

        }

        else if (!pn22.equals("")&&!p22.equals("")&&!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21+"\n"+pn22);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21+"\n"+p22);

        }


        else if (!pn21.equals("")&&!p21.equals("")
                &&!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20+"\n"+pn21);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20+"\n"+ p21);


        }

        else if (!pn20.equals("")&&!p20.equals("")&&!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19+"\n"+pn20);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19+"\n" +p20);

        }

        else if (!pn19.equals("")&&!p19.equals("") &&!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18+"\n"+pn19);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18+"\n"+p19);

        }


        else if (!pn18.equals("")&&!p18.equals("") &&!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17+"\n"+pn18);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17+"\n"+p18);

        }

        else if (!pn17.equals("")&&!p17.equals("")&&!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16+"\n"+pn17);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16+"\n"+p17);

        }

        else if (!pn16.equals("")&&!p16.equals("")&&!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15+"\n"+pn16);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15+"\n"+p16);

        }

        else if (!pn15.equals("")&&!p15.equals("")&&!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14 +"\n"+pn15);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 +"\n"+p15);

        }


        else if (!pn14.equals("")&&!p14.equals("")&&!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13 +"\n"+pn14);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13 +"\n"+p14 );

        }


        else if (!pn13.equals("")&&!p13.equals("")&&!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12+"\n"+pn13);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12+"\n"+p13);

        }


        else if (!pn12.equals("")&&!p12.equals("")&&!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11+"\n"+pn12);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n" +p11+"\n"+p12);
        }


        else if (!pn11.equals("")&&!p11.equals("")
                &&!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10+"\n"+pn11);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10+"\n"+p11);

        }

        else if (!pn10.equals("")&&!p10.equals("")&&!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9+"\n"+pn10);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9+"\n"+p10);
        }

        else if (!pn9.equals("")&&!p9.equals("") &&!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8+"\n"+pn9);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8+"\n"+p9);
        }

        else if (!pn8.equals("")&&!p8.equals("") &&!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7+"\n"+pn8);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7+"\n"+p8);

        }


        else if (!pn7.equals("")&&!p7.equals("")&&!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6+"\n"+pn7);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6+"\n"+p7);
        }

        else if (!pn6.equals("")&&!p6.equals("")&&!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {

            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5+"\n"+pn6);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5+"\n"+p6);

        }

        else if (!pn5.equals("")&&!p5.equals("")&&!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3 +"\n"+pn4 +"\n"+pn5);
            holder.price.setText(p1+"\n"+p2+"\n"+p3 +"\n"+p4 +"\n"+p5);

        }


        else if (!pn4.equals("")&&!p4.equals("")&&!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3+"\n"+pn4);
            holder.price.setText(p1+"\n"+p2+"\n"+p3+"\n"+p4);

        }


        else if (!pn3.equals("")&&!p3.equals("")&&!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2+"\n"+pn3);
            holder.price.setText(p1+"\n"+p2+"\n"+p3);


        }

        else if (!pn2.equals("")&&!p2.equals("")&&!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1+"\n"+pn2);
            holder.price.setText(p1+"\n"+p2);
        }


        else if (!pn1.equals("")&&!p1.equals("")
        )
        {
            holder.orderitem.setText(pn1);
            holder.orderitem.setText(p1);
        }






    }

    @Override
    public int getItemCount() {
        return mainList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,address,phonenumber,orderitem,total;
        View mView;
        TextView date;
        TextView price;
        TextView ordertype;
        ImageView whatsapp;
        TextView uniqueid;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView=itemView;
            name=mView.findViewById(R.id.textView30);
            address=mView.findViewById(R.id.textView31);
            phonenumber=mView.findViewById(R.id.textView34);
            orderitem=mView.findViewById(R.id.textView33);
            date=mView.findViewById(R.id.textView36);
            total=mView.findViewById(R.id.textView35);
            price=mView.findViewById(R.id.textView39);
            ordertype=mView.findViewById(R.id.textView46);
            whatsapp=mView.findViewById(R.id.imageView4);
            uniqueid=mView.findViewById(R.id.textView38);
        }

    }
}
