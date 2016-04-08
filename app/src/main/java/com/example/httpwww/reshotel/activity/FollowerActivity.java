package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.fragment.FollowerListFragment;

/**
 * Created by silenthacker on 08/04/16.
 */
public class FollowerActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.follower_layout);
        Fragment newFragment = new FollowerListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.list_follower_fragment, newFragment);
        transaction.commit();

    }
}
