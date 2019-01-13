/*
 * Copyright (c) 2019
 * All rights reserved Kevin Antony, Amogh Mehta, Amit Ashok
 */

package com.fbla.ka52.ponder;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText t1,t2;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        t1 = findViewById(R.id.editText3);
        t2 = findViewById(R.id.editText4);
        b1 = (Button) findViewById(R.id.button122);
        mAuth = FirebaseAuth.getInstance();
    }
    public void btnUserLogin_Click(View v){
        final ProgressDialog progressDialog = ProgressDialog.show(SignIn.this,"Please Wait...","Processing...",true);

        (mAuth.signInWithEmailAndPassword(t1.getText().toString(),t2.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(SignIn.this, "Login Successful", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SignIn.this,Options.class);
                            startActivity(intent);
                        }
                            else{
                                Toast.makeText(SignIn.this,"Login Failed",Toast.LENGTH_LONG).show();
                            }
                        }
                });
    }

}
