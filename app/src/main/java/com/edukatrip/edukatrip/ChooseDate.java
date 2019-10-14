package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.edukatrip.edukatrip.CalendarView.CustomCalendarView;

public class ChooseDate extends AppCompatActivity {
    CustomCalendarView dateChooser;
    TextView choosenDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);

        dateChooser = (CustomCalendarView)findViewById(R.id.datepicker);
        choosenDate = (TextView)findViewById(R.id.choosenDate);

        dateChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosenDate.setText(dateChooser.getDate());
            }
        });
    }
}
