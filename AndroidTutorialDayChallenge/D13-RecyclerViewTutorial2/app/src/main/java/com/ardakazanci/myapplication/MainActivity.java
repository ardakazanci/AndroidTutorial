package com.ardakazanci.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactList(20); // 20 adet veri oluşturacak / Burada da yapabilirdik.
        // Örnek kullanıcı verilerini içeren adapter oluştur.
        ContactAdapter adapter = new ContactAdapter(contacts);

        rvContacts.setAdapter(adapter);
        // Öğeleri konumlandırmak için düzen yöneticisi eklendi.
        rvContacts.setLayoutManager(new LinearLayoutManager(this));


    }
}
