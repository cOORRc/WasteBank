package com.example.chayapa.app_myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import com.facebook.login.LoginManager;

public class page_cen_Infor extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imgUserInfor;
    TextView text_name_infor,text_email_infor,text_depart_infor,text_date_infor,
            txtbox_name_infor,txtbox_email_infor,txtbox_depart_infor,txtbox_date_infor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_cen_infor);

        imgUserInfor = (ImageView)findViewById(R.id.imgV_user_cenInfor);
        text_name_infor = (TextView)findViewById(R.id.textV_name_cenInfor);
        txtbox_name_infor = (TextView)findViewById(R.id.Text_namebox_cenInfor);
        text_email_infor=(TextView)findViewById(R.id.textV_mail_cenInfor);
        txtbox_email_infor = (TextView)findViewById(R.id.text_mail_cenInfor);
        text_depart_infor = (TextView)findViewById(R.id.textV_depart_cenInfor);
        txtbox_depart_infor= (TextView)findViewById(R.id.text_depart_cenInfor);
        text_date_infor = (TextView)findViewById(R.id.textV_date_cenInfor);
        txtbox_date_infor = (TextView) findViewById(R.id.text_dte_cenInfor);

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.page_cen_infor, menu);
//        return true;
//    }
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
            Intent intentcenter = new Intent(page_cen_Infor.this,page_center.class);
            startActivity(intentcenter);
        } else if (id == R.id.nav_id) {
            Intent gotoinfor = new Intent(page_cen_Infor.this,page_cen_Infor.class);
            startActivity(gotoinfor);

        } else if (id == R.id.nav_cafa) {
            Intent gotocafa = new Intent(page_cen_Infor.this,page_cen_stores.class);
            startActivity(gotocafa);

        } else if (id == R.id.nav_out) {
            Intent gotoout = new Intent(page_cen_Infor.this,choice_login.class);
            startActivity(gotoout);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
