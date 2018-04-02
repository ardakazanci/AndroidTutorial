package com.ardakazanci.d1_activityintentfiltertype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    /*

        Activity Bileşeninin Karakteristik Özellikleri IntentFilter etiketi ile eklenir.

        Örneğin
        - Galeriden Resim Alan
        - Metin veya Resim gönderebilmeyi sağlayan vs.
        Gelişi güzel eklenmemeli. Activity'nin görevine göre eklenmelidir.  


     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
