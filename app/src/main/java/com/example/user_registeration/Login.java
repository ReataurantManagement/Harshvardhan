package com.example.user_registeration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Login extends AppCompatActivity
{
    TextView signUp,resetPassword;
    EditText loginEmail,loginPassword;
    Button loginButton;
    FirebaseAuth firebaseAuth;
    String userEmail,password;


    boolean correct_credentials;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth=FirebaseAuth.getInstance();

        signUp= findViewById(R.id.signUp);
        loginEmail= findViewById(R.id.loginEmail);
        loginPassword= findViewById(R.id.loginPassword);
        loginButton= findViewById((R.id.loginButton));
        resetPassword= findViewById(R.id.resetPassword);


        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null)
        {
            finish();
            startActivity(new Intent(Login.this, Home.class));
        }
        else {
            //on clicking login button

            loginButton.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    if (Validate_Login_Credentials()) {
                        if (check_user_information()) {
                            startActivity(new Intent(Login.this, Home.class));
                        }
                    }

                }
            });

            //if you forget your password

       /* resetPassword.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,ResetPassword.class));
            }
        });*/


            //redirecting to user sign up page
            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Login.this, "Main triggered", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, sign_Up.class));

                }
            });
        }
    }

    private boolean Validate_Login_Credentials()
    {
        boolean field_check=false;
        userEmail=loginEmail.getText().toString();
        password=loginPassword.getText().toString();
        if(userEmail.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this,"Please enter a valid Email and Password ",Toast.LENGTH_SHORT).show();
        }
        else
        {
            field_check=true;
        }
        return field_check;

    }
    public boolean check_user_information()
    {

        firebaseAuth.signInWithEmailAndPassword(userEmail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(Login.this,"Login Successful!!!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this, Home.class));
                    correct_credentials=true;
                }
                else
                {
                    Toast.makeText(Login.this,"Login Not Successful",Toast.LENGTH_SHORT).show();
                    correct_credentials=false;
                }
            }
        });
        return correct_credentials;
    }
}
