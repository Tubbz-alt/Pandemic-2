package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // button that launches the upgrade screen activity
        final Button to_upgrade_screen = (Button) findViewById(R.id.upgrade_screen);
        to_upgrade_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.launchUpgradeScreenActivity(getApplicationContext());
            }
        });

        //button that launches the leaderboard activity
        final Button to_leaderboard = (Button) findViewById(R.id.leaderboard);
        to_leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.launchLeaderboardActivity(getApplicationContext());
            }
        });

        // button that launches the map activity
        final Button to_map_screen = (Button) findViewById(R.id.map_screen_activity);
        to_map_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.launchMapActivity(getApplicationContext());
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
