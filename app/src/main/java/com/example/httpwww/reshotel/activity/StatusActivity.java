package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.InputType;
import android.view.Menu;
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
import android.widget.Toast;


import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.Utils.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Created by silenthacker on 31/03/16.
 */
public class StatusActivity extends Activity implements AdapterView.OnItemSelectedListener {
    String country;
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
    EditText dateBox;
    Calendar myCalendar;
    String myFormat;
    SimpleDateFormat sdf;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);

        init();

        findViews();
        spinnerObject.setOnItemSelectedListener(this);
        listeners();


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

       myFormat = "d MMM,yyyy"; //In which you need put here
       sdf = new SimpleDateFormat(myFormat, Locale.US);

    }
    private void findViews()
    {
        fullName = (EditText) findViewById(R.id.edittext_statusActivity_full_name);
        email = (EditText) findViewById(R.id.edittext_statusActivity_email);
        password = (EditText) findViewById(R.id.edittext_statusActivity_password);
        mobileNo = (EditText) findViewById(R.id.edittext_statusActivity_mobile_no);
        radioButtonGroup = (RadioGroup) findViewById(R.id.radiogroup_statusActivity_radio_btn_group);
        gender = ((RadioButton) findViewById(radioButtonGroup.getCheckedRadioButtonId())).getText().toString();
        cbox1 = (CheckBox) findViewById(R.id.checkbox_statusActivity_ios);
        cbox2 = (CheckBox) findViewById(R.id.checkbox_statusActivity_android);
        cbox3 = (CheckBox) findViewById(R.id.checkbox_statusActivity_windows);
        spinnerObject = (Spinner) findViewById(R.id.spinner_statusActivity_country);
        getStatus = (Button) findViewById(R.id.button_statusActivity_get_status);
        dateBox= (EditText) findViewById(R.id.edittext_statusActivity_date);






    }
    private void listeners()
    {

        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dateBox.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                new DatePickerDialog(StatusActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        getStatus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                try {
                    File myFile = new File("/sdcard/form.txt");
                    myFile.createNewFile();
                    FileOutputStream fileout = new FileOutputStream(myFile);
                    OutputStreamWriter myOutWriter = new OutputStreamWriter(fileout);
                    myOutWriter.append("\n Name \t"+fullName.getText().toString());
                    myOutWriter.append("\n Email \t"+email.getText().toString());
                    myOutWriter.append("\n Password \t"+password.getText().toString());
                    myOutWriter.append("\n Mobile No. \t"+mobileNo.getText().toString());

                    if (cbox1.isChecked()) myOutWriter.append("\n IPhone \t" + "Y");
                    else if(!cbox1.isChecked())  myOutWriter.append( "\n IPhone \t"+"N");
                    if (cbox2.isChecked())  myOutWriter.append("\n Android \t" +"Y" );
                    else if (!cbox2.isChecked())  myOutWriter.append("\n Android \t" +"N" );
                    if (cbox3.isChecked())  myOutWriter.append("\n Windows \t"+"Y");
                    else if (!cbox3.isChecked())  myOutWriter.append("\n Windows \t"+"N");

                    myOutWriter.append("\n Date \t"+sdf.format(myCalendar.getTime()));
                    myOutWriter.close();
                    fileout.close();
                    Toast.makeText(getBaseContext(),"Your Data Saved in SD card",
                            Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
                Intent i = new Intent(StatusActivity.this, ShowActivity.class);

                i.putExtra(Constants.INTENT_NAME, fullName.getText().toString());
                i.putExtra(Constants.INTENT_EMAIL, email.getText().toString());
                i.putExtra(Constants.INTENT_PASSWORD, password.getText().toString());
                i.putExtra(Constants.INTENT_MOBILE_NO, mobileNo.getText().toString());
                i.putExtra(Constants.INTENT_GENDER, gender);
                i.putExtra(Constants.INTENT_COUNTRY, country);
                if (cbox1.isChecked()) i.putExtra(Constants.INTENT_ANDROID,"IPhone");
                else if(!cbox1.isChecked()) i.putExtra(Constants.INTENT_ANDROID,"");
                if (cbox2.isChecked()) i.putExtra(Constants.INTENT_IOS,"Android");
                else if (!cbox2.isChecked()) i.putExtra(Constants.INTENT_IOS,"");
                if (cbox3.isChecked()) i.putExtra(Constants.INTENT_WINDOWS,"Windows");
                else if (!cbox3.isChecked()) i.putExtra(Constants.INTENT_WINDOWS,"");

                i.putExtra(Constants.INTENT_DATE,sdf.format(myCalendar.getTime()));


                startActivity(i);
            }
        });

    }
    private void updateLabel() {

        dateBox.setText(sdf.format(myCalendar.getTime()));
    }

}



