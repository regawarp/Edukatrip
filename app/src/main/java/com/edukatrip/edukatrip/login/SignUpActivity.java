package com.edukatrip.edukatrip.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.edukatrip.edukatrip.DetailEduTourActivity;
import com.edukatrip.edukatrip.MainActivity;
import com.edukatrip.edukatrip.R;

public class SignUpActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        toolbar = (Toolbar)findViewById(R.id.sign_up_tb);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.arrow_left_black));

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnSignUp = (Button)findViewById(R.id.sign_up_button);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}
