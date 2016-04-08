package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;

import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;


import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.Utils.Constants;
import com.example.httpwww.reshotel.entities.UserInformation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import Models.UserJsonWriter;
import Models.Validation;


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

    Button getStatus;
    EditText dateBox;
    Calendar myCalendar;
    String myFormat;
    SimpleDateFormat sdf;
    RatingBar ratingBar;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_activity);

        init();

        findViews();
        spinnerObject.setOnItemSelectedListener(this);
        listeners();
        registerViews();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getItemAtPosition(position).toString().startsWith("--")){
            country="";
        }
        else {
            country = parent.getItemAtPosition(position).toString();
        }
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
        ratingBar= (RatingBar) findViewById(R.id.ratingBar_statusActivity);







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


    }
    private void updateLabel() {

        dateBox.setText(sdf.format(myCalendar.getTime()));
    }


    private void registerViews() {

        fullName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(email);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            // after every change has been made to this editText, we would like to check validity
            public void afterTextChanged(Editable s) {
                Validation.isEmailAddress(email, false);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.hasText(email);
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        mobileNo.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                Validation.isPhoneNumber(mobileNo, false);
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after){}
            public void onTextChanged(CharSequence s, int start, int before, int count){}
        });


        getStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkValidation())
                    submitForm();
                else
                    Toast.makeText(StatusActivity.this, "please fill required field", Toast.LENGTH_SHORT).show();
            }
        });


        spinnerObject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                country = adapter.getItemAtPosition(i).toString();

            }

            @Override
            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(StatusActivity.this,"Country is not selected !!", Toast.LENGTH_LONG).show();
                return;
            }

        });


    }

    private void submitForm() {
        // Submit your form here. your form is valid
        Intent i = new Intent(StatusActivity.this, ShowActivity.class);

        i.putExtra(Constants.INTENT_NAME, fullName.getText().toString());
        i.putExtra(Constants.INTENT_EMAIL, email.getText().toString());
        i.putExtra(Constants.INTENT_PASSWORD, password.getText().toString());
        i.putExtra(Constants.INTENT_MOBILE_NO, mobileNo.getText().toString());
        i.putExtra(Constants.INTENT_GENDER, gender);
        i.putExtra(Constants.INTENT_COUNTRY, country);
        String iphone="";
        String android="";
        String windows="";
        i.putExtra(Constants.INTENT_ANDROID,"");
        i.putExtra(Constants.INTENT_IOS, "");
        i.putExtra(Constants.INTENT_WINDOWS,"");
        if (cbox1.isChecked()) {i.putExtra(Constants.INTENT_ANDROID,"IPhone");
            iphone="IPhone";}

        if (cbox2.isChecked()) {
            i.putExtra(Constants.INTENT_IOS, "Android");
            android="Android";
        }

        if (cbox3.isChecked()){ i.putExtra(Constants.INTENT_WINDOWS,"Windows");
            windows="Windows";
        }

        i.putExtra(Constants.INTENT_DATE, sdf.format(myCalendar.getTime()));
        i.putExtra(Constants.INTENT_RATING,String.valueOf(ratingBar.getRating()));
        String nameUser=fullName.getText().toString();
        String emailUser=email.getText().toString();
        String passUser=password.getText().toString();
        String mobileNoUser = mobileNo.getText().toString();
        String genderUser=gender;
        String countryUser=country;
        String rating= String.valueOf(ratingBar.getRating());
        String dateUser=sdf.format(myCalendar.getTime());


        UserInformation user=new UserInformation(nameUser,emailUser,passUser,mobileNoUser,genderUser,countryUser,iphone,android,windows,dateUser,rating);
        UserJsonWriter jsonWriter=new UserJsonWriter();
        jsonWriter.convertJsonParse(user, email);
        Toast.makeText(this, "Submitting status...", Toast.LENGTH_LONG).show();
        startActivity(i);
    }

    private boolean checkValidation() {
        boolean ret = true;

        if (!Validation.hasText(fullName)) ret = false;
        if (!Validation.isEmailAddress(email, true)) ret = false;
        if (!Validation.isPhoneNumber(mobileNo, true)) ret = false;
        if (!Validation.isPassword(password, true)) ret = false;
        if (!Validation.isValidSpinner(country)) ret = false;


        return ret;
    }

}





