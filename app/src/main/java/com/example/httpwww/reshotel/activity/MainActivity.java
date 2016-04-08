package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.adapter.MainActivityAdapter;
import com.example.httpwww.reshotel.entities.TwitUserInformation;

import java.io.Serializable;
import java.util.List;

import Models.TwitUserJson;

/**
 * Created by silenthacker on 07/04/16.
 */
public class MainActivity extends Activity {
    private String[] userArray;
    private String[] idArray;
    MainActivityAdapter adapter;
    ListView user_list;
    private String [] descriptionArray;
    private String [] timezoneArray;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        TwitUserJson tuj=new TwitUserJson();
        final List<TwitUserInformation> twuser= tuj.convertJsonToUser("newData.txt");

        Log.d("Username is",twuser.get(0).getUsername());

        userArray=new String[twuser.size()];
        idArray=new String[twuser.size()];
        descriptionArray =new String[twuser.size()];
        timezoneArray=new String[twuser.size()];
        for(int index=0;index<twuser.size();index++)
        {
            userArray[index]=twuser.get(index).getUsername();
        }

        for(int index=0;index<twuser.size();index++)
        {
            idArray[index]=twuser.get(index).getId();
        }
        for(int index=0;index<twuser.size();index++)
        {
          descriptionArray[index]=twuser.get(index).getCreated_at();
        }
        for(int index=0;index<twuser.size();index++)
        {
            timezoneArray[index]=twuser.get(index).getTimezone();
        }
        adapter = new MainActivityAdapter(MainActivity.this,idArray, userArray,descriptionArray,timezoneArray);
        user_list= (ListView) findViewById(R.id.listview_mainActivity_user);
        user_list.setAdapter(adapter );


       user_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position,
                                   long id) {


                   Intent intent = new Intent(getApplicationContext(), TwitUserShowActivity.class);

                    intent.putExtra("MyClass", (Serializable) twuser.get(position));
                    startActivity(intent);

           }

       });


    }
}
