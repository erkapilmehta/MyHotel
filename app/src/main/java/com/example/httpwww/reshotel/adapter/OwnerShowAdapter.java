package com.example.httpwww.reshotel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.IntentShowActivity;
import com.example.httpwww.reshotel.activity.UserListActivity;
import com.example.httpwww.reshotel.holder.UserListHolder;

/**
 * Created by silenthacker on 07/04/16.
 */
public class OwnerShowAdapter extends BaseAdapter {

    private Context context;
    private String[] name;

    public OwnerShowAdapter(Context context, String[] name) {
        this.context = context;
        this.name = name;
    }

    @Override
    public int getCount() {
        return name.length;
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
        UserListHolder holder=new UserListHolder();
        LayoutInflater inflater =  ((IntentShowActivity)context).getLayoutInflater();
        View rowView= inflater.inflate(R.layout.intent_content_list_single, parent, true);
        holder.text1 = (TextView) rowView.findViewById(R.id.textview_intentShowActivity_name);


        holder.text1.setText(name[position]);
        return rowView;
    }

}
