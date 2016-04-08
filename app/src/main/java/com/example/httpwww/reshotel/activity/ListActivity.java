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
    private String[] menuArray;
    Integer[] imageId ;
    private ListView menuListView;
    private Toolbar toolbar;
    CustomListAdapter adapter;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        init();
        findViews();
        menuListView.setAdapter(adapter);
        listeners();

    }




    private void init()
    {
         menuArray = new String[]{"Hotel Name", "Room Name ", "Task Type", "Status", "Get User List", "Task2", "task 3", "API Call", "Fragment", "Data", "Task7", "Task8", "Task9", "Task10", "Task11", "Task12", "Task13", "Task14", "Task15", "Task16", "Task17", "Task18", "Task19"};
         imageId = new Integer[]{R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image4};
        adapter = new CustomListAdapter(ListActivity.this, menuArray, imageId);

    }
    private void findViews()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar_listActivity);
        menuListView = (ListView) findViewById(R.id.listview_menu_list);
    }
    private void listeners()
    {
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
                if(position==4)
                {
                    Intent i = new Intent(getApplicationContext(),UserListActivity.class);
                    startActivity(i);
                }
                if(position==5)
                {
                    Intent i = new Intent(getApplicationContext(),MemberActivity.class);
                    startActivity(i);
                }
                if(position==6)
                {
                    Intent i = new Intent(getApplicationContext(),IntentShowActivity.class);
                    startActivity(i);
                }
                if(position==7)
                {
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                }
                if(position==8)
                {
                    Intent i = new Intent(getApplicationContext(),FollowerActivity.class);
                    startActivity(i);
                }
                if(position==9)
                {
                    Intent i = new Intent(getApplicationContext(),DataActivity.class);
                    startActivity(i);
                }
                else if(position>9)
                {
                    Toast.makeText(getApplicationContext(), "service not available", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }



}