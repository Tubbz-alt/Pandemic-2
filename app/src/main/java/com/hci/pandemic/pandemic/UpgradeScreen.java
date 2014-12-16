package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


public class UpgradeScreen extends Activity implements SymptomDialogFragment.SymptomsDialogListener {

    // variables for this activity
    private SharedPreferences mPrefs;
    private ArrayList<Symptom> symptomArrayList;
    private HashMap<Integer, Button> buttonHashMap;
    private int ev_points, health_points, contagious_rating, lethality_rating, current_level,
                num_symptoms;
    private boolean has_cough, has_sneeze, has_sweat, has_chills, has_fatigue, has_nausea,
                    has_vomit, has_diarrhea, has_fever, has_blind, has_seizure, has_rash;


    // elements from the activity layout XML file
    TextView evolution_points_tv, health_points_tv, contagious_points_tv, lethal_points_tv;
    Button button_coughing,button_sneezing,button_sweating,button_chills,button_fatigue,
           button_nausea, button_vomit,button_diarrhea,button_fever,button_blindness,button_seizure,
           button_rash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get preferences (persistence settings)
        mPrefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        ev_points = mPrefs.getInt("ev_points", 30);
        health_points = mPrefs.getInt("health", 100);
        contagious_rating = mPrefs.getInt("contagious", 7);
        lethality_rating = mPrefs.getInt("lethal", 5);
        current_level = mPrefs.getInt("currLevel", 1);
        num_symptoms = mPrefs.getInt("numSymptoms", 0);

        updateBooleans();

        //data structures
        symptomArrayList = getAllSymptoms();

        // display the page
        setContentView(R.layout.activity_upgrade_screen);


        // change the amount of points you have based on shared prefs
        updateViews();


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

