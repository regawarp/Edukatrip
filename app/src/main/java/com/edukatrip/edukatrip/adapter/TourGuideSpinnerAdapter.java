package com.edukatrip.edukatrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class TourGuideSpinnerAdapter extends BaseAdapter {
    String[] nama;
    int[] gambar;
    Context ctx;
    LayoutInflater inflater;

    public TourGuideSpinnerAdapter(Context ctx,String[] nama, int[] gambar) {
        this.nama = nama;
        this.gambar = gambar;
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return nama.length;
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
        if (convertView==null){
            convertView = inflater.inflate(R.layout.tour_guide_spinner_item,null);

        }
        CircleImageView imageView =(CircleImageView) convertView.findViewById(R.id.tour_spinner_image);
        TextView txtNama =(TextView) convertView.findViewById(R.id.tour_spinner_name);
        imageView.setImageResource(gambar[position]);
        txtNama.setText(nama[position]);
        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = inflater.inflate(R.layout.tour_guide_spinner_item_dialog,null);

        }
        CircleImageView imageView =(CircleImageView) convertView.findViewById(R.id.tour_spinner_image_dialog);
        TextView txtNama =(TextView) convertView.findViewById(R.id.tour_spinner_name_dialog);
        LinearLayout layout = (LinearLayout)convertView.findViewById(R.id.tour_spinner_ll_dialog);

        imageView.setImageResource(gambar[position]);
        txtNama.setText(nama[position]);
        return convertView;
    }
}
