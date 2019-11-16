package com.edukatrip.edukatrip;


import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.edukatrip.edukatrip.adapter.PackageGridAdapter;
import com.edukatrip.edukatrip.adapter.SliderAdapter;
import com.edukatrip.edukatrip.detailedutour.customGridView;
import com.edukatrip.edukatrip.model.Package;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private ArrayList<Package> packageArrayList = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        CardView educationalTour = view.findViewById(R.id.eduTour);

        educationalTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EduTourFragment fragment = new EduTourFragment();
                ((MainActivity) getActivity()).openFragment(fragment);
            }
        });

        // Slider
        SliderView sliderView = view.findViewById(R.id.slider);
        sliderView.setSliderAdapter(new SliderAdapter(getContext()));
        sliderView.setIndicatorAnimation(IndicatorAnimations.SLIDE); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        // Grid
        initializeFavPackageData();
        customGridView gridFavorite = view.findViewById(R.id.grid_favorite);
        PackageGridAdapter packageGridAdapter = new PackageGridAdapter(getContext(), R.id.tv_package_name, packageArrayList);
        gridFavorite.setAdapter(packageGridAdapter);
    }

    private void initializeFavPackageData(){
        packageArrayList.add(new Package("1","Educational Tour A",28000,R.drawable.outdoors_cities));
        packageArrayList.add(new Package("2","Educational Tour B",27000,R.drawable.outdoors_cities));
        packageArrayList.add(new Package("3","Educational Tour C",26000,R.drawable.outdoors_cities));
        packageArrayList.add(new Package("4","Educational Tour D",25000,R.drawable.outdoors_cities));
    }
}
