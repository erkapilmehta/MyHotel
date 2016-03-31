package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.adapter.RoomListAdapter;

/**
 * Created by silenthacker on 31/03/16.
 */
public class RoomActivity extends Activity {
    private String[] roomArray = { "Single ","Double ","Triple","Queen","King","Deluxe","Circus Circus Las Vegas","Shinagawa Prince Hotel","Flamingo Las Vegas","Atlantis Paradise Island","Task7","Task8","Task9","Task10","Task11","Task12","Task13","Task14","Task15","Task16","Task17","Task18","Task19"};
    Integer[] imageId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image4 };

    private ListView roomListView;
    private Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_activity);
        final Dialog dialog = new Dialog(this);
        RoomListAdapter adapter = new RoomListAdapter(RoomActivity.this, roomArray, imageId);
        roomListView = (ListView) findViewById(R.id.room_list);
        roomListView.setAdapter(adapter);
        roomListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if (position == 0) {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Price INR 5000");
                    dialog.show();
                }
                if (position == 1) {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Price INR 4000");
                    dialog.show();
                }
                if (position == 2) {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Price INR 3000");
                    dialog.show();
                }
                if (position == 3) {

                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Price INR 2000");
                    dialog.show();
                } else {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Price INR 1000");
                    dialog.show();

                }
            }

        });


    }
}
