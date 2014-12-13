package com.hci.pandemic.pandemic;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Tuxedo on 12/7/14.
 */

/* class of utility methods that can be used to reduce boilerplate and de-obfuscate things*/
public class Util {

// auxiliary static methods to launch a specific activity - can be used from anywhere in the app

    // launch the Map Activity from whatever context you pass in
    public static void launchMapActivity(Context context) {
        Intent intent = new Intent(context, MapActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    // launch the Upgrade Screen Activity from whatever context you pass in
    public static void launchUpgradeScreenActivity(Context context){
        Intent intent = new Intent(context, UpgradeScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    // launch the Leaderboard Activity from whatever context you pass in
    public static void launchLeaderboardActivity(Context context){
        Intent intent = new Intent(context, Leaderboard.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
