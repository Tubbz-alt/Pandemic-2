package com.hci.pandemic.pandemic.upgrade_screen;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

//import com.hci.pandemic.pandemic.R;

/**
 * Created by Izzy on 12/3/2014.
 */
public class SymptomsOnClickListener implements OnClickListener {

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        //R.id.bottomText // do something
        // put in bottomText the buttonText and the info associated with them
    }
}
