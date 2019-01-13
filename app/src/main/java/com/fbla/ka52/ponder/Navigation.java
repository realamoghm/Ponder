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

public class Navigation extends AppCompatActivity {

    Button settingsbtn,infobtn,bugreportbtn,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        settingsbtn = (Button) findViewById(R.id.settings);
        settingsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Settings.class));
            }
        });

        bugreportbtn = (Button) findViewById(R.id.bug_report);
        bugreportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,bug_report.class));
            }
        });

        infobtn = (Button) findViewById(R.id.info);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Info.class));
            }
        });

        back = (Button) findViewById(R.id.backog);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Navigation.this,Options.class));
            }
        });

    }
}
