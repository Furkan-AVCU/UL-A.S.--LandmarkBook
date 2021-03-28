package com.furkanavcu.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//import static com.furkanavcu.landmarkbook.MainActivity.selectedImage;

public class    DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.imageView);
        TextView landmarkNameText = findViewById(R.id.textViewLandmarkName);
        TextView countryNameText = findViewById(R.id.textVievCountryName);

        Intent intent = getIntent();
        String landmarkName = intent.getStringExtra("landmarkname");
        String countryName=intent.getStringExtra("countryname");
        landmarkNameText.setText(landmarkName);
        countryNameText.setText(countryName);

        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());
        //imageView.setImageBitmap(selectedImage);static kullanım durumunda
    }
}