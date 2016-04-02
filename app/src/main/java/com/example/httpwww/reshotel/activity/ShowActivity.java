package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.Utils.Constants;
import com.example.httpwww.reshotel.adapter.DataListAdapter;


/**
 * Created by silenthacker on 01/04/16.
 */
public class ShowActivity extends Activity {
    private String[] name;
    private String[] value;
    Intent intent;
    DataListAdapter adapter;

    private ListView dataListView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        dataListView.setAdapter(adapter);
    }


    private void init()
    {
        name = new String[]{"Name     ", "Email    ", "Password ", "Mobile No", "Gender   ", "Country  ", "Phone"};
        value= new String[7];
       intent = getIntent();
        if (null != intent) {
            value[0] = intent.getStringExtra(Constants.INTENT_NAME);
            value[1] = intent.getStringExtra(Constants.INTENT_EMAIL);
            value[2] = intent.getStringExtra(Constants.INTENT_PASSWORD);
            value[3] = intent.getStringExtra(Constants.INTENT_MOBILE_NO);
            value[4]= intent.getStringExtra(Constants.INTENT_GENDER);
            value[5]= intent.getStringExtra(Constants.INTENT_COUNTRY);
            value[6]=intent.getStringExtra(Constants.INTENT_ANDROID)+" "+intent.getStringExtra(Constants.INTENT_IOS)+" "+intent.getStringExtra(Constants.INTENT_WINDOWS);
        }

        adapter= new DataListAdapter(ShowActivity.this, name, value);
    }
    private void findViews()
    {
        dataListView = (ListView) findViewById(R.id.listview_showActivity_data_list);
    }
    private void listeners()
    {

    }

}
