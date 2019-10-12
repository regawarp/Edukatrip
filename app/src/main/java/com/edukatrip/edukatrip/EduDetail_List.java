package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.GridView;

import com.edukatrip.edukatrip.DetailEduTour.Tour;
import com.edukatrip.edukatrip.DetailEduTour.gridRatedAdapter;

public class EduDetail_List extends AppCompatActivity {
    GridView gridRated, gridPrice;
    Tour[] data = {new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour A","Rp. 29.000 / person",5,"(290 Reviews)"),
            new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour B","Rp. 28.000 / person",5,"(300 Reviews)"),
            new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour C","Rp. 27.000 / person",5,"(310 Reviews)"),
            new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour D","Rp. 26.000 / person",5,"(320 Reviews)"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edu_detail__list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.tbSearch);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        gridRated = (GridView)findViewById(R.id.gridRated);
        gridPrice = (GridView)findViewById(R.id.gridPrice);

        gridRatedAdapter ratedAdapter = new gridRatedAdapter(this,data);
        gridRated.setAdapter(ratedAdapter);

        gridPrice.setAdapter(ratedAdapter);

    }
}
