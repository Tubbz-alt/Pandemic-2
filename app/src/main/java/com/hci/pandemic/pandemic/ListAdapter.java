package com.hci.pandemic.pandemic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by andrewparrish on 12/2/14.
 */
public class ListAdapter extends ArrayAdapter<String>{
    private final Context context;
    private final String[] values;
    private final ArrayList<User> users;

    public ListAdapter(Context context, String[] values, ArrayList<User> users) {
        super(context, R.layout.activity_leaderboard, values);
        this.context = context;
        this.values = values;
        this.users = users;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_leaderboard, parent, false);

        TextView number = (TextView) rowView.findViewById(R.id.number);
        TextView firstRow = (TextView) rowView.findViewById(R.id.first_line);
        TextView secondRow = (TextView) rowView.findViewById(R.id.second_line);

        int counter = position + 1;
        number.setText("#"+counter);
        firstRow.setText(users.get(position).DiseaseName());
        secondRow.setText("Score: " + users.get(position).Score());

        return rowView;
    }

}
