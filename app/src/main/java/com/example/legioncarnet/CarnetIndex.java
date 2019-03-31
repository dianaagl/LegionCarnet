package com.example.legioncarnet;

import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class CarnetIndex extends AppCompatActivity {


    public static final String PAGE_NUMBER = "page_number";

    private ArrayList<Chapter> chapters;
    private ListView chaptersListview;
    private LayoutInflater lInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carnet_index);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        lInflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);


        chaptersListview = findViewById(R.id.chapters_listview_id);
        final int firstPage = getIntent().getIntExtra(MainActivity.FIRST_PAGE, 0);
        final int lastPage = getIntent().getIntExtra(MainActivity.LAST_PAGE, 0);
        final String formatString = getIntent().getStringExtra(MainActivity.IMAGE_FORMAT_NAME);

        fillChapterMap(formatString);
        PagesAdapter adapter = new PagesAdapter(chapters);

        chaptersListview.setAdapter(adapter);
        chaptersListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(CarnetIndex.this, Book.class);
                i.putExtra(PAGE_NUMBER, chapters.get(position).getPage());
                i.putExtra(MainActivity.FIRST_PAGE, firstPage);
                i.putExtra(MainActivity.LAST_PAGE, lastPage);
                i.putExtra(MainActivity.IMAGE_FORMAT_NAME, formatString);

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



    private void fillChapterMap(String book) {
        if (book.equals(getString(R.string.chants_name_string))) {

            chapters = new ArrayList<Chapter>();
            chapters.add(new Chapter(1,"NOUS SOMMES TOUS DES VOLONTAIRES"));
            chapters.add(new Chapter(60,"KEPI BLANC"));
        } else

        {

            chapters = new ArrayList<Chapter>();

            chapters.add(new Chapter(1,"Beginning"));
            chapters.add(new Chapter(7,"FLE"));
            chapters.add(new Chapter(25,"Viewcourante"));
            chapters.add(new Chapter(40,"Combat"));
            chapters.add(new Chapter(63,"Armement"));
            chapters.add(new Chapter(82,"NBC"));
            chapters.add(new Chapter(96,"Transmissions"));
            chapters.add(new Chapter(104,"Topographie"));
            chapters.add(new Chapter(114,"Eps"));
            chapters.add(new Chapter(122,"Secourisme"));
            chapters.add(new Chapter(131,"Reglement"));
            chapters.add(new Chapter(132,"IEC"));

        }
    }
    public class PagesAdapter extends BaseAdapter{
        private ArrayList<Chapter> chaptsList;
        public PagesAdapter(ArrayList<Chapter> chapts) {
            chaptsList = chapts;
        }

        @Override
        public int getCount() {
            return chaptsList.size();
        }

        @Override
        public Object getItem(int i) {
            return chaptsList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return chaptsList.get(i).hashCode();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            View convView = view;
            if (convView == null) {
                convView = lInflater.inflate(R.layout.chapte_item_layout, viewGroup, false);
            }
            ((TextView) convView.findViewById(R.id.chapter_name_id)).setText(chaptsList.get(i).getName());
            ((TextView) convView.findViewById(R.id.chapter_page_id)).setText(String.valueOf(chaptsList.get(i).getPage()));


            convView.setTag(i);

            return convView;

        }
    }
}



