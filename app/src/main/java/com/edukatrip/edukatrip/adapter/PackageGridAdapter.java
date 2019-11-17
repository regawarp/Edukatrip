package com.edukatrip.edukatrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.edukatrip.edukatrip.R;
import com.edukatrip.edukatrip.model.Package;

import java.util.ArrayList;

public class PackageGridAdapter extends ArrayAdapter {
    private ArrayList<Package> packageArrayList;

    public PackageGridAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Package> objects) {
        super(context, resource, objects);
        packageArrayList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        LayoutInflater inflater = LayoutInflater.from(getContext());
        itemView = inflater.inflate(R.layout.package_grid_item, null);

        ImageView imgPackage = itemView.findViewById(R.id.img_package);
        TextView tvPackageType = itemView.findViewById(R.id.tv_package_type);
        TextView tvPackageName = itemView.findViewById(R.id.tv_package_name);
        TextView tvPackagePrice = itemView.findViewById(R.id.tv_package_price);
        RatingBar ratingPackage = itemView.findViewById(R.id.rating_package);
        TextView tvReviewCount = itemView.findViewById(R.id.tv_review_count);

        Package aPackage = packageArrayList.get(position);
        imgPackage.setImageResource(aPackage.getPackagePictures());
        tvPackageType.setText("University - Educational Tour");
        tvPackageName.setText(aPackage.getPackageTitle());
        tvPackagePrice.setText(String.format("Rp. %s / person", aPackage.getTotalPrice()));
        ratingPackage.setRating((float) 4.5);

        tvReviewCount.setText("(299 reviews)");

        return itemView;
    }
}