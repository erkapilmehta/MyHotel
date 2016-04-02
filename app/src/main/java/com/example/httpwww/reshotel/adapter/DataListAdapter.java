package com.example.httpwww.reshotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.RoomActivity;
import com.example.httpwww.reshotel.activity.ShowActivity;
import com.example.httpwww.reshotel.holder.DataListHolder;
import com.example.httpwww.reshotel.holder.ViewHolder;

/**
 * Created by silenthacker on 02/04/16.
 */public class DataListAdapter extends BaseAdapter {

    private Context context;
    private String[] name;
    private String[] value;
    public DataListAdapter(Context context,
                           String[] name, String[] value) {
        this.context = context;
        this.name = name;
        this.value = value;

    }

    @Override
    public int getCount() {
        return 7;
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
    public View getView(int position, View view, ViewGroup parent) {

        DataListHolder holder=new DataListHolder();
        LayoutInflater inflater =  ((ShowActivity)context).getLayoutInflater();
        View rowView= inflater.inflate(R.layout.data_list_single, null, true);
        holder.text1 = (TextView) rowView.findViewById(R.id.textview_dataListAdapter_name);
        holder.text2 = (TextView) rowView.findViewById(R.id.textview_dataListAdapter_value);

        holder.text1.setText(name[position]);
        holder.text2.setText(value[position]);


        return rowView;
    }
}

