package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
public class OwnerShowActivity extends Activity {

    private String[] ownerArray;
    View rootView;
    ListView ownerListView;
    OwnerShowAdapter adapter;
    UserInformation[] ownerObjectArray;
    String[] ownerNameArray;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.owner_show_activity);

        init();
        findViews();
        ownerListView.setAdapter(adapter);
        listeners();

    }



    public void init()
    {
        ArrayList<String> arr = new ArrayList<String>();
        File file = new File("/sdcard/myfile/");
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                arr.add(f.getName());

            }

        }
        ownerArray = new String[arr.size()];
        ownerNameArray = new String[arr.size()];
        UserJsonWriter userJsonWriter = new UserJsonWriter();
        ownerArray = arr.toArray(new String[arr.size()]);
        ownerObjectArray = new UserInformation[arr.size()];
        for (int index = 0; index < arr.size(); index++) {
            ownerObjectArray[index] = userJsonWriter.convertJsonToUser(ownerArray[index]);

        }
        for (int index = 0; index < arr.size(); index++) {
            ownerNameArray[index] = ownerObjectArray[index].getName();

        }

    }
    public void findViews()
    {

    }

    public void listeners()
    {

    }

}
