package com.example.legioncarnet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    public static final String IMAGE_FORMAT_NAME = "imgName";
    public static final String FIRST_PAGE = "first";
    public static final String LAST_PAGE = "last";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

  /*      FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "LegionCarnet@Gmail.com", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void bookOneShow(View v) {
        Intent intent = new Intent(this, CarnetIndex.class);
        intent.putExtra(IMAGE_FORMAT_NAME, getString(R.string.chants_name_string));
        intent.putExtra(FIRST_PAGE, 200601);
        intent.putExtra(LAST_PAGE, 200667);
        startActivity(intent);
    }

    public void bookTwoShow(View v) {
        Intent intent = new Intent(this, CarnetIndex.class);
        intent.putExtra(IMAGE_FORMAT_NAME, getString(R.string.carnet_name_string));
        intent.putExtra(FIRST_PAGE, 001);
        intent.putExtra(LAST_PAGE, 141);
        startActivity(intent);
    }
}
