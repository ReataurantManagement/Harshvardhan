package com.example.user_registeration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Choice extends AppCompatActivity {


    FirebaseAuth firebaseAuth;
    Button Feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
        firebaseAuth = FirebaseAuth.getInstance();



         Feedback=(Button)findViewById(R.id.Feedback);
        Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Choice.this,Feedback.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.logout:
                logout();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void logout()
    {
        firebaseAuth.signOut();
        Toast.makeText(Choice.this,"Logout Successful!!!",Toast.LENGTH_SHORT).show();
        finish();
        startActivity(new Intent(Choice.this,MainActivity.class));
    }
}

