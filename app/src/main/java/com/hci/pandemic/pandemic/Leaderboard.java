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


public class Leaderboard extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard_combo);

        final String[] values = new String[]{"Player One", "Player Two",
            "Player Three", "Player Four", "Player Five", "Player Six",
            "Player Seven", "Player Eight", "Player Nine", "Player Ten", "Player Eleven",
            "Player Twelve", "Player Thirteen", "Player Fourteen"};

        ArrayAdapter<String> adapter = new ListAdapter(this, values);
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
        getMenuInflater().inflate(R.menu.menu_leaderboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
