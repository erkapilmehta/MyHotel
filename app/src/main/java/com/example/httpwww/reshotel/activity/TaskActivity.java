package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;

/**
 * Created by silenthacker on 31/03/16.
 */
public class TaskActivity extends Activity {
    TextView text;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);

        init();
        findViews();
        text.setText("No data is available to display");
        listeners();

    }


    private void init()
    {
        text= new TextView(TaskActivity.this);
    }
    private void findViews()
    {
        text = (TextView) findViewById(R.id.textview_otherTask);
    }
    private void listeners()
    {


    }

}
