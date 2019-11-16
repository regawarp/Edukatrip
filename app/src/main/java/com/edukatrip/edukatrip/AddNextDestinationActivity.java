package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddNextDestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_next_destination);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
