package com.edukatrip.edukatrip.CalendarView;

import android.content.Context;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DateAdapter extends ArrayAdapter {


    private static final String TAG = DateAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    private List<Date> monthlyDates;
    private Calendar currentDate;
    private boolean status = false;

    public DateAdapter(Context context, List<Date> monthlyDates, Calendar currentDate) {
        super(context, R.layout.date_cell);
        this.monthlyDates = monthlyDates;
        this.currentDate = currentDate;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Date mDate = monthlyDates.get(position);
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(mDate);
        int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
        SimpleDateFormat formatter = new SimpleDateFormat("EEE", Locale.ENGLISH);
        String day = formatter.format(mDate);
        int displayMonth = dateCal.get(Calendar.MONTH) + 1;
        int displayYear = dateCal.get(Calendar.YEAR);
        int currentMonth = currentDate.get(Calendar.MONTH) + 1;
        int currentYear = currentDate.get(Calendar.YEAR);
        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.date_cell, parent, false);
        }
        TextView cellNumber = (TextView) view.findViewById(R.id.calendar_date_id);
        TextView cellday = (TextView) view.findViewById(R.id.calendar_day_id);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.dateCell);

        if (displayMonth == currentMonth && displayYear == currentYear) {
            cellNumber.setText(String.valueOf(dayValue));
            cellday.setText(day);

        } else {
            cellNumber.setText("");
            cellday.setText("");
            relativeLayout.setTag("UnClicked");

        }

        //Add day to calendar

        return view;
        //Add events to the calendar

    }

    @Override
    public int getCount() {
        return monthlyDates.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return monthlyDates.get(position);
    }

    public String getDate(int position) {
        Date mDate = monthlyDates.get(position);
        Calendar dateCal = Calendar.getInstance();
        dateCal.setTime(mDate);
        int dayValue = dateCal.get(Calendar.DAY_OF_MONTH);
        int displayMonth = dateCal.get(Calendar.MONTH) + 1;
        int displayYear = dateCal.get(Calendar.YEAR);

        return String.valueOf(dayValue);
    }

    @Override
    public int getPosition(Object item) {
        return monthlyDates.indexOf(item);
    }
}
