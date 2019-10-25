package com.edukatrip.edukatrip;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.edukatrip.edukatrip.DetailEduTour.Tour;
import com.edukatrip.edukatrip.DetailEduTour.gridRatedAdapter;

public class EduTourFragment extends Fragment {
    GridView gridRated, gridPrice;
    Tour[] data = {new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour A","Rp. 29.000 / person",5,"(290 Reviews)"),
            new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour B","Rp. 28.000 / person",5,"(300 Reviews)"),
            new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour C","Rp. 27.000 / person",5,"(310 Reviews)"),
            new Tour(R.drawable.outdoors_cities,"UNIVERSITY - EDUCATIONAL TOUR","Educational Tour D","Rp. 26.000 / person",5,"(320 Reviews)"),
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = (View)inflater.inflate(R.layout.fragment_edu_tour,container,false);

        gridRated = (GridView)v.findViewById(R.id.gridRated);
        gridPrice = (GridView)v.findViewById(R.id.gridPrice);

        gridRatedAdapter ratedAdapter = new gridRatedAdapter(((AppCompatActivity)getActivity()),data);
        gridRated.setAdapter(ratedAdapter);

        gridPrice.setAdapter(ratedAdapter);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnRated = (Button)view.findViewById(R.id.btnShowRated);

        btnRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(((MainActivity)getActivity()).getApplicationContext(),ChooseDateActivity.class));
            }
        });
    }
}
