package com.example.flower_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Start Button
        Button StartBTN = (Button) findViewById(R.id.Start_Button);
        StartBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("ButtonPressed","StartBtn");

            }
        });

//      View Previous Button
        Button ViewPreviousBTN = (Button) findViewById(R.id.ViewPrevious_Button);
        ViewPreviousBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("ButtonPressed","ViewPreviousBtn");
            }
        });

    }
}
