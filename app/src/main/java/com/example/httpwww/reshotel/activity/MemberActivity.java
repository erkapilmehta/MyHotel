package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.fragment.MemberFragment;

/**
 * Created by silenthacker on 06/04/16.
 */
public class MemberActivity extends Activity {

    TextView t;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_activity);
//        Bundle bundle=new Bundle();
//        bundle.putString("hello","Hello World");
//        MemberFragment memberFragment=new MemberFragment();
//        FragmentManager fm = getFragmentManager();
//        memberFragment.setArguments(bundle);
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//        fragmentTransaction.replace(R.id.member_fragment_place, memberFragment);
//        fragmentTransaction.commit();



    }


}