        buttonHashMap = ButtonHashMap();

    }

    private void updateBooleans() {
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
    }

    // update all the variables on the screen
    private void updateViews() {
        evolution_points_tv = (TextView) findViewById(R.id.rightTopInfoBar);
        evolution_points_tv.setText(String.valueOf(ev_points) + " Evolution Points");

        health_points_tv = (TextView) findViewById(R.id.health_stat);
        health_points_tv.setText("Health Points: " + String.valueOf(health_points));

        contagious_points_tv = (TextView) findViewById(R.id.contagious_stat);
        contagious_points_tv.setText("Contagious Rating: " + String.valueOf(contagious_rating));

        lethal_points_tv = (TextView) findViewById(R.id.lethal_stat);
        lethal_points_tv.setText("Lethality Rating: " + String.valueOf(lethality_rating));

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

    // callback method that:
    //  - checks to see if the user can get the symptom
    //  - modify the variables on the screen and the dialog box to show the symptom has been bought
    //  - record the transaction and persist the data
    @Override
    public void onDialogPositiveClick(DialogFragment dialog, int symptomID) {
        Symptom s = getSymptomFromListById(symptomID);
        Log.i("APP", "symptom clicked is " + s.toString());

    // null checks
        // make sure you don't already have the symptom
        if (s.has_unlocked()){
            Toast.makeText(getApplicationContext(), "You have already unlocked " +
                    "this symptom!", Toast.LENGTH_SHORT).show();
            return;
        }

        // make sure the user has the right level
        if (current_level < s.getLevel()){
            Toast.makeText(getApplicationContext(), "You do not have not unlocked enough symptoms " +
                    "to purchase one from this tier.", Toast.LENGTH_SHORT).show();
            return;
        }

        // make sure the user has enough points
        if (ev_points < s.getPoints_to_unlock()){
            Toast.makeText(getApplicationContext(), "You do not have not enough points to " +
                    "unlock this symptom.", Toast.LENGTH_SHORT).show();
            return;
        }

    // at this point, the user can purchase the symptom
        s.set_unlocked(true);
        ev_points -= s.getPoints_to_unlock();
        contagious_rating += s.getContagiousness();
        lethality_rating += s.getLethality();
        num_symptoms++;


        if (checkForLevelUpgrade()){
            current_level++;
        }


        // store the changes indefinitely
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putBoolean(s.bool_string, s.has_unlocked());
        editor.putInt("currLevel", current_level);
        editor.putInt("ev_points", ev_points);
        editor.putInt("contagious", contagious_rating);
        editor.putInt("lethal", lethality_rating);
        editor.putInt("currLevel", current_level);
        editor.putInt("numSymptoms", num_symptoms);
        editor.commit();

        //update the boolean values:
        updateBooleans();

        // update the views:
        updateViews();

        // change the color to selected after the symptom has been purchased
         changeBackgroundColor(s);

    }

    // changes background color for symptoms that have been saved
    private void changeBackgroundColor(Symptom s){
        Button symptomButton = buttonHashMap.get(s.get_id());
        symptomButton.setBackgroundColor(Color.DKGRAY);
    }


    private boolean checkForLevelUpgrade() {

        switch (current_level){
            case 1:
                if(num_symptoms >= 2)
                    return true;
                break;

            case 2:
                if(num_symptoms >=4)
                    return true;
                break;
            case 3:
                if(num_symptoms >= 7)
                    return true;
                break;
            case 4: return false ;
            default:
                return false;
        }

        return false;
    }



    // returns without doing anything b/c the user canceled the request
    @Override
    public void onDialogNegativeClick(DialogFragment dialog, int symptomID) {
        Log.i("APP", "symptom clicked is " + getSymptomFromListById(symptomID).toString());
        updateBooleans();
    }

    //  class that pulls the symptom info from ArrayList and displays it in a dialog
    private class SymptomsOnClickListener implements View.OnClickListener{

        int symptom_id;

        // constructor that passes an int that corresponds to the symptom_id
        public SymptomsOnClickListener(int id){
            this.symptom_id = id;
        }


        @Override
        public void onClick(View v) {

            // get the info from the symptom id
              Symptom s =  getSymptomFromListById(symptom_id);

            // pass it to the Dialog Fragment for the dialog to display the information
            Bundle args = new Bundle();
            args.putInt("id", s.get_id());
            args.putString("name", s.getName());
            args.putString("description", s.getDescription());
            args.putInt("level", s.getLevel());
            args.putInt("contagious", s.getContagiousness());
            args.putInt("lethality", s.getLethality());
            args.putInt("points_to_unlock", s.getPoints_to_unlock());
            args.putBoolean("has_unlocked", s.has_unlocked());

            //populate a fragment / dialog with the data
                DialogFragment symptomFragment = new SymptomDialogFragment();
                symptomFragment.setArguments(args);

                symptomFragment.show(getFragmentManager(), "symptoms_dialog");

            // based on user's choice, get data returned, modify the current view variables
            // accordingly

        }
    }

    // method that gets the data this activity uses
    public ArrayList<Symptom> getAllSymptoms(){
        if(symptomArrayList != null){
            return symptomArrayList;
        }
        else{
            symptomArrayList = new ArrayList<Symptom>();

            symptomArrayList.add(new Symptom(1,"coughing", "A cough is a forceful release of air from the lungs that can be heard.", 1, 2, 1, 3, has_cough,"cough_bool"));
            symptomArrayList.add(new Symptom(2,"sneezing", "A sneeze is a sudden involuntary expulsion of air from the nose and mouth due to irritation of one's nostrils.", 1, 2, 1, 4, has_sneeze, "sneeze_bool"));
            symptomArrayList.add(new Symptom(3,"sweating", "Sweating is moisture exuded through the pores of the skin, typically in profuse quantities as a reaction to heat, physical exertion, fever, or fear.", 1,1,3,3, has_sweat, "sweat_bool"));
            symptomArrayList.add(new Symptom(4, "chills", "Chills are a sensation of coldness, often accompanied by shivering and pallor of the skin.", 2, 0, 3, 7, has_chills, "chills_bool"));
            symptomArrayList.add(new Symptom(5, "fatigue", "Fatigue: extreme tiredness, typically resulting from mental or physical exertion or illness.", 2, 0, 4, 5, has_fatigue, "fatigue_bool"));
            symptomArrayList.add(new Symptom(6, "nausea", "Nausea is a feeling of sickness with an inclination to vomit.", 2, 1, 3, 8, has_nausea, "nausea_bool"));
            symptomArrayList.add(new Symptom(7, "vomit", "To vomit is to eject matter from the stomach through the mouth.", 3, 3, 2, 11, has_vomit, "vomit_bool"));
            symptomArrayList.add(new Symptom(8, "diarrhea", "Diarrhea is a condition in which feces are discharged from the bowels frequently and in a liquid form.",3,4,4, 13, has_diarrhea, "diarrhea_bool"));
            symptomArrayList.add(new Symptom(9, "fever", "Fever is an abnormally high body temperature, usually accompanied by shivering, headache, and in severe instances, delirium.", 3, 2,6, 10, has_fever, "fever_bool"));
            symptomArrayList.add(new Symptom(10, "blindness", "Blindness: unable to see; lacking the sense of sight; sightless", 4, 0, 10,15, has_blind, "blind_bool"));
            symptomArrayList.add(new Symptom(11, "seizure", "A Seizure is uncontrolled electrical activity in the brain, which may produce a physical convulsion, minor physical signs, thought disturbances, or a combination of symptoms.", 4, 0, 8, 18, has_seizure, "seizure_bool"));
            symptomArrayList.add(new Symptom(12, "rash", "Rash: an eruption on the body typically with little or no elevation above the surface.", 4, 12, 6, 13, has_rash, "rash_bool"));

            return symptomArrayList;
        }
    }

    public HashMap<Integer,Button> ButtonHashMap(){
        HashMap<Integer,Button> map = new HashMap<Integer,Button>();
        map.put(1, button_coughing);
        map.put(2, button_sneezing);
        map.put(3, button_sweating);
        map.put(4, button_chills);
        map.put(5, button_fatigue);
        map.put(6, button_nausea);
        map.put(7, button_vomit);
        map.put(8, button_diarrhea);
        map.put(9, button_fever);
        map.put(10, button_blindness);
        map.put(11,button_seizure);
        map.put(12, button_rash);

        return map;
    }

    // aux method to pull a symptom by its id
    public Symptom getSymptomFromListById(int id){
        for (Symptom s : symptomArrayList){
            if (s.get_id() == id)
                return s;
        }

        return null;

    }
}
