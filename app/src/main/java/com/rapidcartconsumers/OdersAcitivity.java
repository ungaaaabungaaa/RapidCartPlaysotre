package com.rapidcartconsumers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class OdersAcitivity extends AppCompatActivity {

    String user_id;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;
    private OrderRecyclerAdapter notificationsAdapterx;
    private List<OrderModel> NotifListx;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oders_acitivity);
        setOrientation(OdersAcitivity.this);
        constraintLayout=findViewById(R.id.noroderlayout);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        user_id = firebaseAuth.getCurrentUser().getUid();
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
                    }
                }
            }
        });

        NotifListx = new ArrayList<>();
        RecyclerView notificationList = findViewById(R.id.fruits);
        notificationsAdapterx = new OrderRecyclerAdapter(NotifListx);
        notificationList.setHasFixedSize(true);
        notificationList.setItemViewCacheSize(20);
        notificationList.setDrawingCacheEnabled(true);
        notificationList.setItemAnimator(null);
        notificationList.setNestedScrollingEnabled(false);
        notificationList.setLayoutManager(new LinearLayoutManager(this));
        notificationList.setAdapter(notificationsAdapterx);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection(user_id+"orders").orderBy("timestamp", Query.Direction.DESCENDING).addSnapshotListener(this, new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                for(DocumentChange doc: documentSnapshots.getDocumentChanges()) {
                    OrderModel notifications = doc.getDocument().toObject(OrderModel.class);
                    NotifListx.add(notifications);
                    notificationsAdapterx.notifyDataSetChanged();
                }
            }
        });


        firebaseFirestore.collection(user_id+"orders").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (!documentSnapshots.isEmpty()) {
                    int count = documentSnapshots.size();
                    notificationList.setVisibility(View.VISIBLE);

                } else if (documentSnapshots.isEmpty())
                {
                    constraintLayout.setVisibility(View.VISIBLE);
                    notificationList.setVisibility(View.INVISIBLE);
                    Toast.makeText(OdersAcitivity.this, "No Orders Placed", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void setOrientation(OdersAcitivity context) {
        if (android.os.Build.VERSION.SDK_INT == Build.VERSION_CODES.O)
        {
            context.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

}