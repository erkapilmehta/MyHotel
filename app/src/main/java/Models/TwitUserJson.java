package Models;

import android.util.Log;

import com.example.httpwww.reshotel.entities.TwitUserInformation;
import com.example.httpwww.reshotel.entities.UserInformation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by silenthacker on 07/04/16.
 */
public class TwitUserJson {
    TwitUserInformation tui;
    public List<TwitUserInformation> convertJsonToUser(String filename) {

        List<TwitUserInformation> list=new ArrayList<TwitUserInformation>();

        StringBuilder text = new StringBuilder();
        try {

            File file = new File("/sdcard/json/"+filename);

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
            }
            br.close();
        }
        catch (IOException e) {
            e.printStackTrace();

        }
        try {

            String textData="";
            JSONObject reader = new JSONObject(text.toString());
             JSONArray data_object=reader.getJSONArray("data");
            for (int i = 0; i < data_object.length(); i++) {
                JSONObject c = data_object.getJSONObject(i);

                JSONObject userObject = new JSONObject(c.getString("user"));
                String count=userObject.getString("counts");
                JSONObject countFollow = new JSONObject(count);
                String id = userObject.getString("id");
                String username = userObject.getString("username");
                String created_at = userObject.getString("created_at");
                String description = userObject.getString("description");
               try
               {
                    JSONObject descriptionObj = new JSONObject(description);
                    if (!(descriptionObj==null)) {
                        textData = descriptionObj.getString("text");
                    }
                }
               catch (Exception e)
               {
                   e.printStackTrace();
               }

                String timezone = userObject.getString("timezone");
                String name = userObject.getString("name");
                String locale = userObject.getString("locale");
                String post = countFollow.getString("posts");
                String following = countFollow.getString("following");
                String follower = countFollow.getString("followers");
                String stars = countFollow.getString("stars");


                Log.d("TextData is**===>", textData);
               // Log.d("post is is**===>", );


               // Log.d("json is*******======>",c.getString("user"));
//                Log.d("User is*******======>",username);
//                Log.d("User is*******======>",created_at);

                tui=new TwitUserInformation();
                tui.setId(id);
                tui.setUsername(username);
                tui.setCreated_at(created_at);
                tui.setTimezone(timezone);
                tui.setName(name);
                tui.setLocale(locale);
                tui.setPost(post);
                tui.setFollowing(following);
                tui.setFollowers(follower);
                tui.setStar(stars);
                tui.setDescription(textData);
               // Log.d("======id==", tui.getId());
                list.add(tui);


            }


            ////Set the text to text view.
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return list;
    }
}
