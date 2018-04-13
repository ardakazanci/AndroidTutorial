package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {
    // Gelen JSON Burada parse edilecek
    public static Sandwich parseSandwichJson(String json) {

        try {

            JSONObject jsonRoot = new JSONObject(json);
            // Name
            JSONObject jsonName = jsonRoot.getJSONObject("name");
            // MainName < Name ' in içinde
            String mainName = jsonName.getString("mainName");
            // alsoKnownAs < Name in içinde
            JSONArray jsonKnownAs = jsonName.getJSONArray("alsoKnownAs");
            // AlsoKnownAs bir dizi olduğu için
            ArrayList<String> jsonAlsoKnownAsList = new ArrayList<>();
            for (int i = 0; i < jsonKnownAs.length(); i++) {
                jsonAlsoKnownAsList.add(jsonKnownAs.getString(i));
            }
            String jsonPlaceOfOrigin = jsonRoot.getString("placeOfOrigin");
            String jsonDescp = jsonRoot.getString("description");
            String jsonImage = jsonRoot.getString("image");
            JSONArray jsonIng = jsonRoot.getJSONArray("ingredients");
            ArrayList<String> jsonIngList = new ArrayList<>();
            for (int i = 0; i < jsonIng.length(); i++) {
                jsonIngList.add(jsonIng.getString(i));
            }
            // Parse edilen değerler. Sandvich modelinden değer oluşturdu.
            return new Sandwich(mainName, jsonAlsoKnownAsList, jsonPlaceOfOrigin, jsonDescp, jsonImage, jsonIngList);

        } catch (JSONException e) {

            e.printStackTrace();

        }

        return null;


    }
}
