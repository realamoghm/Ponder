/*
 * Copyright (c) 2019
 * All rights reserved Kevin Antony, Amogh Mehta, Amit Ashok
 */

package com.fbla.ka52.ponder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class bug_report extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    FirebaseAuth auth;
    DatabaseReference databaseReference;

    String info,User,Email,Bug,Feedback;

    EditText usernametxt,emailtxt,bugtxt,feedbacktxt;

    Button submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_report);

        auth = FirebaseAuth.getInstance();
        info = Objects.requireNonNull(auth.getCurrentUser()).getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Bugs");

        usernametxt = (EditText) findViewById(R.id.username);
        emailtxt = (EditText) findViewById(R.id.email);
        bugtxt = (EditText) findViewById(R.id.bug);
        feedbacktxt = (EditText) findViewById(R.id.feedback);

        submitbtn = (Button) findViewById(R.id.submit);

        final Firebase mFirebaseRef = new Firebase("https://ponder-d9c31.firebaseio.com/Bugs/");

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFirebaseRef.child("Username").push().setValue(usernametxt.getText().toString());
                mFirebaseRef.child("Email").push().setValue(emailtxt.getText().toString());
                mFirebaseRef.child("Bug").push().setValue(bugtxt.getText().toString());
                mFirebaseRef.child("Feedback").push().setValue(feedbacktxt.getText().toString());
                Toast.makeText(bug_report.this,"THANK YOU FOR YOUR FEEDBACK",Toast.LENGTH_SHORT);
                startActivity(new Intent(bug_report.this,Navigation.class));
            }
        });





    }
}
