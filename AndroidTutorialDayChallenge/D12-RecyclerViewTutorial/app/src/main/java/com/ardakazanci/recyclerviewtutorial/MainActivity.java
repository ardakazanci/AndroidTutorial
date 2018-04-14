package com.ardakazanci.recyclerviewtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<String> mWordList = new LinkedList<>(); // Kelime Listesini tutacak.
    private int mCount = 0; // Kelime sıra pozisyonunu tutacak


    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 20 adet kelime  döndürüyoruz.
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + mCount++);
            Log.d("WordList", mWordList.getLast());
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView); // RecyclerView
        mAdapter = new WordListAdapter(this, mWordList); // Yeni bir adapter oluşturuldu , veriler ve context gönderildi.
        mRecyclerView.setAdapter(mAdapter);// Rec ile adapter birleştirildi.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); // Düzen yöneticisi

    }
}
