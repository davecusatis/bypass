package com.example.bypass.app;

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

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList   = (ListView) findViewById(R.id.mBarList);
        mTitle  = "bypass";

        mAdapter = new ArrayAdapter<String>(this, R.id.mBarList);
        mList.setAdapter(mAdapter);

        populateAdapter();



    }

    private void populateAdapter()
    {
        // eventually pull this info from DB,
        ArrayList<String> bars = new ArrayList<String>();
        bars.add("The Den");
        bars.add("The Phyrst");
        bars.add("Mad Mex");

        mAdapter = new ArrayAdapter<String>(this, R.id.mBarList, bars);
        mAdapter.addAll(bars);
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
