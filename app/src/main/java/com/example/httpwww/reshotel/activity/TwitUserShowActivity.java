package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.entities.TwitUserInformation;

import java.io.Serializable;
import java.util.List;

/**
 * Created by silenthacker on 07/04/16.
 */
public class TwitUserShowActivity extends Activity implements Serializable{

    TextView id,username,created_at,timezone,name,locale,post,following,followers,description;
    RatingBar star;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twit_user_layout);
        List<TwitUserInformation> list;
        Intent intent=getIntent();
        TwitUserInformation twiObject= (TwitUserInformation) intent.getSerializableExtra("MyClass");
            Log.d("Value====>", twiObject.getId());
        init();

        id.setText(twiObject.getId());
        username.setText(twiObject.getUsername());
        created_at.setText(twiObject.getCreated_at());
        timezone.setText(timezone.getText());
        name.setText(twiObject.getName());
        locale.setText(twiObject.getLocale());
        timezone.setText(twiObject.getTimezone());
        following.setText(twiObject.getFollowing());
        followers.setText(twiObject.getFollowers());
        star.setStepSize(Integer.parseInt(twiObject.getStar()));
        post.setText(twiObject.getPost());
        description.setText(twiObject.getDescription());



    }

    private void init()
    {
        id = (TextView) findViewById(R.id.textview_twit_id);
        username = (TextView) findViewById(R.id.textview_twit_user);
        created_at = (TextView) findViewById(R.id.textview_twit_created_on);
        timezone = (TextView) findViewById(R.id.textview_twit_timezone);
        name = (TextView) findViewById(R.id.textview_twit_name);
        locale = (TextView) findViewById(R.id.textview_twit_locale);
        following = (TextView) findViewById(R.id.textview_twit_following);
        followers = (TextView) findViewById(R.id.textview_twit_follower);
        star = (RatingBar) findViewById(R.id.textview_twit_star);
        post = (TextView) findViewById(R.id.textview_twit_post);
        description = (TextView) findViewById(R.id.textview_twit_description);
    }

}
