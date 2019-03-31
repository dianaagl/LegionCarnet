package com.example.legioncarnet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Book extends AppCompatActivity {

    private  ImageView imgView;
    private int firstPicNumber ;
    private int lastPicNumber;
    private int curPage;
    private String formatString ;

    private Button nextButton;
    private Button prevButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        imgView = (ImageView) findViewById(R.id.book_image_id);
        nextButton = (Button)findViewById(R.id.next);
        prevButton = (Button)findViewById(R.id.prev);

        firstPicNumber =  getIntent().getIntExtra(MainActivity.FIRST_PAGE,0);
        lastPicNumber = getIntent().getIntExtra(MainActivity.LAST_PAGE,0);
        formatString = getIntent().getStringExtra(MainActivity.IMAGE_FORMAT_NAME);
        int val =  getIntent().getIntExtra(CarnetIndex.PAGE_NUMBER,0);


        curPage = firstPicNumber + val;

        setImage(curPage);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(view);
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previous(view);
            }
        });
    }
    Drawable getDrawables(int resId){
        return getDrawable(resId);

    }
    void setImage( int picNumber ){

            String resourceName = String.format(formatString, picNumber);
            int drawableResourceId = this.getResources().getIdentifier(resourceName, "drawable", this.getPackageName());
            Log.d("jhj", String.valueOf(drawableResourceId));
            imgView.setImageDrawable(getDrawable(drawableResourceId));
            curPage = picNumber;


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

        if(curPage > firstPicNumber) {
            setImage(--curPage);
        }
    }

    public void next(View v) {


        if(curPage < lastPicNumber) {
           setImage(++curPage);
        }
    }
}
