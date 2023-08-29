package com.example.prac.chapter02.ParsingJsonFiles;



//import jakarta.json.Json;
//import jakarta.json.stream.JsonParser;
//import jakarta.json.stream.JsonParser.Event;

import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ParsingJsonFiles {
    public static void main(String[] args) {
        File dataFile = new File("/Users/ryujun-yeong/Documents/study/Java_Data_Analysis/prac/src/main/java/com/example/prac/chapter02/ParsingJsonFiles/Books.json");
        try {
            InputStream input = new FileInputStream(dataFile);
            JsonParser parser = Json.createParser(input);
            Event event = parser.next();
            HashMap<String, Object> map = getMap(parser);
            System.out.println(map);
            input.close();
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static HashMap getMap(JsonParser parser) {
        HashMap<String, Object> map = new HashMap<>();
        JsonParser.Event event = parser.next();
        String key = parser.getString();
        event = parser.next();
        while (!event.equals(Event.END_OBJECT)){
            if (event.equals(Event.VALUE_STRING)){
                String value = parser.getString();
                map.put(key, value);
            } else if (event.equals(JsonParser.Event.VALUE_NUMBER)){
                Integer value = parser.getInt();
                map.put(key, value);
            } else if (event.equals(Event.START_ARRAY)) {
                ArrayList<String> list = getList(parser);
                map.put(key, list);
            }
            event = parser.next();
            if (event.equals(Event.END_OBJECT)){
                break;
            }
            key = parser.getString();
            event = parser.next();
        }
        return map;
    }

    private static ArrayList<String> getList(JsonParser parser) {
        ArrayList list = new ArrayList();
        Event event = parser.next();
        while (!event.equals(Event.END_ARRAY)) {
            if (event.equals(Event.VALUE_STRING)) {
                list.add(parser.getString());
                event = parser.next();
            } else if (event.equals(Event.START_OBJECT)){
                HashMap<String, Object> map = getMap(parser);
                list.add(map);
                event=parser.next();
            } else if (event.equals(Event.START_ARRAY)){
                ArrayList subList = getList(parser);
                list.add(subList);
                event = parser.next();
            }
        }
        return list;
    }
}
