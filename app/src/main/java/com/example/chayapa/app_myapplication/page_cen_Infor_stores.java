package com.example.chayapa.app_myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class page_cen_Infor_stores extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imagUser,imvprom1,imvprom2,imvprom3;
    TextView textNameStore,textOwnerName,textCall,textAdd,textpro,
                boxNameStore,boxOwnerName,boxCall,boxAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_cen__infor_stores);

        imagUser = (ImageView)findViewById(R.id.img_yourlogo);
        textNameStore = (TextView)findViewById(R.id.text_name_store);
        boxNameStore =(TextView) findViewById(R.id.editT_call_store);
        textOwnerName = (TextView)findViewById(R.id.text_owner_store);
        boxOwnerName = (TextView) findViewById(R.id.editT_owner_store);
        textCall = (TextView)findViewById(R.id.text_call_store);
        boxCall = (TextView) findViewById(R.id.editT_call_store);
        textAdd = (TextView)findViewById(R.id.text_add_store);
        boxAdd = (TextView) findViewById(R.id.editT_add_store);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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


//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent gotocenter = new Intent(page_cen_Infor_stores.this,page_center.class);
            startActivity(gotocenter);
        } else if (id == R.id.nav_id) {
            Intent gotoinfor = new Intent(page_cen_Infor_stores.this,page_cen_Infor.class);
            startActivity(gotoinfor);

        } else if (id == R.id.nav_cafa) {
            Intent gotocafa = new Intent(page_cen_Infor_stores.this,page_cen_stores.class);
            startActivity(gotocafa);

        } else if (id == R.id.nav_out) {
            Intent gotoout = new Intent(page_cen_Infor_stores.this,choice_login.class);
            startActivity(gotoout);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
