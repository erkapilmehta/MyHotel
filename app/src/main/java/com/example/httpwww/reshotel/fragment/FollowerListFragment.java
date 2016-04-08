package com.example.httpwww.reshotel.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.adapter.FollowerAdapter;
import com.example.httpwww.reshotel.entities.TwitUserInformation;

import java.util.List;

import Models.TwitUserJson;

/**
 * Created by silenthacker on 08/04/16.
 */
public class FollowerListFragment extends Fragment {

    FollowerAdapter adapter;
    ListView user_list;
    View view;
    TwitUserJson tuj;
    List<TwitUserInformation> twuser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.follower_fragment_layout, container, false);
        tuj=new TwitUserJson();
        twuser= tuj.convertJsonToUser("newData.txt");
        Log.d("Username is", twuser.get(0).getUsername());
        adapter = new FollowerAdapter(twuser,getActivity());

        user_list= (ListView) view.findViewById(R.id.follower_listview);

        user_list.setAdapter(adapter);

//        adapter = new FollowerAdapter(getActivity(),twuser);
//        user_list= (ListView) view.findViewById(R.id.follower_listview);
//        user_list.setAdapter(adapter );
        return view;
    }
    

}
