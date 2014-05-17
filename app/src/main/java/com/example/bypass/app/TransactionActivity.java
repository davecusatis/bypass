package com.example.bypass.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class TransactionActivity extends Activity
{

    private TextView nameText;
    private TextView specialText;
    private TextView reciept;
    private EditText cct;
    private EditText sct;
    private BypassUtil.BarData bar;
    private String[] time;
    private String passes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Intent transactionIntent = getIntent();

        bar = BypassUtil.getDataFromName(transactionIntent.getStringExtra("name"));
        time = transactionIntent.getStringExtra("time").split(" ");
        passes = transactionIntent.getStringExtra("passes");

        nameText = (TextView) findViewById(R.id.barNameView);
        specialText = (TextView) findViewById(R.id.barSpecialView);
        reciept = (TextView) findViewById(R.id.recieptTextView);

        nameText.setText(bar.getName());
        specialText.setText(bar.getSpecials());
        //reciept.setText(passes + " at " + time[1] + "a piece, for " + time[0] + ".\nTotal:" + (Integer.getInteger(passes) * Integer.getInteger(time[1].trim().substring(1))));

        //buttonClickedIntent.putExtra("name", bar.getName());
        //buttonClickedIntent.putExtra("time", timeSelected);
        //buttonClickedIntent.putExtra("passes", numPassesSelected);


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

}
