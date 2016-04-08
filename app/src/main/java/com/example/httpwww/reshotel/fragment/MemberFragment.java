package com.example.httpwww.reshotel.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.Utils.Constants;
import com.example.httpwww.reshotel.adapter.UserListAdapter;
import com.example.httpwww.reshotel.entities.UserInformation;

import java.io.File;
import java.util.ArrayList;

import Models.UserJsonWriter;

/**
 * Created by silenthacker on 06/04/16.
 */
public class MemberFragment extends Fragment {
    private String[] userArray;

    private ListView userListView;
    UserListAdapter adapter;
    UserInformation[] userObjectArray;
    String[] userNameArray;
    String name;
    View rootView;


    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.member_fragment_view, container, false);
        init();
        findViews();
        userListView.setAdapter(adapter);
        listeners();

        return rootView;



    }
    /**
     * Called when the activity is first created.
     */

    private void init() {
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


        adapter = new UserListAdapter(getActivity(), userNameArray);


    }

    private void findViews() {

        userListView = (ListView) rootView.findViewById(R.id.listview_user_list);
    }

    private void listeners() {
        userListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String clickedValue = userArray[position];
//
//                Intent i = new Intent(UserListActivity.this, UserDataShowActivity.class);
//                i.putExtra(Constants.INTENT_FILE_NAME,clickedValue);
//                setData(clickedValue);
//                startActivity(i);
                Bundle bundle = new Bundle();
                bundle.putString(Constants.INTENT_FILE_NAME, clickedValue);
                Fragment memberFragment = new UserDetailShowFragment();
                FragmentManager fm = getFragmentManager();
                memberFragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.member_fragment_place, memberFragment);
                fragmentTransaction.commit();
//                    SupportFragmentManager fragmentManager=getFragmentManager();
//                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.user_data_fragment,userDataFragment);
//                    fragmentTransaction.commit();
            }
        });


    }


}
