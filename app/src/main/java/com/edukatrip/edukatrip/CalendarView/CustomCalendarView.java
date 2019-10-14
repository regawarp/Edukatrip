package com.edukatrip.edukatrip.CalendarView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.edukatrip.edukatrip.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.Nullable;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class CustomCalendarView extends LinearLayout {
    private Context context;
    private ImageView previousButton;
    private ImageView nextButton;
    private TextView bulan;
    private TextView year;
    private GridView calendarGridView;
    private Calendar cal = Calendar.getInstance(Locale.ENGLISH);
    private static final int MAX_CALENDAR_COLUMN = 42;
    private SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
    private DateAdapter mAdapter;
    private Date choosen;

    public CustomCalendarView(Context context) {
        super(context);
    }

    public CustomCalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setUIlayout();
        setUpCalendarAdapter();
        setNextButtonClickEvent();
        setPreviousButtonClickEvent();
        setGridCellClickEvents();
        Log.d(TAG, "I need to call this method");
    }

    public CustomCalendarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void setUIlayout() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.calendar_view, this);
        previousButton = (ImageView) view.findViewById(R.id.btnPrevMonth);
        nextButton = (ImageView) view.findViewById(R.id.btnNextMonth);
        bulan = (TextView) view.findViewById(R.id.month);
        year = (TextView) view.findViewById(R.id.year);
        calendarGridView = (GridView) view.findViewById(R.id.date);
    }

    private void setPreviousButtonClickEvent() {
        previousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.add(Calendar.MONTH, -1);
                setUpCalendarAdapter();
            }
        });
    }

    private void setNextButtonClickEvent() {
        nextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                cal.add(Calendar.MONTH, 1);
                setUpCalendarAdapter();
            }
        });
    }
    public String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("DD MMMM yyyy", Locale.ENGLISH);
        return formatter.format(choosen);
    }

    private void setGridCellClickEvents() {
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "Clicked " + position, Toast.LENGTH_SHORT).show();
                View v = (View)view.findViewById(R.id.dateCell);
                v.setBackgroundResource(R.drawable.btn_choose_date);
                choosen =(Date) mAdapter.getItem(position);
            }
        });
    }

    private void setUpCalendarAdapter() {
        List<Date> dayValueInCells = new ArrayList<Date>();
        Calendar mCal = (Calendar) cal.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK) - 1;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
        while (dayValueInCells.size() < MAX_CALENDAR_COLUMN) {
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
        }
        Log.d(TAG, "Number of date " + dayValueInCells.size());
        String sDate = formatter.format(cal.getTime());
        bulan.setText(sDate);
        mAdapter = new DateAdapter(context, dayValueInCells, cal);
        calendarGridView.setAdapter(mAdapter);
    }
}
