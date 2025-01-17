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
import com.edukatrip.edukatrip.model.Tour;

public class GridRatedAdapter extends BaseAdapter {
    private Context context;
    private Tour[] data;
    LayoutInflater inflter;

    public GridRatedAdapter(Context applicationContext, Tour[] data) {
        this.context = applicationContext;
        this.data = data;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.m_detail_tour, null); // inflate the layout
        ImageView image = (ImageView) view.findViewById(R.id.mdetImg); // get the reference of ImageView
        TextView info = (TextView)view.findViewById(R.id.mdetInfo);
        TextView judul = (TextView)view.findViewById(R.id.mdetJudul);
        TextView harga = (TextView)view.findViewById(R.id.mdetPrice);
        TextView review = (TextView)view.findViewById(R.id.mdetReview);
        RatingBar rate = (RatingBar)view.findViewById(R.id.mdetRate);

        image.setImageResource(data[i].getImage());
        info.setText(data[i].getInfo());
        judul.setText(data[i].getJudul());
        harga.setText(data[i].getHarga());
        review.setText(data[i].getReview());
        rate.setRating((float)data[i].getBintang());
        return view;
    }


}
