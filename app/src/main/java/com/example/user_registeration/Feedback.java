package com.example.user_registeration;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Feedback extends AppCompatActivity
{
    RatingBar parking,cordialty,quality,appeal,taste,ambience,comfort,hygiene;
    EditText extraFeedback;
    Button submitFeedback;
    FirebaseDatabase database;
    FirebaseAuth firebaseAuth;
    DatabaseReference myRef;
    float vparking,vcordialty,vquality,vappeal,vtaste,vambience,vcomfort,vhygiene;
    String vextraFeedback;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Feedback_Restaurant_Variables();


        parking.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vparking=ratingBar.getRating();

            }
        });
        comfort.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vcomfort=ratingBar.getRating();

            }
        });
        cordialty.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vcordialty=ratingBar.getRating();

            }
        });
        hygiene.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vhygiene=ratingBar.getRating();

            }
        });
        quality.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vquality=ratingBar.getRating();

            }
        });
        ambience.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vambience=ratingBar.getRating();

            }
        });
        appeal.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vappeal=ratingBar.getRating();

            }
        });
        taste.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                vtaste=ratingBar.getRating();

            }
        });
       submitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Send_Feedback();
                Toast.makeText(Feedback.this,"Upload Complete",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(Feedback.this,Choice.class));

         }});
       vextraFeedback=extraFeedback.getText().toString();

       }


    private void Feedback_Restaurant_Variables()
    {
       parking=(RatingBar) findViewById(R.id.ratingBarParking);
        cordialty=(RatingBar)findViewById(R.id.ratingBarCordial);
        quality=(RatingBar)findViewById(R.id.ratingBarQuality);
        appeal=(RatingBar)findViewById(R.id.ratingBarAppeal);
        taste=(RatingBar)findViewById(R.id.ratingBarTaste);
        ambience=(RatingBar)findViewById(R.id.ratingBarAmbience);
        comfort=(RatingBar)findViewById(R.id.ratingBarComfort);
        hygiene=(RatingBar)findViewById(R.id.ratingBarHygiene);
        extraFeedback=(EditText)findViewById(R.id.extraFeedback);
        submitFeedback=(Button)findViewById(R.id.buttonSubmit);

    }



    private void Send_Feedback()
    {
        Data_To_Database ratings=new Data_To_Database(vparking,vcordialty,vquality,vappeal,vtaste,vambience,vcomfort,vhygiene,vextraFeedback);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        myRef.child("Ratings").push().setValue(ratings);
    }


}
