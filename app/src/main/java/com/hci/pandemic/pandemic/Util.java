package com.hci.pandemic.pandemic;

import android.content.Context;
import android.content.Intent;

import com.hci.pandemic.pandemic.upgrade_screen.UpgradeScreen;

/**
 * Created by Tuxedo on 12/7/14.
 */

/* class of utility methods that can be used to reduce boilerplate and de-obfuscate things*/
public class Util {

// auxiliary static methods to launch a specific activity - can be used from anywhere in the app

    public static void launchMapActivity(Context context) {
        Intent intent = new Intent(context, MapActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void launchUpgradeScreenActivity(Context context){
        Intent intent = new Intent(context, UpgradeScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void launchLeaderboardActivity(Context context){
        Intent intent = new Intent(context, Leaderboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
