package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.adapter.OwnerShowAdapter;
import com.example.httpwww.reshotel.entities.UserInformation;

import java.io.File;
import java.util.ArrayList;

import Models.UserJsonWriter;

/**
 * Created by silenthacker on 07/04/16.
 */
public class IntentShowActivity extends Activity {

    private String[] userArray;
    View rootView;
    ListView userListView;
    OwnerShowAdapter adapter;
    UserInformation[] userObjectArray;
    String[] userNameArray;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_show_layout);

        init();
        findViews();
        Log.d("After findView===>", "Ferfect run");

        listeners();

    }

    private void init()
    {
        ArrayList<String> arr = new ArrayList<String>();
        File file = new File("/sdcard/myfile/");
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                arr.add(f.getName());

            }

        }
        userArray = new String[arr.size()];
        userNameArray = new String[arr.size()];
        UserJsonWriter userJsonWriter = new UserJsonWriter();
        userArray = arr.toArray(new String[arr.size()]);
        userObjectArray = new UserInformation[arr.size()];
        for (int index = 0; index < arr.size(); index++) {
            userObjectArray[index] = userJsonWriter.convertJsonToUser(userArray[index]);

        }
        for (int index = 0; index < arr.size(); index++) {
            userNameArray[index] = userObjectArray[index].getName();

        }
        Log.d("User Name",userNameArray[1]);


        adapter=new OwnerShowAdapter(IntentShowActivity.this,userNameArray);


    }
    private void findViews()
    {
        userListView = (ListView) findViewById(R.id.listview_intentShowActivity);
        userListView.setAdapter(adapter);
    }
    private void listeners()
    {
        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {


            }
        });
    }

}
