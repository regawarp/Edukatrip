package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edukatrip.edukatrip.adapter.TimelineAdapter;
import com.edukatrip.edukatrip.model.Places;
import com.edukatrip.edukatrip.model.Timeline;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateTimelineActivity extends AppCompatActivity {
    Button btnAdd,btnEnd;
    private RecyclerView timelineRV;
    private List<Timeline> timelines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_timeline);

        initialize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        timelineRV.setLayoutManager(layoutManager);

        timelines = new ArrayList<>();
        timelines.add(new Timeline(new Date(),new Date(),new Places("Hotel Kamboja","Meeting Point",50000,getResources().getString(R.string.dummy_text),R.drawable.image_2)));
        timelines.add(new Timeline(new Date(),new Date(),new Places("Hotel Kamboja","Meeting Point",50000,getResources().getString(R.string.dummy_text),R.drawable.image_2)));
        timelines.add(new Timeline(new Date(),new Date(),new Places("Hotel Kamboja","Meeting Point",50000,getResources().getString(R.string.dummy_text),R.drawable.image_2)));

        TimelineAdapter adapter = new TimelineAdapter(this,timelines);
        timelineRV.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AddNextDestinationActivity.class));
            }
        });

    }

    public void initialize(){
        timelineRV = (RecyclerView)findViewById(R.id.ct_timeline_rv);
        btnAdd = (Button)findViewById(R.id.ct_btn_add);
        btnEnd = (Button)findViewById(R.id.ct_btn_end);
    }
}
