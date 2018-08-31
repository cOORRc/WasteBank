package com.example.chayapa.app_myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;


public class choice_login extends AppCompatActivity {
    ImageView logo,line,btn_face;
    EditText box_email,box_pass;
    Button btn_login,btn_newregi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_login);

        logo = (ImageView)findViewById(R.id.imageView3);
        box_email = (EditText)findViewById(R.id.box_name_regiChoiceLogin);
        box_pass = (EditText)findViewById(R.id.box_pass_regiChoiceLogin);

        btn_login = (Button)findViewById(R.id.butt_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotocen = new Intent(choice_login.this, page_center.class);
                startActivity(gotocen);
            }
        });


        btn_face = (ImageView) findViewById(R.id.login_face);
        btn_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        line = (ImageView)findViewById(R.id.line_grey);
        btn_newregi = (Button)findViewById(R.id.butt_newRegi);
        btn_newregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_newregi = new Intent(choice_login.this, page_regiLogin.class);
                startActivity(goto_newregi);

            }
        });

    }
}
