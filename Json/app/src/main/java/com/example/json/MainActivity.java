package com.example.json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<Modaljson> userList =  new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

       String value = getIntent().getStringExtra("name");

       if(value.equals("Success")){
           category = "Success";
       }else if(value.equals("Confidence")){
           category = "Confidence";
       }else if(value.equals("Self Esteem")){
           category = "Self Esteem";
       }else if(value.equals("Abundance")){
           category = "Abundance";
       }else if(value.equals("Mental Health")){
           category = "Mental Health";
       }else if(value.equals("Relationship")){
           category = "Relationship";
       }else if(value.equals("Friendship")){
           category = "Friendship";
       }else if(value.equals("Love")){
           category = "Love";
       }else if(value.equals("Family")){
           category = "Family";
       }else if(value.equals("Happiness")){
           category = "Happiness";
       }else if(value.equals("Mindfulness")){
           category = "Mindfulness";
       }else if(value.equals("Decision Making")){
           category = "Decision Making";
       }else if(value.equals("Personal Growth")){
           category = "Personal Growth";
       }else if(value.equals("Physical Health")){
           category = "Physical Health";
       }else if(value.equals("Social")){
           category = "Social";
       }else if(value.equals("Woman")){
           category = "Woman";
       }

//        customAdapter = new CustomAdapter(getApplicationContext(), (ArrayList<Modaljson>) userList);
//        recyclerView.setAdapter(customAdapter);
//        customAdapter.notifyDataSetChanged();


//        try {
//
//            JSONObject obj = new JSONObject(loadJSONFromAsset());
//            for(int i=0; i < obj.length();i++){
//                JSONArray array = obj.getJSONArray(String.valueOf(i));
//                for(int j=0;j<array.length();j++){
//                    JSONObject userDetail = array.getJSONObject(j);
//
//                }
//            }

//            JSONArray userArray = obj.getJSONArray("Success");
//            for (int i = 0; i < userArray.length(); i++) {
//                JSONObject userDetail = userArray.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//               // JSONObject contact = userDetail.getJSONObject("contact");
//            }
//            JSONArray array = obj.getJSONArray("Confidence");
//            for (int i = 0; i < array.length(); i++) {
//                JSONObject userDetail = array.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array1 = obj.getJSONArray("Abundance");
//            for (int i = 0; i < array1.length(); i++) {
//                JSONObject userDetail = array1.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array2 = obj.getJSONArray("Self Esteem");
//            for (int i = 0; i < array2.length(); i++) {
//                JSONObject userDetail = array2.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//                // JSONObject contact = userDetail.getJSONObject("contact");
//            }
//            JSONArray array3 = obj.getJSONArray("Mental Health");
//            for (int i = 0; i < array3.length(); i++) {
//                JSONObject userDetail = array3.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array4 = obj.getJSONArray("Love");
//            for (int i = 0; i < array4.length(); i++) {
//                JSONObject userDetail = array4.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array5 = obj.getJSONArray("Relationship");
//            for (int i = 0; i < array5.length(); i++) {
//                JSONObject userDetail = array5.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//                // JSONObject contact = userDetail.getJSONObject("contact");
//            }
//            JSONArray array6 = obj.getJSONArray("Friendship");
//            for (int i = 0; i < array6.length(); i++) {
//                JSONObject userDetail = array6.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array7 = obj.getJSONArray("Family");
//            for (int i = 0; i < array7.length(); i++) {
//                JSONObject userDetail = array7.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array8 = obj.getJSONArray("Happiness");
//            for (int i = 0; i < array8.length(); i++) {
//                JSONObject userDetail = array8.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//                // JSONObject contact = userDetail.getJSONObject("contact");
//            }
//            JSONArray array9 = obj.getJSONArray("Mindfulness");
//            for (int i = 0; i < array9.length(); i++) {
//                JSONObject userDetail = array9.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array10 = obj.getJSONArray("Decision Making");
//            for (int i = 0; i < array10.length(); i++) {
//                JSONObject userDetail = array10.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array11 = obj.getJSONArray("Personal Growth");
//            for (int i = 0; i < array11.length(); i++) {
//                JSONObject userDetail = array11.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array12 = obj.getJSONArray("Physical Health");
//            for (int i = 0; i < array12.length(); i++) {
//                JSONObject userDetail = array12.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array13 = obj.getJSONArray("Social");
//            for (int i = 0; i < array13.length(); i++) {
//                JSONObject userDetail = array13.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
//            JSONArray array14 = obj.getJSONArray("Woman");
//            for (int i = 0; i < array14.length(); i++) {
//                JSONObject userDetail = array14.getJSONObject(i);
//                quote.add(userDetail.getString("quote"));
//                image.add(userDetail.getString("image"));
//                icon.add(userDetail.getString("icon"));
//                folder.add(userDetail.getString("folder"));
//                sound.add(userDetail.getString("sound"));
//            }
            try {
                JSONObject object = new JSONObject(loadJSONFromAsset());
                JSONArray array = object.getJSONArray(category);
              //  String array[] = {"Success","Confidence","Abundance","Self Esteem","Mental Health","Love","Relationship","Friendship","Family","Happiness","Mindfulness","Decision Making","Personal Growth","Physical Health","Social","Woman"};
               // int length = object.getJSONArray("Success").length();
//                for (int i = 0; i < object.length(); i++) {
//                    JSONArray subArray = object.getJSONArray(String.valueOf(i));
//                    // loop trhough those nested arrays to retrieve the objects
//                    for (int j = 0; j < subArray.length(); j++) {
//                        JSONObject obj = subArray.getJsonObject(j);

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject jsonObject = array.getJSONObject(i);
                        String quote = jsonObject.getString("quote");
                        String image = jsonObject.getString("image");
                        String icon = jsonObject.getString("icon");
                        String folder = jsonObject.getString("folder");
                        String sound = jsonObject.getString("sound");

                        Modaljson model = new Modaljson();
                        model.setQuote(quote);
                        model.setImage(image);
                        model.setIcon(icon);
                        model.setFolder(folder);
                        model.setSound(sound);
                        userList.add(model);
                    }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        CustomAdapter customAdapter = new CustomAdapter(MainActivity.this,  userList);
        recyclerView.setAdapter(customAdapter);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}