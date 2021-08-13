package com.rapidcartconsumers;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.review.model.ReviewErrorCode;
import com.google.android.play.core.tasks.Task;


public class TestActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ReviewManager manager = ReviewManagerFactory.create(TestActivity.this);
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                ReviewInfo reviewInfo = task.getResult();


                Task<Void> flow = manager.launchReviewFlow(TestActivity.this, reviewInfo);
                flow.addOnCompleteListener(task2 -> {

                    Toast.makeText(TestActivity.this, "Review done", Toast.LENGTH_LONG).show();

                });


            } else {
                // There was some problem, log or handle the error code.
                Toast.makeText(TestActivity.this,"Error", Toast.LENGTH_LONG).show();
            }
        });


    }


}