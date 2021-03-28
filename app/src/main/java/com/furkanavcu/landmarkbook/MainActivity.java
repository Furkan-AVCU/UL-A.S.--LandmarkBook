package com.furkanavcu.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //static Bitmap selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewMainMenu);
//Data
        final ArrayList<String> landmarkMmNames = new ArrayList<String>();
        landmarkMmNames.add("Pisa");
        landmarkMmNames.add("Eiffel");
        landmarkMmNames.add("Colesseo");
        landmarkMmNames.add("Landon Bridge");

        final ArrayList<String> countryNames = new ArrayList<String>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("England");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.pisatower);
        Bitmap eifell = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.eifelltower);
        Bitmap colleseo = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.colloseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<Bitmap>();
        landmarkImages.add(pisa);
        landmarkImages.add(eifell);
        landmarkImages.add(colleseo);
        landmarkImages.add(londonBridge);

//ListView
        ArrayAdapter arrayAdapterMm = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, landmarkMmNames);

        listView.setAdapter(arrayAdapterMm);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent =new Intent(getApplicationContext(),DetailActivity.class);
                intent.putExtra("landmarkname",landmarkMmNames.get(position));
                intent.putExtra("countryname",countryNames.get(position));
                //selectedImage=landmarkImages.get(position); Statik ile
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));


                startActivity(intent);
            }
        });


    }
}