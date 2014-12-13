package com.hci.pandemic.pandemic;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Leaderboard extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_combo);

        DBHelper dbHelper = new DBHelper(this);
        if (dbHelper.getUserCount() == 0){
            dbHelper.addUser("Andrew Parrish", "Senioritis");
            dbHelper.addUser("Izzy Coronado", "Ebola");
            dbHelper.addUser("Naveed N", "Swine Flu");
            dbHelper.addUser("Steven Ma", "SARS");
            dbHelper.addUser("Jon Frolich", "Newbabysyndrome");
        }

        List<User> users = dbHelper.getAllUsers();
        Collections.sort(users);

        final String[] values = new String[]{"Player One", "Player Two", "", "", ""};
                /*,
            "Player Three", "Player Four", "Player Five", "Player Six",
            "Player Seven", "Player Eight", "Player Nine", "Player Ten", "Player Eleven",
            "Player Twelve", "Player Thirteen", "Player Fourteen"};*/

        ArrayAdapter<String> adapter = new ListAdapter(this, values, (ArrayList<User>) users);
        setListAdapter(adapter);

        final TextView tv = (TextView) findViewById(R.id.leaderboard_popup);

        ListView lv = getListView();

        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.header, lv, false);
        lv.addHeaderView(header, null, false);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Info", String.valueOf(position));
                tv.setText("THIS IS A MOTHERFUCKING DESCRIPTION");
                tv.setVisibility(View.VISIBLE);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.INVISIBLE);
            }
        });

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
            Util.launchMapActivity(this);
            return true;
        } else if (id == R.id.upgrade_screen_menu) {
            Util.launchUpgradeScreenActivity(this);
            return true;
        } else if (id == R.id.leaderboard_screen_menu) {
            Util.launchLeaderboardActivity(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
