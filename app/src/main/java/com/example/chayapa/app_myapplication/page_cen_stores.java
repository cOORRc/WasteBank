package com.example.chayapa.app_myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class page_cen_stores extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    CardView card1,card2,card3,card4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_cen_stores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//เพิ่ม31


        card1 = (CardView) findViewById(R.id.card_view1); // creating a CardView and assigning a value.
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoinforstores = new Intent(page_cen_stores.this,page_cen_Infor_stores.class);
                startActivity(gotoinforstores);
            }
        });

        card2 = (CardView) findViewById(R.id.card_view2); // creating a CardView and assigning a value.
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoinforstores = new Intent(page_cen_stores.this,page_cen_Infor_stores.class);
                startActivity(gotoinforstores);
            }
        });

        card3 = (CardView) findViewById(R.id.card_view3); // creating a CardView and assigning a value.
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoinforstores = new Intent(page_cen_stores.this,page_cen_Infor_stores.class);
                startActivity(gotoinforstores);
            }
        });

    card4 = (CardView) findViewById(R.id.card_view4); // creating a CardView and assigning a value.

        card4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent gotoinforstores = new Intent(page_cen_stores.this,page_cen_Infor_stores.class);
            startActivity(gotoinforstores);
        }
    });
}


//
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intentcenter = new Intent(page_cen_stores.this,page_center.class);
            startActivity(intentcenter);
        } else if (id == R.id.nav_id) {
            Intent gotoinfor = new Intent(page_cen_stores.this,page_cen_Infor.class);
            startActivity(gotoinfor);

        } else if (id == R.id.nav_cafa) {
            Intent gotocafa = new Intent(page_cen_stores.this,page_cen_stores.class);
            startActivity(gotocafa);

        } else if (id == R.id.nav_out) {
            Intent gotoout = new Intent(page_cen_stores.this,choice_login.class);
            startActivity(gotoout);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
