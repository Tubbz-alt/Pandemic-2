package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class UpgradeScreen extends Activity {

    private SharedPreferences mPrefs;
    private int ev_points;
    private boolean has_cough, has_sneeze, has_sweat, has_chills, has_fatigue, has_nausea,
                    has_vomit, has_diarrhea, has_fever, has_blind, has_seizure, has_rash;

    // elements on page
    TextView evolution_points_tv;
    Button button_coughing,button_sneezing,button_sweating,button_chills,button_fatigue,
           button_nausea, button_vomit,button_diarrhea,button_fever,button_blindness,button_seizure,
           button_rash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get preferences
        mPrefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        ev_points = mPrefs.getInt("ev_points", 25);
        has_cough = mPrefs.getBoolean("cough_bool", false);
        has_sneeze = mPrefs.getBoolean("sneeze_bool", false);
        has_sweat = mPrefs.getBoolean("sweat_bool", false);
        has_chills = mPrefs.getBoolean("chills_bool", false);
        has_fatigue = mPrefs.getBoolean("fatigue_bool", false);
        has_nausea = mPrefs.getBoolean("nausea_bool", false);
        has_vomit = mPrefs.getBoolean("vomit_bool", false);
        has_diarrhea = mPrefs.getBoolean("diarrhea_bool", false);
        has_fever = mPrefs.getBoolean("fever_bool", false);
        has_blind = mPrefs.getBoolean("blind_bool", false);
        has_seizure = mPrefs.getBoolean("seizure_bool", false);
        has_rash = mPrefs.getBoolean("rash_bool", false);

        // display the page
        setContentView(R.layout.activity_upgrade_screen);


        // change the amount of points you have based on shared prefs
        evolution_points_tv = (TextView) findViewById(R.id.rightTopInfoBar);
        evolution_points_tv.setText(String.valueOf(ev_points) + " Evolution Points");


        // instantiate button onClick listeners for every button
        button_coughing = (Button) findViewById(R.id.button_coughing);
        button_coughing.setOnClickListener(new SymptomsOnClickListener(1));

        button_sneezing = (Button) findViewById(R.id.button_sneezing);
        button_sneezing.setOnClickListener(new SymptomsOnClickListener(2));

        button_sweating = (Button) findViewById(R.id.button_sweating);
        button_sweating.setOnClickListener(new SymptomsOnClickListener(3));

        button_chills = (Button) findViewById(R.id.button_chills);
        button_chills.setOnClickListener(new SymptomsOnClickListener(4));

        button_fatigue = (Button) findViewById(R.id.button_fatigue);
        button_fatigue.setOnClickListener(new SymptomsOnClickListener(5));

        button_nausea = (Button) findViewById(R.id.button_nausea);
        button_nausea.setOnClickListener(new SymptomsOnClickListener(6));

        button_vomit = (Button) findViewById(R.id.button_vomit);
        button_vomit.setOnClickListener(new SymptomsOnClickListener(7));

        button_diarrhea = (Button) findViewById(R.id.button_diarrhea);
        button_diarrhea.setOnClickListener(new SymptomsOnClickListener(8));

        button_fever = (Button) findViewById(R.id.button_fever);
        button_fever.setOnClickListener(new SymptomsOnClickListener(9));

        button_blindness = (Button) findViewById(R.id.button_blindness);
        button_blindness.setOnClickListener(new SymptomsOnClickListener(10));

        button_seizure = (Button) findViewById(R.id.button_seizure);
        button_seizure.setOnClickListener(new SymptomsOnClickListener(11));

        button_rash = (Button) findViewById(R.id.button_rash);
        button_rash.setOnClickListener(new SymptomsOnClickListener(12));
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
        if (id == R.id.map_screen_menu) {
            Intent intent = new Intent(this, MapActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else if (id == R.id.upgrade_screen_menu) {
            return true;
        } else if (id == R.id.leaderboard_screen_menu) {
            Intent intent = new Intent(this, Leaderboard.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // class that:
    //  - pulls the symptom info from DB and displays it
    //  - checks if user can buy the symptom
    //  - if bought, change the number of ev points available
    private class SymptomsOnClickListener implements View.OnClickListener{

        int id;

        // pass in an int which corresponds to the actual symptom_id in the db
        public SymptomsOnClickListener(int id){
            this.id = id;
        }



        @Override
        public void onClick(View v) {

            // get the info from the database from the symptom id

            //populate a fragment / dialog with the data

            // based on user's choice, get data returned, modify the current view variables
            // accordingly

        }
    }

}
