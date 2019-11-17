package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.edukatrip.edukatrip.adapter.ListTourGuideAdapter;
import com.edukatrip.edukatrip.model.TourGuide;

public class TourGuideActivity extends AppCompatActivity {
    private ListView listView;
    private ListTourGuideAdapter adapter;
    private TourGuide[] data = new TourGuide[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);

        listView = (ListView)findViewById(R.id.ls_tour_guide);
        boolean stat = true;
        for (int i=0,j=1;i<10;i++){
            data[i] = new TourGuide();
            data[i].setNama("Tour Guide "+i);
            data[i].setBio("Pengemui yang baik dan dermawan");
            data[i].setGambar(R.drawable.foto_pp);
            if (j>5){
                stat = false;
            }
            data[i].setBintang(j);
            if (stat){
                j++;
            }else {
                j--;
            }
        }
        adapter = new ListTourGuideAdapter(this,data,getLayoutInflater());
        listView.setAdapter(adapter);



    }
}
