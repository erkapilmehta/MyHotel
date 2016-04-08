package Models;


import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.httpwww.reshotel.entities.UserInformation;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by silenthacker on 05/04/16.
 */
public class UserJsonWriter {

    public void convertJsonParse(UserInformation user,EditText email)
    {

        Gson gson = new Gson();
        Type type = new TypeToken<UserInformation>() {}.getType();
        String json = gson.toJson(user, type);


        try {
            new File("/sdcard/myfile").mkdir();
            File myFile = new File("/sdcard/myfile/"+email.getText().toString()+".txt");
            myFile.createNewFile();
            FileOutputStream fileout = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fileout);
            myOutWriter.append(json);
            myOutWriter.close();
            fileout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public UserInformation convertJsonToUser(String filename){



        StringBuilder text = new StringBuilder();
        try {

            File file = new File("/sdcard/myfile/"+filename);

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

        ////Set the text to text view.

        Gson gson = new GsonBuilder().create();
      UserInformation user = gson.fromJson(text.toString(), UserInformation.class);
        System.out.println(text.toString());

        return user;
    }
}
