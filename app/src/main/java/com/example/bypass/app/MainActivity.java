package com.example.bypass.app;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {
    private final String TAG = MainActivity.class.getSimpleName();

    private ListView mList;
    private ArrayAdapter<String> mAdapter;
    private CharSequence mTitle;

    private final String[] bars = new String[] {"The Den", "The Phyrst", "Bar Bleu"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // removes top "action" bar -- for now, leaving it
        // ActionBar actionBar = getActionBar();
        // actionBar.hide();

        // set the adapter and populate the list
        mList   = (ListView) findViewById(R.id.mBarList);
        mTitle  = "bypass";

        // eventually pull this info from DB

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bars);
        mList.setAdapter(mAdapter);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
