package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position"; // PutExtra karşılama etiketi
    private static final int DEFAULT_POSITION = -1; // Varsayılan pozisyon bilgisi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv); // ImageView çağırılıyor.

        Intent intent = getIntent(); // Çağırılan Intent alınıyor.
        if (intent == null) { // Eğer boş ise
            closeOnError(); // Hata metodu çağırılıyor.
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION); // İstenilen pozisyonu alıyor.
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);// JSON Verileri alınıyor.
        String json = sandwiches[position]; // Pozisyon bilgisine göre JSON çekiliyor.
        Sandwich sandwich = JsonUtils.parseSandwichJson(json); // JSON Parse işlemi uygulanıyor.
        if (sandwich == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) { // Verileri Gösterme İşlemi
        // View Elemanlarını referans ile eşitledik.
        TextView sandwichName = findViewById(R.id.name_tv);
        TextView sandwichAlsoKnownAs = findViewById(R.id.also_known_tv);
        TextView sandwichOrigin = findViewById(R.id.origin_tv);
        TextView sandwichDescp = findViewById(R.id.description_tv);
        TextView sandwichIngre = findViewById(R.id.ingredients_tv);

        // Açıklama,Sandviç Adı ve Ait olduğu ülkeye değerleri setText ile atadık.
        sandwichOrigin.setText(dataMissing(sandwich.getPlaceOfOrigin()));
        sandwichDescp.setText(dataMissing(sandwich.getDescription()));
        sandwichName.setText(dataMissing(sandwich.getMainName()));

        List<String> akas = sandwich.getAlsoKnownAs();
        String out = "";
        // + koymaya yarıyor.
        for (String s : akas) {
            out += s + ", ";
        }
        // Virgülü silmeye yarıyor.
        if (out.length() > 0) {
            out = out.substring(0, out.length() - 2);
        }
        sandwichAlsoKnownAs.setText(dataMissing(out));

        out = "";
        List<String> sandwichList = sandwich.getIngredients();
        for (String s : sandwichList) {
            out += s + "\n";
        }
        sandwichIngre.setText(dataMissing(out));
    }

    private String dataMissing(String s) {
        if (s.equals("")) {
            return getString(R.string.data_miss);
        } else {
            return s;
        }
    }
}
