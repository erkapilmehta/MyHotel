package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.fragment.DataFragment;

/**
 * Created by silenthacker on 08/04/16.
 */
public class DataActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_layout);
        Fragment newFragment = new DataFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.data_fragment, newFragment);
        transaction.commit();


    }
}
