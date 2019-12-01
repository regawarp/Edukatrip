package com.edukatrip.edukatrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.edukatrip.edukatrip.login.SignInActivity;

public class RedirectActivity extends AppCompatActivity implements View.OnClickListener {
    //    Activity ini dibuat untuk keperluan testing saja dan
//    akan dihapus saat development selesai
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect);

        Button btnChooseTourGuide = findViewById(R.id.btnChooseTourGuide);
        btnChooseTourGuide.setOnClickListener(this);
        Button btnHome = findViewById(R.id.btnHome);
        btnHome.setOnClickListener(this);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnChooseTourGuide:
                intent = new Intent(RedirectActivity.this, ChooseTourGuideActivity.class);
                break;
            case R.id.btnHome:
                intent = new Intent(RedirectActivity.this, MainActivity.class);
                break;
            case R.id.btnSignIn:
                intent = new Intent(RedirectActivity.this, SignInActivity.class);
                break;
        }
        startActivity(intent);
    }
}
