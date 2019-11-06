package com.edukatrip.edukatrip.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.edukatrip.edukatrip.ChoosePaymentActivity;
import com.edukatrip.edukatrip.ChooseWhatActivity;
import com.edukatrip.edukatrip.DetailWisataActivity;
import com.edukatrip.edukatrip.R;
import com.edukatrip.edukatrip.TourGuide.TourGuide;
import com.edukatrip.edukatrip.TourGuideActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFragment extends Fragment {
    private Button btn_login;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_login = (Button)view.findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), DetailWisataActivity.class));
            }
        });
        btn_login.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), ChoosePaymentActivity.class));
                return false;
            }
        });


    }
}
