package com.stackroute.trainermanagementservice.component;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.*;

@Component
public class JsonParser {

    public void parser() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader br = new BufferedReader(
                new FileReader("/home/upasana/Music/ibm-wave4-goldysgym/trainer-management-service/src/main/resources/rules.json"));
      //  JsonReader reader = Json.createReader(new FileInputStream(new File("/home/upasana/ibm-wave4-goldysgym/trainer-management-service/src/main/resources/rules.json")));
       // JsonObject jsonObject = reader.readObject();
        //reader.close();
//        System.out.println(jsonObject.getInt("numberOfTrainers"));
        Rules rules=gson.fromJson(br,Rules.class);
        System.out.println(rules.toString());
    }
}
