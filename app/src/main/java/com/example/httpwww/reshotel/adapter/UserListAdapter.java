package com.example.httpwww.reshotel.adapter;

/**
 * Created by silenthacker on 30/03/16.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.ListActivity;
import com.example.httpwww.reshotel.activity.UserListActivity;
import com.example.httpwww.reshotel.holder.UserListHolder;
import com.example.httpwww.reshotel.holder.ViewHolder;

public class UserListAdapter extends BaseAdapter{

    private Context context;
    private String[] web;
    public UserListAdapter(Context context,
                             String[] web) {
        this.context = context;
        this.web = web;


    }

    @Override
    public int getCount() {
        return web.length;
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

        UserListHolder holder=new UserListHolder();
        LayoutInflater inflater =  ((UserListActivity)context).getLayoutInflater();
        View rowView= inflater.inflate(R.layout.user_list_single, null, true);
        holder.text1 = (TextView) rowView.findViewById(R.id.textview_userListAdapter_name);

        holder.text1.setText(web[position]);
        return rowView;
    }
}
