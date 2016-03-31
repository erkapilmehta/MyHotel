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
import com.example.httpwww.reshotel.holder.ViewHolder;

public class CustomListAdapter extends BaseAdapter{

    private Context context;
    private String[] web;
    private Integer[] imageId;
    public CustomListAdapter(Context context,
                      String[] web, Integer[] imageId) {
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }

    @Override
    public int getCount() {
        return 15;
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

        ViewHolder holder=new ViewHolder();
        LayoutInflater inflater =  ((ListActivity)context).getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single, null, true);
        holder.text = (TextView) rowView.findViewById(R.id.txt);

        holder.icon = (ImageView) rowView.findViewById(R.id.img);
        holder.text.setText(web[position]);

        holder.icon.setImageResource(imageId[position]);
        return rowView;
    }
}
