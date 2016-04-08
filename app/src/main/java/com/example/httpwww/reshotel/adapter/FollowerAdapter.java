package com.example.httpwww.reshotel.adapter;

/**
 * Created by silenthacker on 08/04/16.
 */
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.entities.TwitUserInformation;

public class FollowerAdapter extends ArrayAdapter<TwitUserInformation> {


    private List<TwitUserInformation> planetList;
    private Context context;

    public FollowerAdapter(List<TwitUserInformation> planetList, Context ctx) {
        super(ctx, R.layout.follower_fragment_data_single, planetList);
        this.planetList = planetList;
        this.context = ctx;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

// First let's verify the convertView is not null
        if (convertView == null) {
// This a new view we inflate the new layout
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.follower_fragment_data_single, parent, false);
        }
// Now we can fill the layout with the right values
        TextView id = (TextView) convertView.findViewById(R.id.follower_listview_id);
        TextView username = (TextView) convertView.findViewById(R.id.follower_listview_username);
        TextView timezone = (TextView) convertView.findViewById(R.id.follower_listview_timezone);

        TwitUserInformation user = planetList.get(position);

        id.setText(user.getId());
        username.setText(user.getUsername());
        timezone.setText(user.getTimezone());

        return convertView;
    }
}
