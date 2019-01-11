package com.example.ka52.ponder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    TextView t1;
    TextView t2;
    Button registerBtn;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        t1 = findViewById(R.id.editText);
        t2 = findViewById(R.id.editText2);

        registerBtn = (Button) findViewById(R.id.registerBTN);

        mAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });


    }
    public void createUser() {
        String email = t1.getText().toString();
        String password = t2.getText().toString();

        if (email.isEmpty()){
            t1.setError("An email is required");
            return;
        }
        if (password.isEmpty()){
            t2.setError("A password is required");
            return;
        }
        if (password.length() < 6){
            t2.setError("Password must length must be 6 or more");
            return;
        }
        if (!isEmailValid(email)){
            t1.setError("Must be a valid email");
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            startActivity(new Intent(Register.this, Options.class));
                        }else{
                            Toast.makeText(Register.this, "Something Unexpected has occured. Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}