package com.example.httpwww.reshotel.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;

/**
 * Created by silenthacker on 08/04/16.
 */
public class DataFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.data_fragment_layout, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textview_datafragment_name);
        textView.setText("Hello guys");

        return view;
    }
}
