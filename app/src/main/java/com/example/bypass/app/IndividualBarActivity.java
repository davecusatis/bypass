package com.example.bypass.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;


public class IndividualBarActivity extends Activity {

    private CharSequence mTitle;
    private ArrayAdapter<CharSequence> timeSpinnerAdapter;
    private ArrayAdapter<String> passSpinnerAdapter;
    private Spinner timeSpinner;
    private Spinner passSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_bar);

        Intent barClickedIntent = getIntent();
        String barName = barClickedIntent.getStringExtra("name");
        BypassUtil.BarData bar = BypassUtil.getSpecialFromName(barName);
        TextView mainText = (TextView) findViewById(R.id.barNameView);

        mainText.setText(bar.toString());

        timeSpinner = (Spinner) findViewById(R.id.timeslot_spinner);
        passSpinner = (Spinner) findViewById(R.id.pass_spinner);


        timeSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.time_spinner_data, android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeSpinnerAdapter);

        passSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, BypassUtil.availablePasses);
        passSpinner.setAdapter(passSpinnerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.individual_bar, menu);
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
