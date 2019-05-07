package com.example.flower_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ImageView imageView = (ImageView) findViewById(R.id.displayImage);
        // Retrieve photo from MainActivity
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("photo");
        Bitmap image = BitmapFactory.decodeByteArray(byteArrayExtra, 0, byteArrayExtra.length);
        // Displays photo
        imageView.setImageBitmap(image);
//        Log.d("PhotoTaken","photo displayed");


    }
}