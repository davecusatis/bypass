package com.example.bypass.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Hashtable;


public class MainActivity extends Activity {

    private final String TAG = MainActivity.class.getSimpleName();

    private ListView mList;
    private ArrayAdapter<String> mAdapter;
    private CharSequence mTitle;







    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // removes top "action" bar -- for now, leaving it
        // ActionBar actionBar = getActionBar();
        // actionBar.hide();

        // set the adapter and populate the list

        BypassUtil.fillTable();        //TODO: remember to change, "sync database" - type function

        mList   = (ListView) findViewById(R.id.mBarList);
        mList.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO: honestly i wrote this while drunk, so i can't guarentee it works.
                // sober comment: it does in fact work, the confusion was at the mAdapter.getItem call, wasn't sure what it'd return
                Intent barClickedIntent = new Intent(MainActivity.this, IndividualBarActivity.class);
                barClickedIntent.putExtra("name", mAdapter.getItem(position));
                MainActivity.this.startActivity(barClickedIntent);
            }
        });


        mTitle  = "bypass";

        // eventually pull this info from DB

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, BypassUtil.getBarNames());
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
