package com.edukatrip.edukatrip.calendarview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private View tb;

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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec = heightMeasureSpec;
        if (getLayoutParams().height == LayoutParams.WRAP_CONTENT) {
            // The great Android "hackatlon", the love, the magic.
            // The two leftmost bits in the height measure spec have
            // a special meaning, hence we can't use them to describe height.
            heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        }
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
    public void setView(View tb){
        this.tb = tb;
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        return formatter.format(choosen);
    }

    private void setGridCellClickEvents() {
        calendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Date date = (Date)mAdapter.getItem(position);
                RelativeLayout v = (RelativeLayout)view.findViewById(R.id.dateCell);
                TextView tgl = (TextView) view.findViewById(R.id.calendar_date_id);
                TextView dateview = (TextView) view.findViewById(R.id.calendar_day_id);
                String stat = v.getTag().toString();
                if (stat.equals("NOT")){
                    v.setBackgroundResource(R.drawable.date_cell_border);
                    v.setTag("Clicked");
                    tgl.setTextColor(getResources().getColor(R.color.white));
                    tgl.setTypeface(Typeface.DEFAULT_BOLD);
                    dateview.setVisibility(VISIBLE);
                    choosen =(Date) mAdapter.getItem(position);
                    tb.setVisibility(VISIBLE);
                }else if(stat.equals("UnClicked")){

                }else{
                    v.setBackgroundResource(0);
                    v.setTag("NOT");
                    tgl.setTextColor(getResources().getColor(R.color.black));
                    tgl.setTypeface(Typeface.DEFAULT);
                    dateview.setVisibility(GONE);
                    tb.setVisibility(GONE);
                    choosen =(Date) mAdapter.getItem(position);

                }

            }
        });
    }

    private void setUpCalendarAdapter() {
        List<Date> dayValueInCells = new ArrayList<Date>();
        Calendar mCal = (Calendar) cal.clone();
        mCal.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayOfTheMonth = mCal.get(Calendar.DAY_OF_WEEK) - 1;
        mCal.add(Calendar.DAY_OF_MONTH, -firstDayOfTheMonth);
        int idx = 0;
        while (dayValueInCells.size() < MAX_CALENDAR_COLUMN) {
            if(idx==35){
                int month = mCal.get(Calendar.MONTH)+1;
                int current = cal.get(Calendar.MONTH)+1;
                if (month!=current){
                    break;
                }
            }
            dayValueInCells.add(mCal.getTime());
            mCal.add(Calendar.DAY_OF_MONTH, 1);
            idx++;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        String sMonth = formatter.format(cal.getTime());
        String sYear = formatter2.format(cal.getTime());
        bulan.setText(sMonth);
        year.setText(sYear);
        mAdapter = new DateAdapter(context, dayValueInCells, cal);
        calendarGridView.setAdapter(mAdapter);
    }
}
