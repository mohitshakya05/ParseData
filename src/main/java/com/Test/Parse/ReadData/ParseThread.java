package com.Test.Parse.ReadData;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ParseThread {
    public void parseJson(BufferedReader reader){
        String readLine = "";
        int count = 0;
        Gson gson = new Gson();
        try {
            readLine = reader.readLine();
            while((readLine = reader.readLine())!=null){
                JsonObject jobj = gson.fromJson(readLine.toString(),JsonObject.class);
                jobj.addProperty("filename","OrderJson");
                jobj.addProperty("result","OK");
                System.out.println(jobj);
                }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
