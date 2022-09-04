package com.example.quran360;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                Intent intent;
                switch (menuItem.getItemId())
                {
                    case R.id.home :
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.surah_list :
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        intent = new Intent(MainActivity.this, SurahList.class);
                        startActivity(intent);
                        //drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.nav_chrome_reader :
                        Toast.makeText(getApplicationContext(),"Chrome Reader is clicked",Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

                return true;
            }
        });





    }
}