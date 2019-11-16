package com.edukatrip.edukatrip;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ChooseDestinationFragment extends Fragment {

    Spinner spinner;
    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.choose_destination_fragment,container,false);

        spinner = (Spinner)v.findViewById(R.id.choose_destination_spinner);
        button = (Button)v.findViewById(R.id.choose_destination_button);

        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),R.array.spinner_item,R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activity = (MainActivity)getActivity();
                ChooseTimeFragment chooseTimeFragment = new ChooseTimeFragment();
                activity.openFragment(chooseTimeFragment);
            }
        });
    }

}
