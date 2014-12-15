package com.hci.pandemic.pandemic;

import android.app.ListActivity;
import android.content.Intent;
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
        dbHelper.addUser("Andrew Parrish", "Senioritis");
        dbHelper.addUser("Izzy Coronado", "Ebola");
        dbHelper.addUser("Naveed N", "Swine Flu");
        dbHelper.addUser("Steven Ma", "SARS");
        dbHelper.addUser("Jon Frolich", "Newbabysyndrome");
        dbHelper.addUser("Mike Krzyzewski", "Vaginitis");
        dbHelper.addUser("Tay Swift", "Feelingtwentytwo");
        dbHelper.addUser("Michael Scott", "Scottstots");
        dbHelper.addUser("President Obama", "POTUSitis");
        dbHelper.addUser("Wallace Loh", "Eloha");

        final List<User> users = dbHelper.getAllUsers();
        Collections.sort(users);

        final String[] values = new String[]{"Player One", "Player Two", "", "", "", "",
            "", "", "", ""};
                /*,
            "Player Three", "Player Four", "Player Five", "Player Six",
            "Player Seven", "Player Eight", "Player Nine", "Player Ten", "Player Eleven",
            "Player Twelve", "Player Thirteen", "Player Fourteen"};*/

        ArrayAdapter<String> adapter = new ListAdapter(this, values, (ArrayList<User>) users);
        setListAdapter(adapter);

        final TextView tv = (TextView) findViewById(R.id.leaderboard_popup);
        final TextView instruction = (TextView) findViewById(R.id.popupinstruction);

        //ListView lv = getListView();

        LayoutInflater inflater = getLayoutInflater();
        View header = inflater.inflate(R.layout.header, getListView(), false);
        
        // error here
       // lv.addHeaderView(header);
        getListView().addHeaderView(header,null,false);


        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Info", String.valueOf(position));
                tv.setText("Username: "+users.get(position).Name() + "\n\n" +
                    "This is where in a full game additional information could be shown about the user");
                tv.setVisibility(View.VISIBLE);
                instruction.setVisibility(View.VISIBLE);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setVisibility(View.INVISIBLE);
                instruction.setVisibility(View.INVISIBLE);
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
            Intent intent = new Intent(this, MapActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else if (id == R.id.upgrade_screen_menu) {
            Intent intent = new Intent(this, UpgradeScreen.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        } else if (id == R.id.leaderboard_screen_menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
