package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;

/**
 * Created by silenthacker on 31/03/16.
 */
public class OtherTask extends Activity {
    TextView t;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show);


        init();
        findViews();
        listeners();
    }

    private void init()
    {
        t= new TextView(this);

    }
    private void findViews()
    {
        t = (TextView) findViewById(R.id.textview_otherTask);

    }
    private void listeners()
    {
        t.setText("Task is not available");
    }


}
