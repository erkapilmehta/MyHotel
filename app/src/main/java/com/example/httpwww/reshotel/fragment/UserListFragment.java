package com.example.httpwww.reshotel.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.activity.UserListActivity;
import com.example.httpwww.reshotel.adapter.UserListFragmentAdapter;
import com.example.httpwww.reshotel.entities.UserInformation;

import java.io.File;
import java.util.ArrayList;

import Models.UserJsonWriter;

/**
 * Created by silenthacker on 06/04/16.
 */
public class UserListFragment extends ListFragment {
    private String[] userArray;
    View rootView;
    ListView userListView;
    UserListFragmentAdapter adapter;
    UserInformation[] userObjectArray;
    String[] userNameArray;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.user_list_fragment_layout, container, false);
        init();
        findViews();
        Log.d("After findView===>","Ferfect run");
        userListView.setAdapter(adapter);
        listeners();

        return rootView;
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

        adapter=new UserListFragmentAdapter(getActivity(),userNameArray);

    }
    private void findViews()
    {
        userListView = (ListView) getActivity().findViewById(R.id.listview_user_list_fragment);
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