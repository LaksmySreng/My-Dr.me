package com.paragoniu.drme;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.paragoniu.drme.R;

public class MenuActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        // Use custom toolbar instead of toolbar (actionbar) from the Theme
      //  Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Register context menu to the image view
        ImageView imgLogo = findViewById(R.id.img_logo);
        registerForContextMenu(imgLogo);
    }

    // To create context menu


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_context, menu);

    }

    // To create option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_option, menu);
        return true;

    }

    // To detect when user clicked on items of the options menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mnu_search) {
            Toast.makeText(this, R.string.search, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_profile){
            Toast.makeText(this, R.string.account, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_log_out){
            Toast.makeText(this, R.string.log_out, Toast.LENGTH_LONG).show();
        }

        return true;
    }

    // To detect when user clicked on items of the context menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mnu_doctor){
            Toast.makeText(this, R.string.doctors, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_favorites){
            Toast.makeText(this, R.string.favorites, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_signup){
            Toast.makeText(this, R.string.sign, Toast.LENGTH_LONG).show();
        }

        return true;
    }

    // To detect when user clicks on popup menu items
    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if(item.getItemId() == R.id.mnu_doctor){
            Toast.makeText(this, R.string.doctors, Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.mnu_favorites){
            Toast.makeText(this, R.string.favorites, Toast.LENGTH_LONG).show();
        }else if (item.getItemId() == R.id.mnu_signup){
            Toast.makeText(this, R.string.sign, Toast.LENGTH_LONG).show();
        }


        return true;
    }

//    // To detect when user clicks on 3 vertical dots
//    public void onOptionImageClick(View view){
//        ImageView imgOption = findViewById(R.id.img_option);
//        PopupMenu popupMenu = new PopupMenu(this, imgOption);
//        popupMenu.inflate(R.menu.activity_main_context);
//        popupMenu.setOnMenuItemClickListener(this);
//        popupMenu.show();
//    }


}