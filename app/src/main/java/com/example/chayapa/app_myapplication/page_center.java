package com.example.chayapa.app_myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class page_center extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        ImageView imgUser;
        ImageButton bottle_buttom,cup_buttom;
        TextView text_username,text_uni,text_statics;
        ImageView imgbott,imgcup,imgcost,imgco;
        TextView text_bott,tvDBbott,tvGbott,
                text_cup,tvDBcup,tvGcup,
                text_cost,tvDBcost,tvGcost,
                text_co,tvDBco,tvGco;

        private static final int REQUEST_CAMERA = 1;


    public void aleatDetail(){
        AlertDialog.Builder builder = new AlertDialog.Builder(page_center.this);
        builder.setTitle("                      รู้หรือไม่?");
        builder.setMessage("\nขวด 1 ขวด ลดคาร์บอนไดออกไซด์ได้ 62.265 กรัมCO2\n" +
                "\nแก้ว 1 ใบ  ลดคาร์บอนไดออกไซด์ได้ 25.293 กรัมCO2");
        builder.setNegativeButton("ตกลง", null);
        builder.show();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_center);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aleatDetail();
        imgUser = (ImageView)findViewById(R.id.imgProfile);
        text_username = (TextView) findViewById(R.id.tv_userName);
        text_uni = (TextView) findViewById(R.id.textV_edu);

        bottle_buttom = (ImageButton)findViewById(R.id.imageB_bottel);
        bottle_buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosaveimag = new Intent(page_center.this,page_cen_savepic.class);
                startActivity(gotosaveimag);
            }
        });


        if (ActivityCompat.checkSelfPermission(page_center.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(page_center.this, new String[]{android.Manifest.permission.CAMERA}, REQUEST_CAMERA);
        }

        cup_buttom = (ImageButton)findViewById(R.id.imageB_cup);
        cup_buttom.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent gotoscen = new Intent(page_center.this,page_cen_scanner.class);
                startActivity(gotoscen);
            }
        });

        text_statics = (TextView)findViewById(R.id.textV_sta);
        imgbott = (ImageView)findViewById(R.id.bott);
        text_bott = (TextView)findViewById(R.id.textV_bott);
        tvDBbott = (TextView)findViewById(R.id.textV_bott2);
        tvGbott = (TextView)findViewById(R.id.textV_bott3);
        imgcup = (ImageView)findViewById(R.id.cup);
        text_cup = (TextView)findViewById(R.id.textV_cup);
        tvDBcup = (TextView)findViewById(R.id.textV_cup2);
        tvGcup = (TextView)findViewById(R.id.textV_cup3);
        imgcost = (ImageView)findViewById(R.id.money);
        text_cost = (TextView) findViewById(R.id.textV_money);
        tvDBcost = (TextView)findViewById(R.id.textV_money);
        tvGcost = (TextView)findViewById(R.id.textV_money3);
        imgco = (ImageView)findViewById(R.id.co);
        text_co = (TextView)findViewById(R.id.textV_co);
        tvDBco = (TextView)findViewById(R.id.textV_co2);
        tvGco = (TextView)findViewById(R.id.textV_co3);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

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
            Intent intentcenter = new Intent(page_center.this,page_center.class);
            startActivity(intentcenter);
        } else if (id == R.id.nav_id) {
            Intent gotoinfor = new Intent(page_center.this,page_cen_Infor.class);
            startActivity(gotoinfor);

        } else if (id == R.id.nav_cafa) {
            Intent gotocafa = new Intent(page_center.this,page_cen_stores.class);
            startActivity(gotocafa);

        } else if (id == R.id.nav_out) {
            Intent gotoout = new Intent(page_center.this,choice_login.class);
            startActivity(gotoout);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
