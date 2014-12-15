package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.app.DialogFragment;
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
import java.util.ArrayList;


public class UpgradeScreen extends Activity implements SymptomDialogFragment.SymptomsDialogListener {

    private SharedPreferences mPrefs;
    private int ev_points, health_points, contagious_rating, lethality_rating;
    private boolean has_cough, has_sneeze, has_sweat, has_chills, has_fatigue, has_nausea,
                    has_vomit, has_diarrhea, has_fever, has_blind, has_seizure, has_rash;

    private ArrayList<Symptom> symptomArrayList;

    // elements on page
    TextView evolution_points_tv, health_points_tv, contagious_points_tv, lethal_points_tv;
    Button button_coughing,button_sneezing,button_sweating,button_chills,button_fatigue,
           button_nausea, button_vomit,button_diarrhea,button_fever,button_blindness,button_seizure,
           button_rash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get preferences
        mPrefs = getSharedPreferences("app_prefs", Context.MODE_PRIVATE);
        ev_points = mPrefs.getInt("ev_points", 30);
        health_points = mPrefs.getInt("health", 100);
        contagious_rating = mPrefs.getInt("contagious", 7);
        lethality_rating = mPrefs.getInt("lethal", 5);

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

        symptomArrayList = getAllSymptoms();
        // get all the symptoms in the DB
//        DBHelper dbHelper = new DBHelper(this);

//        prepopulateSymptomTable(dbHelper);
//        final List<Symptom> symptomList = dbHelper.getAllSymptoms();


        //Log.i("APP","symptom for coughing is:" + symptomList.toArray()[0].toString());

        // display the page
        setContentView(R.layout.activity_upgrade_screen);


        // change the amount of points you have based on shared prefs
        evolution_points_tv = (TextView) findViewById(R.id.rightTopInfoBar);
        evolution_points_tv.setText(String.valueOf(ev_points) + " Evolution Points");

        health_points_tv = (TextView) findViewById(R.id.health_stat);
        health_points_tv.setText("Health Points: " + String.valueOf(health_points));

        contagious_points_tv = (TextView) findViewById(R.id.contagious_stat);
        contagious_points_tv.setText("Contagious Rating: " + String.valueOf(contagious_rating));

        lethal_points_tv = (TextView) findViewById(R.id.lethal_stat);
        lethal_points_tv.setText("Lethality Rating: " + String.valueOf(lethality_rating));


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

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, int symptomID) {
        //Log.i("APP", "symptom clicked is " + getSymptomFromListById(symptomID).toString());
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog, int symptomID) {
        //Log.i("APP", "symptom clicked is " + getSymptomFromListById(symptomID).toString());
    }

    // class that:
    //  - pulls the symptom info from DB and displays it
    //  - checks if user can buy the symptom
    //  - if bought, change the number of ev points available
    private class SymptomsOnClickListener implements View.OnClickListener{

        int symptom_id;

        // pass in an int which corresponds to the actual symptom_id in the db
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
            args.putBoolean("has_unlocked", s.is_unlocked());



            //populate a fragment / dialog with the data
                DialogFragment symptomFragment = new SymptomDialogFragment();
                symptomFragment.setArguments(args);

                symptomFragment.show(getFragmentManager(), "symptoms_dialog");

            // based on user's choice, get data returned, modify the current view variables
            // accordingly

        }
    }

