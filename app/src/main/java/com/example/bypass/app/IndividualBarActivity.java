package com.example.bypass.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Array;


public class IndividualBarActivity extends Activity {

    private ArrayAdapter<CharSequence> timeSpinnerAdapter;
    private ArrayAdapter<String> passSpinnerAdapter;
    private Spinner timeSpinner;
    private Spinner passSpinner;
    private BypassUtil.BarData bar;
    private TextView nameText;
    private TextView specialText;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_bar);

        Intent barClickedIntent = getIntent();
        String barName = barClickedIntent.getStringExtra("name");

        nameText = (TextView) findViewById(R.id.barNameView);
        specialText = (TextView) findViewById(R.id.barSpecialView);
        timeSpinner = (Spinner) findViewById(R.id.timeslot_spinner);
        passSpinner = (Spinner) findViewById(R.id.pass_spinner);
        checkoutButton = (Button) findViewById(R.id.checkoutButton);

        bar = BypassUtil.getDataFromName(barName);

        nameText.setText(bar.getName());
        specialText.setText(bar.getSpecials());

        // TODO: Add big ass number of passes available for the current time slot

        timeSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.time_spinner_data, android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.        setAdapter(timeSpinnerAdapter);

        passSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, BypassUtil.availablePasses);
        passSpinner.setAdapter(passSpinnerAdapter);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeSelected = "";
                String numPassesSelected = "";

                try {

                    timeSelected = timeSpinner.getSelectedItem().toString();
                    numPassesSelected = passSpinner.getSelectedItem().toString();
                }catch(NullPointerException e)
                {
                    Toast t = Toast.makeText(getApplicationContext(), "null selection" , Toast.LENGTH_SHORT );
                }

                Intent buttonClickedIntent = new Intent(IndividualBarActivity.this, TransactionActivity.class);

                if(timeSelected != "" && numPassesSelected != "")
                {
                    buttonClickedIntent.putExtra("name", bar.getName());
                    buttonClickedIntent.putExtra("time", timeSelected);
                    buttonClickedIntent.putExtra("passes", numPassesSelected);
                    IndividualBarActivity.this.startActivity(buttonClickedIntent);
                }
                else if (numPassesSelected != "")               // todo: additional logic may be needed for figuring is passes available
                {
                    new AlertDialog.Builder(IndividualBarActivity.this)
                            .setTitle("Invalid number of passes selected!")
                            .setMessage("Please select a valid number of passes.")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO: sync return to activity
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                else
                {
                    new AlertDialog.Builder(IndividualBarActivity.this)
                            .setTitle("Invalid time selected!")
                            .setMessage("Please select a valid time.")
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // TODO: sync return to activity
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
        });

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
