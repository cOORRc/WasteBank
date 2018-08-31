package com.example.chayapa.app_myapplication;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class page_cen_savepic extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView text_question,text_baht;
    EditText box_money;
    ImageView view_pic;
    Button savedata_button;
    static final int REQUEST_CAMERA = 2;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_cen_savepic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        view_pic = (ImageView) findViewById(R.id.image_viewpic);
        text_question = (TextView)findViewById(R.id.textV_question);
        box_money = (EditText) findViewById(R.id.box_money);
        text_baht = (TextView)findViewById(R.id.textV_baht);

        savedata_button = (Button)findViewById(R.id.button_savepic);
        savedata_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocenter = new Intent(page_cen_savepic.this,page_center.class);
                startActivity(gotocenter);
            }
        });


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
            Intent intentcenter = new Intent(page_cen_savepic.this,page_center.class);
            startActivity(intentcenter);
        } else if (id == R.id.nav_id) {
            Intent gotoinfor = new Intent(page_cen_savepic.this,page_cen_Infor.class);
            startActivity(gotoinfor);

        } else if (id == R.id.nav_cafa) {
            Intent gotocafa = new Intent(page_cen_savepic.this,page_cen_stores.class);
            startActivity(gotocafa);

        } else if (id == R.id.nav_out) {
            Intent gotoout = new Intent(page_cen_savepic.this,choice_login.class);
            startActivity(gotoout);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            view_pic.setImageBitmap(imageBitmap);
        }
    }
}

