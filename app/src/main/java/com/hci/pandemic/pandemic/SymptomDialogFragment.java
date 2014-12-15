package com.hci.pandemic.pandemic;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Tuxedo on 12/15/14.
 */
public class SymptomDialogFragment extends DialogFragment {


    /* The activity that creates an instance of this dialog fragment must
 * implement this interface in order to receive event callbacks.
 * Each method passes the DialogFragment in case the host needs to query it. */
    public interface SymptomsDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog, int SymptomID);
        public void onDialogNegativeClick(DialogFragment dialog, int SymptomID);
    }

    // Use this instance of the interface to deliver action events
    SymptomsDialogListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // unpack the bundle
        Bundle bundle = getArguments();

        final int symptomID = bundle.getInt("id");
        String name = bundle.getString("name");
        String description = bundle.getString("description");
        int level = bundle.getInt("level");
        int contagious = bundle.getInt("contagious");
        int lethality = bundle.getInt("lethality");
        int unlock = bundle.getInt("points_to_unlock");
        boolean has_unlocked = bundle.getBoolean("has_unlocked");


        // builder message
        String line_name = "Symptom Name: " + name;
        String line_contagious = "Contagiousness: " + contagious;
        String line_lethality = "Lethality: " + lethality;
        String line_unlock = "Points to unlock: " + unlock;
        String line_confirm = "Do you want to purchase this symptom?";

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(line_name + "\n\n" +
                           description + "\n\n" +
                           line_contagious + "\n\n" +
                           line_lethality + "\n\n" +
                           line_unlock + "\n\n" +
                           line_confirm)

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User accepted the setting
                        // Send the positive button event back to the host activity
                        mListener.onDialogPositiveClick(SymptomDialogFragment.this, symptomID);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        mListener.onDialogPositiveClick(SymptomDialogFragment.this, symptomID);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }


    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (SymptomsDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }
}
