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
import com.edukatrip.edukatrip.customview.CustomGridView;
import com.edukatrip.edukatrip.model.Package;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    private ArrayList<Package> packageArrayList = new ArrayList<>();
    private PackageGridAdapter packageGridAdapter;

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
        getFavPackageFromDb();
        CustomGridView gridFavorite = view.findViewById(R.id.grid_favorite);
        packageGridAdapter = new PackageGridAdapter(getContext(), R.id.tv_package_name, packageArrayList);
        gridFavorite.setAdapter(packageGridAdapter);
    }

    private void getFavPackageFromDb() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("packages")
                .limit(4)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Package aPackage = document.toObject(Package.class);
                                packageArrayList.add(aPackage);
                                packageGridAdapter.notifyDataSetChanged();
                            }
                        } else {
                            //Error getting document
                        }
                    }
                });
    }
}
