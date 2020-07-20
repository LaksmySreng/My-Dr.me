package com.paragoniu.drme;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.paragoniu.drme.R;
import com.paragoniu.drme.HomeFragement;
import com.paragoniu.drme.ProfileFragement;

public class BottomNav extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    public static final String EXTRA_USERNAME = "USERNAME";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_bottom_nav);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Bottom Nav Bar
        BottomNavigationView bottomNav = findViewById(R.id.bootom_nav);
        bottomNav.setOnNavigationItemSelectedListener(this);

        // Fragment
        showFragment(new ProfileFragement());
        getSupportActionBar().setTitle(R.string.account);

        // Extract username from the Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra(EXTRA_USERNAME);
        Toast.makeText(this, username, Toast.LENGTH_LONG).show();


        FusedLocationProviderClient fusedLocationProviderClient = null;
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mnu_search) {
            showFragment(new ProfileFragement());
            getSupportActionBar().setTitle(R.string.search);
        } else if (item.getItemId() == R.id.mnu_home) {
            showFragment(new HomeFragement());
            getSupportActionBar().setTitle(R.string.search);
        } else {
            showFragment(new ProfileFragement());
            getSupportActionBar().setTitle(R.string.account);
        }

        return true;
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.lyt_fragment_container, fragment);
        fragmentTransaction.commit();
    }

}