package com.example.httpwww.reshotel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.ShowActivity;
import com.example.httpwww.reshotel.holder.DataListHolder;
import com.example.httpwww.reshotel.holder.UserListHolder;
import com.example.httpwww.reshotel.holder.ViewHolder;

/**
 * Created by silenthacker on 05/04/16.
 */
public class ShowUserFragmentAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private String[] name;
    private String[] value;
    public ShowUserFragmentAdapter(Context context,
                           String[] name, String[] value) {
        mInflater = LayoutInflater.from(context);
        this.name = name;
        this.value = value;

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
        // TODO Auto-generated method stub
        DataListHolder holder=new DataListHolder();
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.data_list_fragment_single, null);
            holder.text1 = (TextView) convertView.findViewById(R.id.textview_userFragmentListAdapter_name);
            holder.text2 = (TextView) convertView.findViewById(R.id.textview_userFagmentListAdapter_value);

            convertView.setTag(holder);
        } else {
            holder = (DataListHolder)convertView.getTag();
        }

        holder.text1.setText(name[position]);
        holder.text2.setText(value[position]);

        return convertView;
    }

}
