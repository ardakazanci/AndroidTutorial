package com.ardakazanci.sandvilisteleme;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ardakazanci.sandvilisteleme.Model.Model;
import com.ardakazanci.sandvilisteleme.Utils.NetworkUtils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetayActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position"; // putString etiketini tamamlayan değer.
    private static final int DEFAULT_POSITION = -1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView imageView = findViewById(R.id.imageView);

        // Gelen Intent ile ilgili poziyon
        Intent i = getIntent();
        if(i == null){ // Eğer intent tanımlanmamılş ise

            closeOnError();
        }

        int gelenPozisyon = i.getIntExtra(EXTRA_POSITION,DEFAULT_POSITION);
        if(DEFAULT_POSITION == -1){ // -1 ' in anlamı EXTRA_POSITION niyetinde bulunulmadığının tespitidir.

            closeOnError();
            return;

        }

        String[] sandvicler = getResources().getStringArray(R.array.sandwich_details);
        String json = sandvicler[gelenPozisyon]; // ilgili değerin açıklamasını aldık .
        Model ilgiliNesne = NetworkUtils.parseJson(json);

        if (ilgiliNesne == null) {
            // Sandwich data unavailable
            closeOnError();
            return;
        }

        populateUI(ilgiliNesne);
        Picasso.with(this)
                .load(ilgiliNesne.getImage())
                .into(imageView); // image ' view ' a ilgili image i ata.

        setTitle(ilgiliNesne.getMainName());


    }

    private void populateUI(Model ilgiliNesne) {
        TextView sandwichName = findViewById(R.id.name_tv);
        TextView sandwichAlsoKnownAs = findViewById(R.id.also_known_tv);
        TextView sandwichOrigin = findViewById(R.id.origin_tv);
        TextView sandwichDescp = findViewById(R.id.description_tv);
        TextView sandwichIngre = findViewById(R.id.ingredients_tv);


        sandwichOrigin.setText(dataMissing(ilgiliNesne.getPlaceOfOrigin()));
        sandwichDescp.setText(dataMissing(ilgiliNesne.getDescription()));
        sandwichName.setText(dataMissing(ilgiliNesne.getMainName()));

        List<String> akas = ilgiliNesne.getAlsoKnownAs();
        String out = "";
        for (String s : akas) {
            out += s + ", ";
        }
        if (out.length() > 0) {
            out = out.substring(0, out.length() - 2);
        }
        sandwichAlsoKnownAs.setText(dataMissing(out));

        out = "";
        List<String> sandwichList = ilgiliNesne.getIngredients();
        for (String s : sandwichList) {
            out += s + "\n";
        }
        sandwichIngre.setText(dataMissing(out));



    }


    // Veri bulunamadıysa şu yazsın gibi.
    private String dataMissing(String s) {
        if (s.equals("")) {
            return getString(R.string.data_miss);
        } else {
            return s;
        }
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }
}
