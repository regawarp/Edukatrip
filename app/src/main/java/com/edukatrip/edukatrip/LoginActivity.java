package com.edukatrip.edukatrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.edukatrip.edukatrip.Login.LoginFragment;
import com.edukatrip.edukatrip.Login.RegisterFragment;
import com.edukatrip.edukatrip.Login.TabAdapter;
import com.edukatrip.edukatrip.R;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewPager = (ViewPager)findViewById(R.id.viewPager_login);
        tabLayout = (TabLayout)findViewById(R.id.tab_bar_login);

        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoginFragment(),"Login");
        adapter.addFragment(new RegisterFragment(),"Register");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }
}
