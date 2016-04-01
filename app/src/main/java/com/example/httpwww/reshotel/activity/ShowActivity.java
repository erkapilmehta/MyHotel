package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;

/**
 * Created by silenthacker on 01/04/16.
 */
public class ShowActivity extends Activity {
    TextView t;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_details);
        Bundle bundle =getIntent().getExtras();

        TextView t2 = new TextView(this);
        TextView t4 = new TextView(this);
        TextView t6 = new TextView(this);
        TextView t8 = new TextView(this);
        TextView t10 = new TextView(this);
        TextView t12 = new TextView(this);
        TextView t14 = new TextView(this);
        TextView t16 = new TextView(this);
        TextView t18 = new TextView(this);
        TextView t20 = new TextView(this);


        t2 = (TextView) findViewById(R.id.t2);
        t2.setText(bundle.getString("name"));
        t4 = (TextView) findViewById(R.id.t4);
        t4.setText(bundle.getString("email"));
        t6 = (TextView) findViewById(R.id.t6);
        t6.setText(bundle.getString("password"));
        t8 = (TextView) findViewById(R.id.t8);
        t8.setText(bundle.getString("mobileNo"));
        t10 = (TextView) findViewById(R.id.t10);
        t10.setText(bundle.getString("gender"));
        t12 = (TextView) findViewById(R.id.t12);
        t12.setText(bundle.getString("country"));
        t14 = (TextView) findViewById(R.id.t14);
        t14.setText(bundle.getString("Ios"));
        t16 = (TextView) findViewById(R.id.t16);
        t16.setText(bundle.getString("Android"));
        t18 = (TextView) findViewById(R.id.t18);
        t18.setText(bundle.getString("Windows"));
        t20= (TextView) findViewById(R.id.t20);
        t20.setText(bundle.getString("date"));



    }

}
