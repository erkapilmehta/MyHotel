package com.example.httpwww.reshotel.fragment;



import android.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;




import com.example.httpwww.reshotel.R;

import com.example.httpwww.reshotel.Utils.Constants;
import com.example.httpwww.reshotel.adapter.ShowUserFragmentAdapter;
import com.example.httpwww.reshotel.adapter.UserDataShowActivityAdapter;
import com.example.httpwww.reshotel.entities.UserInformation;

import Models.UserJsonWriter;


/**
 * Created by silenthacker on 05/04/16.
 */
public class UserDetailShowFragment extends Fragment {


    private String[] name;
    String fName;
    private String[] value;
    ShowUserFragmentAdapter adapter;

    View rootView;
        public View onCreateView(LayoutInflater inflater,ViewGroup container,
                                 Bundle savedInstanceState) {

          rootView = inflater.inflate(R.layout.show_user_details_fragment, container, false);
            Log.d("Position=====>", "Now you are in UserDetailShowFragment");
            Bundle bundle = this.getArguments();
            if(bundle != null) {
                fName=bundle.getString(Constants.INTENT_FILE_NAME);
                Log.d("Value of file====>",fName);
            }
            try {
                init();
            }catch (Exception e){
                e.printStackTrace();
            }


            return rootView;

        }


    private void init()
    {
        name = new String[]{"Name        :", "Email         :", "Password  :", "Mobile No :", "Gender      :", "Country     :", "Phone        :","Date           :","Rating        :"};
        value= new String[9];


        Log.d("Position=====>", "Now you are in init");

        UserJsonWriter useJsWr=new UserJsonWriter();

        UserInformation user=useJsWr.convertJsonToUser(fName);
        Log.d("User Name =====>",user.getName());

            value[0] = user.getName();
            value[1] = user.getEmail();
            value[2] = user.getPassword();
            value[3] = user.getMobileNo();
            value[4]= user.getGender();
            value[5]= user.getCountry();
            value[6]=user.getIphone()+user.getAndroid()+user.getWindows();
            value[7]=user.getDate();
            value[8]=user.getRating();
        adapter= new ShowUserFragmentAdapter(getActivity(), name, value);

        ListView lv = (ListView)rootView.findViewById(R.id.listview_userdata_fragment_data_list);

        lv.setAdapter(adapter);

    }
    private void findViews()
    {

    }
    private void listeners()
    {

    }


}

