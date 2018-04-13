package com.ardakazanci.sandvilisteleme.Utils;

import com.ardakazanci.sandvilisteleme.Model.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NetworkUtils {


    // JSON Parse işlemi yapılacak

    public static Model parseJson(String json) { // Çünkü xml ' den çekeceğiz.

        try {

            JSONObject root = new JSONObject(json); // Tüm JSON Verisi

            JSONObject jsonName = root.getJSONObject("name");
            String jsonMainName = jsonName.getString("mainName");
            JSONArray jsonAlsoKnownAs = jsonName.getJSONArray("alsoKnownAs");
            ArrayList<String> arrayListJsonAlsoKnownAs = new ArrayList<>();
            for (int i = 0; i < jsonAlsoKnownAs.length(); i++) {

                arrayListJsonAlsoKnownAs.add(jsonAlsoKnownAs.getString(i)); // Her adımda ki değer ekleniyor.

            }

            String jsonPlaceOfOrigin = root.getString("placeOfOrigin");
            String jsonDescription = root.getString("description");
            String jsonImage = root.getString("image");
            JSONArray jsonIngredients = root.getJSONArray("ingredients");
            ArrayList<String> arrayListJsonIngredients = new ArrayList<>();
            for (int i = 0; i < jsonIngredients.length(); i++) {

                arrayListJsonIngredients.add(jsonIngredients.getString(i));

            }
            // Parse edilen verilerden bir nesne oluşturduk
            return new Model(jsonMainName,arrayListJsonAlsoKnownAs,jsonPlaceOfOrigin,jsonDescription,jsonImage,arrayListJsonIngredients);

        } catch (JSONException e) {

            e.printStackTrace();

        }

        return null;


    }


}
