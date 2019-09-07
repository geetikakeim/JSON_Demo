package com.example.keim.json_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayParsing();
        ObjectParsing();
        MixedParsing();
        MixedParsing2();
        MixedParsing3();
        MixedParsing4();

    }

    public void ArrayParsing() {
        String str = "['Ravi','Geetika','Osam','Saumya']";

        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++) {
                String name = jsonArray.getString(i);
                Log.i("myapp", name);

            }

        } catch (Exception e) {

        }
    }

    public void ObjectParsing() {
        Log.i("myapp", "testobjectparsing");
        String str1 = "{'name':'osam','phone':'9065425738','email':'geetikakeim@gmail.com'}";

        try {
            JSONObject jsonObject = new JSONObject(str1);
            String name = jsonObject.getString("name");
            long phone = jsonObject.getLong("phone");
            String email = jsonObject.getString("email");
            Log.i("myapp", name + phone + email);


        } catch (Exception e) {
        }
    }

    //json array in json array
    public void MixedParsing() {
        Log.i("myapp", "test2");
        String str = "[[1,2,3],[4,5,6],[7,8,9]]";

        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray jsonArray1 = jsonArray.getJSONArray(i);
                for (int j = 0; j < jsonArray1.length(); j++) {
                    String num = jsonArray1.getString(j);
                    Log.i("myapp", num);
                }
            }
        } catch (Exception e) {
        }
    }

    //json array in json object
    public void MixedParsing2() {
        String str = "[{'name':'geetika','branch':'IT','address':'delhi'}]";

        try {
            JSONArray jsonArray = new JSONArray(str);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString("name");
                String branch = jsonObject.getString("branch");
                String add = jsonObject.getString("address");
                Log.i("myapp", name + branch + add);

            }
        } catch (Exception e) {
        }
    }

    //json object to json array
    public void MixedParsing3() {
        Log.i("myapp", "test2");
        String str = "{ 'fruits':['apple','banana','orange'],'vegetables':['tomato','onion','ginger'] }";

        try {
            JSONObject jsonObject = new JSONObject(str);

            JSONArray jsonArray = jsonObject.getJSONArray("fruits");

            for (int i = 0; i < jsonArray.length(); i++) {
                String fruits1 = jsonArray.getString(i);
                Log.i("myapp", fruits1);
            }

            JSONArray jsonArray1 = jsonObject.getJSONArray("vegetables");

            for (int j = 0; j < jsonArray1.length(); j++)
            {
                String veg = jsonArray1.getString(j);
                Log.i("myapp", veg);
            }

        } catch (Exception e) {
        }
    }
        //json object to json object
        public void MixedParsing4(){
            String str="{'student':{'name':'geetika','age':'20'},'dept':{'branch':'IT','year':'3'}}";

            try{
                JSONObject jsonObject=new JSONObject(str);

                JSONObject jsonObject1=jsonObject.getJSONObject("student");
                String name=jsonObject1.getString("name");
                long age=jsonObject1.getLong("age");
                Log.i("myapp",name+age);

                JSONObject jsonObject2=jsonObject.getJSONObject("dept");
                String branch=jsonObject2.getString("branch");
                int yr=jsonObject2.getInt("year");
                Log.i("myapp",branch+yr);

            }
            catch (Exception e){

            }

    }

    }
