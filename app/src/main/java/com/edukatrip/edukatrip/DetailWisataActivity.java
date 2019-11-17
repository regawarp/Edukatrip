package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.edukatrip.edukatrip.adapter.DetailReviewsAdapter;
import com.edukatrip.edukatrip.model.Reviews;

import java.util.ArrayList;
import java.util.List;

public class DetailWisataActivity extends AppCompatActivity {
    private List<Reviews> data = new ArrayList<Reviews>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);
        for (int i=0;i<10;i++){
            data.add(new Reviews());
        }

        RecyclerView reviewsRV = (RecyclerView)findViewById(R.id.detail_ratings_reviews_rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        reviewsRV.setLayoutManager(linearLayoutManager);

        DetailReviewsAdapter adapter = new DetailReviewsAdapter(this,data);
        reviewsRV.setAdapter(adapter);

    }
}
