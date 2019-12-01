package com.edukatrip.edukatrip;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class BookTourActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int PERSON_LIMIT = 5;
    Toolbar toolbar;
    private int totalPerson = 1;
    private Button btnAddPerson, btnRemovePerson;
    private TextView tvTotalPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_tour);

        toolbar = (Toolbar) findViewById(R.id.booktour_tb);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        tvTotalPerson = findViewById(R.id.booktour_total);
        btnAddPerson = findViewById(R.id.booktour_btn_add);
        btnRemovePerson = findViewById(R.id.booktour_btn_remove);
        btnAddPerson.setOnClickListener(this);
        btnRemovePerson.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.booktour_btn_add:
                if (isLessThanLimit()) {
                    ++totalPerson;
                    showTotalPerson();
                }
                break;
            case R.id.booktour_btn_remove:
                if (isMoreThanOne()) {
                    --totalPerson;
                    showTotalPerson();
                }
                break;
        }
    }

    private boolean isMoreThanOne() {
        return totalPerson > 1;
    }

    private boolean isLessThanLimit() {
        return totalPerson < PERSON_LIMIT;
    }

    private void showTotalPerson() {
        tvTotalPerson.setText(String.valueOf(totalPerson));
    }
}
