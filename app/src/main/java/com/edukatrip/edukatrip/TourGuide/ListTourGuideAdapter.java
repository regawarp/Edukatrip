package com.edukatrip.edukatrip.TourGuide;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;

import java.util.List;

import androidx.annotation.NonNull;

public class ListTourGuideAdapter extends BaseAdapter {
    private Context context;
    private TourGuide[] tourGuides;
    LayoutInflater inflater;

    public ListTourGuideAdapter(Context context, TourGuide[] tourGuides, LayoutInflater inflater) {
        this.context = context;
        this.tourGuides = tourGuides;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return tourGuides.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.tour_guide_item, null); // inflate the layout
        ImageView image = (ImageView) convertView.findViewById(R.id.tour_guide_img); // get the reference of ImageView
        TextView nama = (TextView)convertView.findViewById(R.id.tour_guide_nama);
        TextView bio = (TextView)convertView.findViewById(R.id.tour_guide_bio);
        LinearLayout bintang = (LinearLayout) convertView.findViewById(R.id.tour_guide_star);

        image.setImageResource(tourGuides[position].getGambar());
        nama.setText(tourGuides[position].getNama());
        bio.setText(tourGuides[position].getBio());

        int star = tourGuides[position].getBintang();
        for (int i=0;i<star;i++){
            ImageView imgBintang = new ImageView(context);
            imgBintang.setImageResource(R.drawable.star);

            int size = context.getResources().getDimensionPixelSize(R.dimen.star_size);
            int margin = context.getResources().getDimensionPixelSize(R.dimen.star_margin);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(size,size);
            marginLayoutParams.rightMargin = margin;
            imgBintang.setLayoutParams(marginLayoutParams);
            bintang.addView(imgBintang);

        }

        return convertView;
    }
}
