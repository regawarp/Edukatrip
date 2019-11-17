package com.edukatrip.edukatrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.edukatrip.edukatrip.R;
import com.squareup.picasso.Picasso;

public class EduImageGridAdapter extends BaseAdapter {
    private int[] dataGambar;
    private Context context;
    LayoutInflater inflater;

    public EduImageGridAdapter(Context context,int[] dataGambar) {
        this.dataGambar = dataGambar;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataGambar.length;
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
            convertView = inflater.inflate(R.layout.detail_edu_image_item,null);
        }
        ImageView imageView = (ImageView)convertView.findViewById(R.id.detail_edu_image_galery);

        Picasso.get()
                .load(dataGambar[position])
                .into(imageView);

        return convertView;
    }
}
