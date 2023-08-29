package com.example.demo.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

@Component
public class FileHandler {
    
    public JsonElement readFiletoJsonElement(Resource resource){
        
        StringBuilder temp = new StringBuilder("");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {

            String line;

            while((line= br.readLine()) != null){
                temp.append(line);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        JsonElement res = new Gson().fromJson(temp.toString(), JsonElement.class);

        return res;
    }


    public String readFiletoString(Resource resource){
        
        StringBuilder temp = new StringBuilder("");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {

            String line;

            while((line= br.readLine()) != null){
                temp.append(line);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return temp.toString();
    }

}
