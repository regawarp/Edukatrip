package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.edukatrip.edukatrip.adapter.EduImageGridAdapter;
import com.edukatrip.edukatrip.adapter.FacGridAdapter;
import com.edukatrip.edukatrip.adapter.TimelineAdapter;
import com.edukatrip.edukatrip.adapter.DetailReviewsAdapter;
import com.edukatrip.edukatrip.model.Facilities;
import com.edukatrip.edukatrip.customview.CustomGridView;
import com.edukatrip.edukatrip.model.Places;
import com.edukatrip.edukatrip.model.Reviews;
import com.edukatrip.edukatrip.model.Timeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DetailEduTourActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private CustomGridView recyclerImage;
    private CustomGridView facGrid;
    private int[] data = new int[]{R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5};
    private List<Facilities> facilities;
    private List<Timeline> timelines;
    private List<Reviews> reviews;
    private RecyclerView timelineRV;
    private RecyclerView reviewsRV;
    private TextView totalReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_edu_tour);

        toolbar = (Toolbar)findViewById(R.id.detail_edu_toolbar);
        recyclerImage=(CustomGridView) findViewById(R.id.detail_edu_rv_image);
        facGrid = (CustomGridView) findViewById(R.id.detail_edu_grid_fac);
        timelineRV = (RecyclerView)findViewById(R.id.detail_edu_timeline_rv);
        reviewsRV = (RecyclerView)findViewById(R.id.detail_edu_reviews_rv);

        totalReviews = (TextView)findViewById(R.id.detail_edu_total_reviews);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        EduImageGridAdapter adapter = new EduImageGridAdapter(this,data);
        recyclerImage.setAdapter(adapter);

        facilities = new ArrayList<>();
        facilities.add(new Facilities("Meal","2 Course Meal",R.drawable.meal));
        facilities.add(new Facilities("Snack","1 Pack of Snack",R.drawable.snack));
        facilities.add(new Facilities("Transportations","Car and Driver",R.drawable.car));
        facilities.add(new Facilities("Tour Guide","A nice tour guide",R.drawable.tour_guide));

        FacGridAdapter facGridAdapter = new FacGridAdapter(this,facilities);
        facGrid.setAdapter(facGridAdapter);

        timelines = new ArrayList<>();
        timelines.add(new Timeline(new Date(),new Date(),new Places("Hotel Kamboja","Meeting Point",50000,getResources().getString(R.string.dummy_text),R.drawable.image_2)));
        timelines.add(new Timeline(new Date(),new Date(),new Places("Hotel Kamboja","Meeting Point",50000,getResources().getString(R.string.dummy_text),R.drawable.image_2)));
        timelines.add(new Timeline(new Date(),new Date(),new Places("Hotel Kamboja","Meeting Point",50000,getResources().getString(R.string.dummy_text),R.drawable.image_2)));

        LinearLayoutManager linearVertical = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        timelineRV.setLayoutManager(linearVertical);
        TimelineAdapter timelineAdapter = new TimelineAdapter(this,timelines);
        timelineRV.setAdapter(timelineAdapter);

        reviews = new ArrayList<>();
        for (int i=0;i<10;i++){
            reviews.add(new Reviews());
        }
        LinearLayoutManager linearHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        reviewsRV.setLayoutManager(linearHorizontal);

        DetailReviewsAdapter reviewsAdapter = new DetailReviewsAdapter(this,reviews);
        reviewsRV.setAdapter(reviewsAdapter);

        totalReviews.setText(reviewsAdapter.getItemCount()+" reviews");




    }
}
