package com.example.legioncarnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarnetIndex extends AppCompatActivity {


    public static final String PAGE_NUMBER = "page_number";
    private  ArrayList<Integer> pages;
    private Object[] pag;
    private ArrayList<String> chapters;
    private ListView chaptersListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_index);
        fillChapterMap();

        chaptersListview = findViewById(R.id.chapters_listview_id);
        createChapters();




        chaptersListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CarnetIndex.this, Book2.class);
                i.putExtra(PAGE_NUMBER, Integer.parseInt(pag[position].toString()));
                startActivity(i);
            }
        });


    }
    private void createChapters(){
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();
        //arrayList.add(chapterMap);
        HashMap<String, Object> m;
        Object [] chapt = chapters.toArray();
        pag = pages.toArray();
         for (int i = 0; i < chapters.size(); i++) {
            m = new HashMap<String, Object>();
            m.put("chapter_name",chapt[i]);
            m.put("chapter_page", pag[i]);

            arrayList.add(m);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this, arrayList,
                R.layout.chapte_item_layout,
                new String []{"chapter_name","chapter_page"}
                ,new int[]{R.id.chapter_name_id, R.id.chapter_page_id});
        chaptersListview.setAdapter(adapter);

    }
    public void chapterClick(View view){



    }
    private void fillChapterMap() {
        pages = new ArrayList<Integer>();
        chapters = new ArrayList<String>();
        pages.add(1);
        pages.add(7);
        pages.add(25);
        pages.add(40);
        pages.add(63);
        pages.add(82);
        pages.add(96);
        pages.add(104);
        pages.add(114);
        pages.add(122);
        pages.add(131);
        pages.add(132);

        chapters.add("beginning");
        chapters.add("fle");
        chapters.add( "viewcourante");
        chapters.add("combat");
        chapters.add("armement");
        chapters.add("nbc");
        chapters.add("transmissions");
        chapters.add("topographie");
        chapters.add("eps");
        chapters.add("secourisme");
        chapters.add("reglement");
        chapters.add("iec");
    }

    public void beginning(View v) {
        int id = 1;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void fle(View v) {
        int id = 7;
     }

    public void viewCourante(View v) {
        int id = 25;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void combat(View v) {
        int id = 40;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void armement(View v) {
        int id = 63;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void nbc(View v) {
        int id = 82;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void transmissions(View v) {
        int id = 87;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void topographie(View v) {
        int id = 96;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void eps(View v) {
        int id = 104;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void secourisme(View v) {
        int id = 114;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void reglement(View v) {
        int id = 122;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

    public void iec(View v) {
        int id = 131;
        Intent i = new Intent(this, Book2.class);
        i.putExtra(PAGE_NUMBER, id);
        startActivity(i);
    }

}
