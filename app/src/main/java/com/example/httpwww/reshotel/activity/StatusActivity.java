package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
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
import android.widget.SeekBar;
import android.widget.Spinner;


import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.Utils.Constants;


/**
 * Created by silenthacker on 31/03/16.
 */
public class StatusActivity extends Activity implements AdapterView.OnItemSelectedListener {
    String country = null;
     EditText fullName;;
     EditText email;
     EditText password;
     EditText mobileNo;
     RadioGroup radioButtonGroup;
     CheckBox cbox1;
     CheckBox cbox2;
     CheckBox cbox3;
     Spinner spinnerObject;
     String gender;
    SeekBar seekBar;
    Button getStatus;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);
        spinnerObject.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        country = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    private void init()
    {
        gender = ((RadioButton) findViewById(radioButtonGroup.getCheckedRadioButtonId())).getText().toString();
        getStatus = (Button) findViewById(R.id.button_statusActivity_get_status);

    }
    private void findViews()
    {
        fullName = (EditText) findViewById(R.id.edittext_statusActivity_full_name);
        email = (EditText) findViewById(R.id.edittext_statusActivity_email);
        password = (EditText) findViewById(R.id.edittext_statusActivity_password);
        mobileNo = (EditText) findViewById(R.id.edittext_statusActivity_mobile_no);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radiogroup_statusActivity_radio_btn_group);
        cbox1 = (CheckBox) findViewById(R.id.checkbox_statusActivity_ios);
        cbox2 = (CheckBox) findViewById(R.id.checkbox_statusActivity_android);
        cbox3 = (CheckBox) findViewById(R.id.checkbox_statusActivity_windows);
        spinnerObject = (Spinner) findViewById(R.id.spinner_statusActivity_country);
        seekBar = (SeekBar)findViewById(R.id.seekbar_statusActivity_range);
    }
    private void listeners()
    {
        getStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(StatusActivity.this, ShowActivity.class);

                i.putExtra(Constants.INTENT_NAME, fullName.getText().toString());
                i.putExtra(Constants.INTENT_EMAIL, email.getText().toString());
                i.putExtra(Constants.INTENT_PASSWORD, password.getText().toString());
                i.putExtra(Constants.INTENT_MOBILE_NO, mobileNo.getText().toString());
                i.putExtra(Constants.INTENT_GENDER, gender);
                i.putExtra(Constants.INTENT_COUNTRY, country);
                if (cbox1.isChecked()) i.putExtra(Constants.INTENT_ANDROID,cbox1.getText().toString());
                else if(!cbox1.isChecked()) i.putExtra(Constants.INTENT_ANDROID,"");
                if (cbox2.isChecked()) i.putExtra(Constants.INTENT_IOS,cbox2.getText().toString());
                else if (!cbox2.isChecked()) i.putExtra(Constants.INTENT_IOS,"");
                if (cbox3.isChecked()) i.putExtra(Constants.INTENT_WINDOWS,cbox3.getText().toString());
                else if (!cbox3.isChecked()) i.putExtra(Constants.INTENT_WINDOWS,"");


                startActivity(i);
            }
        });

    }
}


