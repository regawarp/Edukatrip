package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toolbar = (Toolbar)findViewById(R.id.profile_toolbar);

        setSupportActionBar(toolbar);
        setTitle("Your Profile");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
