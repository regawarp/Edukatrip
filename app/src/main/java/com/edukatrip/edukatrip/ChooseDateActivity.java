package com.edukatrip.edukatrip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.edukatrip.edukatrip.calendarview.CustomCalendarView;

public class ChooseDateActivity extends AppCompatActivity {
    CustomCalendarView dateChooser;
    TextView choosenDate;
    View tb_choosedate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_date);
        tb_choosedate = (View)findViewById(R.id.tb_choose_date);
        dateChooser = (CustomCalendarView)findViewById(R.id.datepicker);
        choosenDate = (TextView)findViewById(R.id.choosenDate);
        dateChooser.setView(tb_choosedate);
        tb_choosedate.setVisibility(View.GONE);
    }

}
