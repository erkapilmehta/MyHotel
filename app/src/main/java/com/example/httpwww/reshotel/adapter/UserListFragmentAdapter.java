package com.example.httpwww.reshotel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.UserDataShowActivity;
import com.example.httpwww.reshotel.activity.UserListActivity;
import com.example.httpwww.reshotel.holder.DataListHolder;
import com.example.httpwww.reshotel.holder.UserListHolder;

/**
 * Created by silenthacker on 07/04/16.
 */
public class UserListFragmentAdapter extends BaseAdapter{


    private Context context;
    private String[] name;

    public UserListFragmentAdapter(Context context, String[] name) {
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

        Log.d("Position===>","You are in getView");
        UserListHolder holder=new UserListHolder();
        LayoutInflater inflater =  ((UserListActivity)context).getLayoutInflater();
        View rowView= inflater.inflate(R.layout.user_list_fragment_single, null, true);
        holder.text1 = (TextView) rowView.findViewById(R.id.textview_user_list_fragment_name);

        holder.text1.setText(name[position]);

        return rowView;
    }
}
