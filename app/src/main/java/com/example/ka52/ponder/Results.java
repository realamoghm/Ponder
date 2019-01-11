package com.example.ka52.ponder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Results extends AppCompatActivity {
    TextView t2;
    TextView t3;
    Button facebook, google, ig , home;
    DatabaseReference databaseReference;
    String score, uid;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        auth = FirebaseAuth.getInstance();
        uid = auth.getCurrentUser().getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Scores");

        home = findViewById(R.id.button5);

        int finalScore = getIntent().getIntExtra("Score",0);

        t2.setText(String.valueOf(finalScore));

        finalScore = finalScore+5;

        t3.setText(String.valueOf(finalScore));

        score = t3.getText().toString().trim();

        databaseReference.child(uid).child("Score").setValue(score);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Results.this, Options.class));
            }
        });


    }
}