//    public void prepopulateSymptomTable(DBHelper dbHelper){
//
//        dbHelper.addSymptom(new Symptom(1,"coughing", "A cough is a forceful release of air from the lungs that can be heard.", 1, 2, 1, 3));
//        dbHelper.addSymptom(new Symptom(2,"sneezing", "A sneeze is a sudden involuntary expulsion of air from the nose and mouth due to irritation of one's nostrils.", 1, 2, 1, 4));
//        dbHelper.addSymptom(new Symptom(3,"sweating", "Sweating is moisture exuded through the pores of the skin, typically in profuse quantities as a reaction to heat, physical exertion, fever, or fear.", 1,1,3, 3));
//        dbHelper.addSymptom(new Symptom(4, "chills", "Chills are a sensation of coldness, often accompanied by shivering and pallor of the skin.", 2, 0, 3, 7));
//        dbHelper.addSymptom(new Symptom(5, "fatigue", "Fatigue: extreme tiredness, typically resulting from mental or physical exertion or illness.", 2, 0, 4, 5));
//        dbHelper.addSymptom(new Symptom(6, "nausea", "Nausea is a feeling of sickness with an inclination to vomit.", 2, 1, 3, 8));
//        dbHelper.addSymptom(new Symptom(7, "vomit", "To vomit is to eject matter from the stomach through the mouth.", 3, 3, 2, 11));
//        dbHelper.addSymptom(new Symptom(8, "diarrhea", "Diarrhea is a condition in which feces are discharged from the bowels frequently and in a liquid form.",3,4,4, 13));
//        dbHelper.addSymptom(new Symptom(9, "fever", "Fever is an abnormally high body temperature, usually accompanied by shivering, headache, and in severe instances, delirium.", 3, 2,6, 10));
//        dbHelper.addSymptom(new Symptom(10, "blindness", "Blindness: unable to see; lacking the sense of sight; sightless", 4, 0, 10, 15));
//        dbHelper.addSymptom(new Symptom(11, "seizure", "A Seizure is uncontrolled electrical activity in the brain, which may produce a physical convulsion, minor physical signs, thought disturbances, or a combination of symptoms.", 4, 0, 8, 18));
//        dbHelper.addSymptom(new Symptom(12, "rash", "Rash: an eruption on the body typically with little or no elevation above the surface.", 4, 12, 6, 13));
//    }

    public ArrayList<Symptom> getAllSymptoms(){
        if(symptomArrayList != null){
            return symptomArrayList;
        }
        else{
            symptomArrayList = new ArrayList<Symptom>();

            symptomArrayList.add(new Symptom(1,"coughing", "A cough is a forceful release of air from the lungs that can be heard.", 1, 2, 1, 3));
            symptomArrayList.add(new Symptom(2,"sneezing", "A sneeze is a sudden involuntary expulsion of air from the nose and mouth due to irritation of one's nostrils.", 1, 2, 1, 4));
            symptomArrayList.add(new Symptom(3,"sweating", "Sweating is moisture exuded through the pores of the skin, typically in profuse quantities as a reaction to heat, physical exertion, fever, or fear.", 1,1,3, 3));
            symptomArrayList.add(new Symptom(4, "chills", "Chills are a sensation of coldness, often accompanied by shivering and pallor of the skin.", 2, 0, 3, 7));
            symptomArrayList.add(new Symptom(5, "fatigue", "Fatigue: extreme tiredness, typically resulting from mental or physical exertion or illness.", 2, 0, 4, 5));
            symptomArrayList.add(new Symptom(6, "nausea", "Nausea is a feeling of sickness with an inclination to vomit.", 2, 1, 3, 8));
            symptomArrayList.add(new Symptom(7, "vomit", "To vomit is to eject matter from the stomach through the mouth.", 3, 3, 2, 11));
            symptomArrayList.add(new Symptom(8, "diarrhea", "Diarrhea is a condition in which feces are discharged from the bowels frequently and in a liquid form.",3,4,4, 13));
            symptomArrayList.add(new Symptom(9, "fever", "Fever is an abnormally high body temperature, usually accompanied by shivering, headache, and in severe instances, delirium.", 3, 2,6, 10));
            symptomArrayList.add(new Symptom(10, "blindness", "Blindness: unable to see; lacking the sense of sight; sightless", 4, 0, 10, 15));
            symptomArrayList.add(new Symptom(11, "seizure", "A Seizure is uncontrolled electrical activity in the brain, which may produce a physical convulsion, minor physical signs, thought disturbances, or a combination of symptoms.", 4, 0, 8, 18));
            symptomArrayList.add(new Symptom(12, "rash", "Rash: an eruption on the body typically with little or no elevation above the surface.", 4, 12, 6, 13));

            return symptomArrayList;
        }
    }

    public Symptom getSymptomFromListById(int id){
        for (Symptom s : symptomArrayList){
            if (s.get_id() == id)
                return s;
        }

        return null;

    }
}
