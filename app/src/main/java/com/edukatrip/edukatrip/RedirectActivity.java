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

        Button btnChooseTourGuide = findViewById(R.id.btn_go_choose_guide);
        btnChooseTourGuide.setOnClickListener(this);
        Button btnHome = findViewById(R.id.btn_go_home);
        btnHome.setOnClickListener(this);
        Button btnSignIn = findViewById(R.id.btn_go_sign_in);
        btnSignIn.setOnClickListener(this);
        Button btnBookTour = findViewById(R.id.btn_go_book_tour);
        btnBookTour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_go_choose_guide:
                intent = new Intent(RedirectActivity.this, ChooseTourGuideActivity.class);
                break;
            case R.id.btn_go_home:
                intent = new Intent(RedirectActivity.this, MainActivity.class);
                break;
            case R.id.btn_go_sign_in:
                intent = new Intent(RedirectActivity.this, SignInActivity.class);
                break;
            case R.id.btn_go_book_tour:
                intent = new Intent(RedirectActivity.this, BookTourActivity.class);
                break;
        }
        startActivity(intent);
    }
}
