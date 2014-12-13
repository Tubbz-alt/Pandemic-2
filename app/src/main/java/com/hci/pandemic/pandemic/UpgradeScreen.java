package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class UpgradeScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upgrade_screen);
        Button button = (Button) findViewById(R.id.button_coughing);
        button.setOnClickListener(new SymptomsOnClickListener());
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

    private class SymptomsOnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

        }
    }

}
