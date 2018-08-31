package com.example.chayapa.app_myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


public class into extends AppCompatActivity { private static final int REFRESH_SCREEN = 1;
   ImageView logo;
   private Handler handler;
   private Runnable  runnable;
   long delay_time;
   private final int time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into);

        logo = (ImageView)findViewById(R.id.imageView2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(into.this,choice_login.class);
                into.this.startActivity(intent);
                into.this.finish();
            }
        },time);


//        SharedPreferences pref = getApplicationContext().getSharedPreferences("login",MODE_PRIVATE);
//        boolean status_login = pref.getBoolean("login",false);
//        if(status_login) { // login
//            Intent intent = new Intent(into.this,choice_login.class);
//            startActivity(intent);
//            finish();
//        }
//        else if(!status_login){  // !login
//            Intent intent = new Intent(into.this,choice_login.class);
//            startActivity(intent);
//            finish();
//        }


    }


}
