package com.fbla.ka52.ponder;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class quiz2 extends AppCompatActivity {

    Button b1, b2, b3, b4;
    TextView t1_question;
    TextView mScoreView;
    private int QuestionNumber = 0;
    private int mScore = 0;
    private String answer;
    Handler handler = new Handler();

    private Firebase mQuestionRef, mChoice1Ref, mChoice2Ref, mChoice3Ref, mChoice4Ref, mAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

        b1 = findViewById(R.id.choicea1);
        b2 = findViewById(R.id.choiceb1);
        b3 = findViewById(R.id.choicec1);
        b4 = findViewById(R.id.choiced1);

        t1_question = findViewById(R.id.textViewq2);
        mScoreView = findViewById(R.id.scoreq2);

        updateQuestion();
        //1
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.getText().equals(answer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                    b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    updateQuestion();
                } else {
                    b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    if (b2.getText().equals(answer)){
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b3.getText().equals(answer)){
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b4.getText().equals(answer)){
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }
                    updateQuestion();
                }
            }
        });
        //2
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b2.getText().equals(answer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                    b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    updateQuestion();
                } else {
                    b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    if (b4.getText().equals(answer)){
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b3.getText().equals(answer)){
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b1.getText().equals(answer)){
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }
                    updateQuestion();
                }
            }
        });
        //3
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b3.getText().equals(answer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                    b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    updateQuestion();
                } else {
                    b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    if (b2.getText().equals(answer)){
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b4.getText().equals(answer)){
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b1.getText().equals(answer)){
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }                    updateQuestion();
                }
            }
        });
        //4
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b4.getText().equals(answer)) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                    b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                    b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    updateQuestion();
                } else {
                    b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    if (b2.getText().equals(answer)){
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b3.getText().equals(answer)){
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }else if(b1.getText().equals(answer)){
                        b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#41c300")));
                        b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));
                        b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#ff210c")));

                    }

                    updateQuestion();
                }
            }
        });
    }


    private void updateScore(int score) {
        mScoreView.setText("" + mScore);
    }

    private void updateQuestion() {
        if(mScore>=10||(QuestionNumber==10 && mScore<=9))
        {
            Intent k = new Intent(this,Results.class);
            k.putExtra("Score",mScore);
            startActivity(k);
        }
        else {

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    b1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    b2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    b3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    b4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));


                    for(int i = 0; i<10;i++)
                        mQuestionRef = new Firebase("https://ponder-d9c31.firebaseio.com/Parli Pro/" + QuestionNumber + "/question");
                    mQuestionRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String question = String.valueOf(dataSnapshot.getValue());
                            t1_question.setText(question);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    mChoice1Ref = new Firebase("https://ponder-d9c31.firebaseio.com/Parli Pro/" + QuestionNumber + "/choice1");
                    mChoice1Ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String choice = String.valueOf(dataSnapshot.getValue());
                            b1.setText(choice);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    mChoice2Ref = new Firebase("https://ponder-d9c31.firebaseio.com/Parli Pro/" + QuestionNumber + "/choice2");
                    mChoice2Ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String choice = String.valueOf(dataSnapshot.getValue());
                            b2.setText(choice);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    mChoice3Ref = new Firebase("https://ponder-d9c31.firebaseio.com/Parli Pro/" + QuestionNumber + "/choice3");
                    mChoice3Ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String choice = String.valueOf(dataSnapshot.getValue());
                            b3.setText(choice);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    mChoice4Ref = new Firebase("https://ponder-d9c31.firebaseio.com/Parli Pro/" + QuestionNumber + "/choice4");
                    mChoice4Ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String choice = String.valueOf(dataSnapshot.getValue());
                            b4.setText(choice);
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                    mAnswerRef = new Firebase("https://ponder-d9c31.firebaseio.com/Parli Pro/" + QuestionNumber + "/answer");
                    mAnswerRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            answer = String.valueOf(dataSnapshot.getValue());
                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {
                        }
                    });
                    QuestionNumber++;
                }
            }, 1500);


        }
    }


}



