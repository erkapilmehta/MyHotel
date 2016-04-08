package com.example.httpwww.reshotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.MainActivity;
import com.example.httpwww.reshotel.holder.UserDataHolder;

/**
 * Created by silenthacker on 07/04/16.
 */
public class MainActivityAdapter extends BaseAdapter {
    String [] userArray;
    String [] idArray;
    String [] descriptionArray;
    String [] timezoneArray;
    Context context;

    public MainActivityAdapter(Context context,String[] idArray, String[] userArray,String[] descriptionArray,String [] timezoneArray) {
        this.idArray = idArray;
        this.userArray = userArray;
        this.context = context;
        this.descriptionArray=descriptionArray;
        this.timezoneArray=timezoneArray;
    }

    @Override
    public int getCount() {
        return idArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
         UserDataHolder holder=new UserDataHolder();
        LayoutInflater inflater =  ((MainActivity)context).getLayoutInflater();
        View rowView= inflater.inflate(R.layout.main_activity_single_listview, null, true);
        holder.id = (TextView) rowView.findViewById(R.id.listview_id);
        holder.user= (TextView) rowView.findViewById(R.id.listview_username);
        holder.create_at= (TextView) rowView.findViewById(R.id.listview_description);
        holder.timezone= (TextView) rowView.findViewById(R.id.listview_timezone);

        holder.id.setText(idArray[position]);
        holder.user.setText(userArray[position]);
        holder.create_at.setText(descriptionArray[position]);
        holder.timezone.setText(timezoneArray[position]);
        return rowView;
    }
}
