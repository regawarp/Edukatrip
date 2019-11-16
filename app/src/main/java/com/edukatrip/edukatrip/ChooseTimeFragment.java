package com.edukatrip.edukatrip;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChooseTimeFragment extends Fragment {
    Spinner spinner;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.choose_time_fragment,container,false);

        spinner = (Spinner)v.findViewById(R.id.choose_time_spinner);
        button = (Button)v.findViewById(R.id.choose_time_btn);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
                ChoosePersonFragment fragment = new ChoosePersonFragment();
                activity.openFragment(fragment);
            }
        });
    }
}
