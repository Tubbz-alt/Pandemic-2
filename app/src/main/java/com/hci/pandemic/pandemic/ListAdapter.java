package com.hci.pandemic.pandemic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by andrewparrish on 12/2/14.
 */
public class ListAdapter extends ArrayAdapter<String>{
    private final Context context;
    private final String[] values;

    public ListAdapter(Context context, String[] values) {
        super(context, R.layout.activity_leaderboard, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_leaderboard, parent, false);

        TextView firstRow = (TextView) rowView.findViewById(R.id.first_line);
        TextView secondRow = (TextView) rowView.findViewById(R.id.second_line);

        firstRow.setText(values[position]);
        secondRow.setText("Test");

        return rowView;
    }

}
