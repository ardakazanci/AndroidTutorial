package com.ardakazanci.customadapter2_reportcard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ReportModel> studentReportInfo = new ArrayList<ReportModel>();

        studentReportInfo.add(new ReportModel("Matematik","Arda Kazancı",30));
        studentReportInfo.add(new ReportModel("Fizik","Ece Kazanc",90));
        studentReportInfo.add(new ReportModel("Kimya","Ahmet Kazan",35));
        studentReportInfo.add(new ReportModel("Biyoloji","Murat Kaza",39));
        studentReportInfo.add(new ReportModel("Müzik","Kemal Kaz",31));
        studentReportInfo.add(new ReportModel("Beden Eğitimi","Ekrem K",30));


        ListView listView = findViewById(R.id.ogrenciNoListesi);
        ReportAdapter adapter = new ReportAdapter(this,studentReportInfo);
        listView.setAdapter(adapter);

    }
}
