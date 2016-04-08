package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.httpwww.reshotel.R;

import com.example.httpwww.reshotel.Utils.Constants;
import com.example.httpwww.reshotel.adapter.UserListAdapter;
import com.example.httpwww.reshotel.entities.UserInformation;
import com.example.httpwww.reshotel.fragment.MemberFragment;
import com.example.httpwww.reshotel.fragment.UserDetailShowFragment;
import com.example.httpwww.reshotel.fragment.UserListFragment;

import java.io.File;
import java.util.ArrayList;

import Models.UserJsonWriter;


/**
 * Created by silenthacker on 04/04/16.
 */
public class UserListActivity extends Activity {



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
       Fragment userListFragment=new UserListFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_userList, userListFragment);
        fragmentTransaction.commit();

    }
}





