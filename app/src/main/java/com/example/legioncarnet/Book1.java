package com.example.legioncarnet;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Book1 extends AppCompatActivity {

    private  ImageView imgView;
    private int firstPicNumber ;
    private int lastPicNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);



        firstPicNumber = 200601;
        lastPicNumber = 200667;
        imgView = (ImageView) findViewById(R.id.imageView);
        imgView.setTag(firstPicNumber);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void previous(View v) {
        int val = Integer.parseInt(imgView.getTag().toString());
        if(val > firstPicNumber) {
            String resourceName = String.format(getString(R.string.pic_name_string), val - 1);
            int drawableResourceId = this.getResources().getIdentifier(resourceName, "drawable", this.getPackageName());

            imgView.setImageDrawable(getDrawable(drawableResourceId));
            imgView.setTag(val - 1);
        }

    }

    public void next(View v) {

        int val = Integer.parseInt(imgView.getTag().toString());
        if(val < lastPicNumber) {
            String resourceName = String.format(getString(R.string.pic_name_string), val + 1);
            int drawableResourceId = this.getResources().getIdentifier(resourceName, "drawable",
                    this.getPackageName());

            imgView.setImageDrawable(getDrawable(drawableResourceId));
            imgView.setTag(val + 1);
        }
    }
}
