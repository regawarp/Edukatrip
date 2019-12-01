package com.edukatrip.edukatrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;
import com.edukatrip.edukatrip.model.Guide;

import java.util.ArrayList;

public class ListTourGuideAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Guide> guides;
    LayoutInflater inflater;

    public ListTourGuideAdapter(Context context, ArrayList<Guide> guides, LayoutInflater inflater) {
        this.context = context;
        this.guides = guides;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return guides.size();
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
        RatingBar bintang = (RatingBar) convertView.findViewById(R.id.tour_guide_star);

        image.setImageResource(R.drawable.tour_guide);
        nama.setText(guides.get(position).getGuideName());
        bio.setText(guides.get(position).getGuideBio());
        bintang.setRating((float) 4);

        return convertView;
    }
}
