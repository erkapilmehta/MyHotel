package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.Utils.Constants;
import com.example.httpwww.reshotel.adapter.DataListAdapter;
import com.example.httpwww.reshotel.adapter.UserDataShowActivityAdapter;
import com.example.httpwww.reshotel.entities.UserInformation;

import Models.UserJsonWriter;

/**
 * Created by silenthacker on 06/04/16.
 */
public class UserDataShowActivity extends Activity {

    private String[] name;
    private String[] value;
    Intent intent;
    UserDataShowActivityAdapter adapter;
    String fName;

    private ListView dataListView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_user_data_activity);
        Log.d("Position====>", "you are in UserDataShowActivity");
        init();
        findViews();
        dataListView.setAdapter(adapter);
        listeners();
    }


    private void init()
    {
        name = new String[]{"Name        :", "Email         :", "Password  :", "Mobile No :", "Gender      :", "Country     :", "Phone        :","Date           :","Rating        :"};
        value= new String[9];

        intent = getIntent();
        fName=intent.getStringExtra(Constants.INTENT_FILE_NAME);
        UserJsonWriter useJsWr=new UserJsonWriter();

        UserInformation user=useJsWr.convertJsonToUser(fName);

            value[0] = user.getName();
            value[1] = user.getEmail();
            value[2] = user.getPassword();
            value[3] = user.getMobileNo();
            value[4]= user.getGender();
            value[5]= user.getCountry();
            value[6]=user.getIphone()+user.getAndroid()+user.getWindows();
            value[7]=user.getDate();
            value[8]=user.getRating();

        adapter= new UserDataShowActivityAdapter(UserDataShowActivity.this, name, value);
    }
    private void findViews()
    {
        dataListView = (ListView) findViewById(R.id.listview_userDataShowActivity_data_list);
    }
    private void listeners()
    {

    }

}
