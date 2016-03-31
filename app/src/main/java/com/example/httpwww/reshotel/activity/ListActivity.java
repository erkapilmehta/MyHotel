package com.example.httpwww.reshotel.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.adapter.CustomListAdapter;

public class ListActivity extends Activity {
    private String[] menuArray = { "Hotel Name","Room Name ","Task Type","Status","Task1","Task2","Task3","Task4","Task5","Task6","Task7","Task8","Task9","Task10","Task11","Task12","Task13","Task14","Task15","Task16","Task17","Task18","Task19"};
    Integer[] imageId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image4 };

    private ListView menuListView;
    private Toolbar toolbar;



    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);


        CustomListAdapter adapter = new CustomListAdapter(ListActivity.this, menuArray, imageId);
        menuListView = (ListView) findViewById(R.id.menu_list);
        menuListView.setAdapter(adapter);
        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                if(position==0)
                {
                    Intent i = new Intent(getApplicationContext(),NameActivity.class);
                    startActivity(i);
                }
                if(position==1)
                {
                    Intent i = new Intent(getApplicationContext(),RoomActivity.class);
                    startActivity(i);
                }
                if(position==2)
                {
                    Intent i = new Intent(getApplicationContext(),TaskActivity.class);
                    startActivity(i);
                }
                if(position==3)
                {
                    Intent i = new Intent(getApplicationContext(),StatusActivity.class);
                    startActivity(i);
                }
               else if(position>3)
                {
                    Toast.makeText(getApplicationContext(), "service not available", Toast.LENGTH_SHORT).show();
                }
            }

        });


    }
}