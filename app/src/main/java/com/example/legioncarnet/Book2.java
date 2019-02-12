package com.example.legioncarnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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

        Bundle bundle = getIntent().getExtras();
        int val =  getIntent().getIntExtra(CarnetIndex.PAGE_NUMBER,0);
        setImage(val);
//        Bundle b = getIntent().getExtras();
//        int id = b.getInt("id");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setImage( int picNumber ){

            String resourceName = String.format(formatString, picNumber);
            int drawableResourceId = this.getResources().getIdentifier(resourceName, "drawable", this.getPackageName());

            imgView.setImageDrawable(getDrawable(drawableResourceId));
            imgView.setTag(picNumber);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void previous(View v) {
        int val = Integer.parseInt(imgView.getTag().toString());
        if(val > firstPicNumber) {
            setImage(val - 1);
        }
    }

    public void next(View v) {

        int val = Integer.parseInt(imgView.getTag().toString());
        if(val < lastPicNumber) {
           setImage(val + 1);
        }
    }
}
