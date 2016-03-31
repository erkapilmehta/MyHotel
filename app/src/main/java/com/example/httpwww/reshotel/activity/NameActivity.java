package com.example.httpwww.reshotel.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.httpwww.reshotel.R;
import com.example.httpwww.reshotel.adapter.HotelListAdapter;

/**
 * Created by silenthacker on 31/03/16.
 */
public class NameActivity extends Activity {


    private String[] hotelArray = { "The Venetian ","MGM Grand Las Vegas ","Izmailovo Hotel","Luxor Las Vegas","Caesars Palace","Sheraton Macao","Circus Circus Las Vegas","Shinagawa Prince Hotel","Flamingo Las Vegas","Atlantis Paradise Island","Task7","Task8","Task9","Task10","Task11","Task12","Task13","Task14","Task15","Task16","Task17","Task18","Task19"};
    Integer[] imageId = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4,R.drawable.image4 };

    private ListView hotelListView;
    private Toolbar toolbar;
    private TextView myText = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotel_activity);
        final Dialog dialog = new Dialog(this);
        HotelListAdapter adapter = new HotelListAdapter(NameActivity.this, hotelArray, imageId);
        hotelListView = (ListView) findViewById(R.id.hotel_list);
        hotelListView.setAdapter(adapter);
        hotelListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if(position==0)
                {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Hiran Magri, Udaipur, Rajasthan 313001");
                    dialog.show();
                }
                if(position==1) {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Mayur Complex Road, Hiran Magri, Sector 4, Udaipur, Rajasthan 313001");
                    dialog.show();
                }
                if(position==2)
                {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Hiranmagri Extension, Manwakhera NH-8 Bypass, Near Eklingpura Chouraha, Udaipur, Rajasthan 313002");
                    dialog.show();
                }
                if(position==3)
                {

                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Ahmedabad Road, Opp.Paras Mahal Hotel, Near Vishal Mega Mart, Khanjipeer, Udaipur, Rajasthan 313001");
                    dialog.show();
                }
                else
                {
                    dialog.setContentView(R.layout.custom_dialogue);
                    dialog.setTitle("Address is not available right now");
                    dialog.show();

                }
            }

        });

    }


}
