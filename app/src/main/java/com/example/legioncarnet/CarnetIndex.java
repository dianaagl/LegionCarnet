package com.example.legioncarnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CarnetIndex extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_index);
    }

    public void fle(View v) {
        int id = 7;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void viewCourante(View v) {
        int id = 25;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void combat(View v) {
        int id = 40;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void armement(View v) {
        int id = 63;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void nbc(View v) {
        int id = 82;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void transmissions(View v) {
        int id = 87;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void topographie(View v) {
        int id = 104;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void eps(View v) {
        int id = 104;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void secourisme(View v) {
        int id = 114;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void reglement(View v) {
        int id = 122;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }

    public void iec(View v) {
        int id = 131;
        Intent i = new Intent(this, Book2.class);
        i.putExtra("id", id);
        startActivity(i);
    }
}
