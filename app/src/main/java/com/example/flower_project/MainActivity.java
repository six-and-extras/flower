package com.example.flower_project;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private static final int CAMERA_REQUEST = 1888; // Define magic number


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Start Button
        Button StartBTN = (Button) findViewById(R.id.Start_Button);
        StartBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Log.d("ButtonPressed","Start Camera");
                Intent cameraActivity = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(cameraActivity,CAMERA_REQUEST);
            }
        });


//      View Previous Button
        Button ViewPreviousBTN = (Button) findViewById(R.id.ViewPrevious_Button);
        ViewPreviousBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("ButtonPressed","ViewPreviousBtn");
                Intent viewPrevious = new Intent(MainActivity.this, ViewPreviousActivity.class);
                startActivity(viewPrevious);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        Log.d("PhotoTaken","photo taken");
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            // Convert photo to bitmap and pass to ResultsActivity
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.PNG, 90, stream);
            byte[] image = stream.toByteArray();
            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("photo", image);
            startActivity(intent);
//            Log.d("PhotoTaken","sent to resultsActivity");

        } else { Log.d("PhotoTaken", "bugged"); }

    }

}
