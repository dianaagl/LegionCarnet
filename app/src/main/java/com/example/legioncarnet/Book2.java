package com.example.legioncarnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Book2 extends AppCompatActivity {

    private  ImageView imgView;
    private int firstPicNumber ;
    private int lastPicNumber;
    private String formatString ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book2);

        formatString = getString(R.string.book2_name_string);
        firstPicNumber = 001;
        lastPicNumber = 141;
        imgView = (ImageView) findViewById(R.id.book2_image_id);
        imgView.setTag(firstPicNumber);

//        Bundle b = getIntent().getExtras();
//        int id = b.getInt("id");
    }

    public void setImage() {

    }

    public void previous(View v) {
        int val = Integer.parseInt(imgView.getTag().toString());
        if(val > firstPicNumber) {
            String resourceName = String.format(formatString, val - 1);
            int drawableResourceId = this.getResources().getIdentifier(resourceName, "drawable", this.getPackageName());

            imgView.setImageDrawable(getDrawable(drawableResourceId));
            imgView.setTag(val - 1);
        }

    }

    public void next(View v) {

        int val = Integer.parseInt(imgView.getTag().toString());
        if(val < lastPicNumber) {
            String resourceName = String.format(formatString, val + 1);
            int drawableResourceId = this.getResources().getIdentifier(resourceName, "drawable",
                    this.getPackageName());

            imgView.setImageDrawable(getDrawable(drawableResourceId));
            imgView.setTag(val + 1);
        }
    }
}
