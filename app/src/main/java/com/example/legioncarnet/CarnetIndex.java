package com.example.legioncarnet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        chaptersListview = findViewById(R.id.chapters_listview_id);
        fillChapterMap();
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

        chapters.add("Beginning");
        chapters.add("FLE");
        chapters.add( "Viewcourante");
        chapters.add("Combat");
        chapters.add("Armement");
        chapters.add("NBC");
        chapters.add("Transmissions");
        chapters.add("Topographie");
        chapters.add("Eps");
        chapters.add("Secourisme");
        chapters.add("Reglement");
        chapters.add("IEC");
    }


}
