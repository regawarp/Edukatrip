package com.edukatrip.edukatrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edukatrip.edukatrip.R;
import com.edukatrip.edukatrip.model.Facilities;

import java.util.List;

public class FacGridAdapter extends BaseAdapter {
    private Context context;
    private List<Facilities> data;
    private LayoutInflater inflater;

    public FacGridAdapter(Context context, List<Facilities> data) {
        this.context = context;
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.detail_edu_grid_fac_item,null);
        }
        ImageView image = (ImageView)convertView.findViewById(R.id.grid_fac_image);
        TextView title = (TextView) convertView.findViewById(R.id.grid_fac_title);
        TextView desc= (TextView) convertView.findViewById(R.id.grid_fac_desc);

        image.setImageResource(data.get(position).getImage());
        title.setText(data.get(position).getName());
        desc.setText(data.get(position).getDecription());
        return convertView;
    }
}
