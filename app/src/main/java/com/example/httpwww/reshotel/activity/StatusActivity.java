package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


import com.example.httpwww.reshotel.R;


/**
 * Created by silenthacker on 31/03/16.
 */
public class StatusActivity extends Activity implements AdapterView.OnItemSelectedListener{
     String country =null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);

        final EditText fullName= (EditText) findViewById(R.id.full_name);
        final EditText email= (EditText) findViewById(R.id.email);
        final EditText password= (EditText) findViewById(R.id.password);
        final EditText mobileNo= (EditText) findViewById(R.id.mobile_no);
        final RadioGroup radioButtonGroup= (RadioGroup) findViewById(R.id.radio_btn_group);

        final String gender=((RadioButton)findViewById(radioButtonGroup.getCheckedRadioButtonId() )).getText().toString();
        Spinner spinnerObject= (Spinner) findViewById(R.id.spinner1);
        spinnerObject.setOnItemSelectedListener(this);

        final CheckBox cbox1= (CheckBox) findViewById(R.id.chkIos);
        final CheckBox cbox2= (CheckBox) findViewById(R.id.chkAndroid);
        final CheckBox cbox3= (CheckBox) findViewById(R.id.chkWindows);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        final String date=" "+day+" "+month+" "+year;

        Button getStatus= (Button) findViewById(R.id.get_status);
        getStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(StatusActivity.this, ShowActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",fullName.getText().toString());
                bundle.putString("email", email.getText().toString());
                bundle.putString("password", password.getText().toString());
                bundle.putString("mobileNo", mobileNo.getText().toString());
                bundle.putString("gender", gender);
                bundle.putString("country", country);

                if (cbox1.isChecked()) bundle.putString("Ios",cbox1.getText().toString());
                if (cbox2.isChecked()) bundle.putString("Android",cbox2.getText().toString());
                if (cbox3.isChecked()) bundle.putString("Windows",cbox3.getText().toString());
                bundle.putString("date",date);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
       country= parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
