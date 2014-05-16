package com.example.bypass.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class TransactionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.transaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent backIntent = new Intent(TransactionActivity.this, IndividualBarActivity.class);
            backIntent.putExtra("name", getIntent().getStringExtra("name"));
            TransactionActivity.this.startActivity(backIntent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed()
    {
        Intent backIntent = new Intent(TransactionActivity.this, IndividualBarActivity.class);
        backIntent.putExtra("name", getIntent().getStringExtra("name"));
        TransactionActivity.this.startActivity(backIntent);
    }
}
