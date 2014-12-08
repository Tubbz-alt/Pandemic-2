package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import com.hci.pandemic.pandemic.upgrade_screen.UpgradeScreen;

// izzy wuz here
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button to_upgrade_screen = (Button) findViewById(R.id.upgrade_screen);
        to_upgrade_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upgrade_screen_intent = new Intent(MainActivity.this, UpgradeScreen.class);
                MainActivity.this.startActivity(upgrade_screen_intent);
            }
        });

        final Button to_leaderboard = (Button) findViewById(R.id.leaderboard);
        to_leaderboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent leaderboard_intent = new Intent(MainActivity.this, Leaderboard.class);
                MainActivity.this.startActivity(leaderboard_intent);
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
