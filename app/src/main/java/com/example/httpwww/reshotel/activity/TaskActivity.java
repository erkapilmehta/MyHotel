package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;

/**
 * Created by silenthacker on 31/03/16.
 */
public class TaskActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);

       TextView t = new TextView(this);

        t = (TextView) findViewById(R.id.textView);
        t.setText("No data is available to display");
    }


    }
