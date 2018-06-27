package com.cnnradams.customcrawler.main;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cnnradams.customcrawler.CrawlerDataObject;
import com.cnnradams.customcrawler.info.CrawlerInfoActivity;
import com.cnnradams.customcrawler.create.CreateCrawlerDialogFragment;
import com.cnnradams.customcrawler.R;

public class MainActivity extends AppCompatActivity {

    Context me;
    CrawlerDataObject[] data = {new CrawlerDataObject("Google USA","www.google.com"),new CrawlerDataObject("Google Canada","www.google.ca")};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListView mainLayout = findViewById(R.id.crawler_list_view);
        mainLayout.setClickable(true);
        CrawlerArrayAdapter arrayAdapter = new CrawlerArrayAdapter(this,data);
        mainLayout.setAdapter(arrayAdapter);
        me = this;
        mainLayout.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent enterActivity = new Intent(me, CrawlerInfoActivity.class);
                enterActivity.putExtra("Data",data[position]);
                startActivity(enterActivity);
            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             DialogFragment d = CreateCrawlerDialogFragment.newInstance();
             d.show(getFragmentManager(),"Dialog");
            }
        });
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
}
