package com.example.chayapa.app_myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;



public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    private static final String URL = "http://10.80.10.22/work/test_api.php";
    private String TAG = MainActivity.class.getSimpleName();
    //main
    TextView topicMain;
    EditText nameMain;
    EditText passMain;
    Button submitMain;
    ProgressDialog prg;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editorShared;




//    public void aleatDetail(){
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//        builder.setTitle("                      รู้หรือไม่?");
//        builder.setMessage("\nขวด 1 ขวด ลดคาร์บอนไดออกไซด์ได้ 62.265 กรัมCO2\n" +
//                "\nแก้ว 1 ใบ  ลดคาร์บอนไดออกไซด์ได้ 25.293 กรัมCO2");
//        builder.setNegativeButton("ตกลง", null);
//        builder.show();
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        progressBar = (ProgressBar) findViewById(R.id.pgb);
//
//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//                func();
//            }
//        });



        //final AlertDialog.Builder dDialog = new AlertDialog.Builder(this);
        //main
        topicMain = (TextView)findViewById(R.id.topic_main);
        nameMain = (EditText)findViewById(R.id.boxname_main);
        passMain = (EditText) findViewById(R.id.boxpass_main);
        submitMain = (Button)findViewById(R.id.submit_main);
        submitMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

//                prg = new ProgressDialog(MainActivity.this);
//                prg.setMessage("รอสักครู่...");
//                prg.setCancelable(false);
//                prg.show();
//
//                dDialog.setTitle("Do you know??");
//                dDialog.setMessage("Sawatdee Android!");
//                dDialog.show();

            //    aleatDetail();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent gotocen = new Intent(MainActivity.this, page_center.class);
                        startActivity(gotocen);
                        MainActivity.this.finish();
                    }
                },5000);
//                Intent gotocen = new Intent(MainActivity.this, page_center.class);
//                startActivity(gotocen);

                int user = nameMain.getText().toString().trim().length();
                int pass = passMain.getText().toString().trim().length();
                if (user == 0 || pass == 0) {
                    Toast.makeText(MainActivity.this, "กรุณากรอกข้อมูลให้สมบูรณ์", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent1);
                    if (user == 0) {
                        nameMain.setError("กรุณากรอกข้อมูลให้สมบูรณ์");
                        Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent2);
                    }
                    if (pass == 0) {
                        passMain.setError("กรุณากรอกข้อมูลให้สมบูรณ์");
                        Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent3);
                    }
                } else {

                        SharedPreferences sharedPreferences = getSharedPreferences("userlogin", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username","");
                        editor.putString("password","");
                        editor.commit();
                 //   Toast.makeText(MainActivity.this, "No Connection! ", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(MainActivity.this, page_center.class);
                    startActivity(intent4);
                }

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) { // ดึงค่าจาก api (json มาแกะ) แสดงผล
                        try {
                            Log.d(TAG, "result:=" + response);

                            JSONObject j = new JSONObject(response);
                            String result_status = j.getString("status");
                            String result_message = j.getString("result");

                        } catch (Exception e) {
                            // e.printStackTrace();
                            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Catch :: " + e.toString());
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, error.toString());
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onErrorResponse Catch :: " + error.toString());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() {  // ส่งไป api
                        Map<String, String> params = new HashMap<String, String>();

                        params.put("email", nameMain.getText().toString());
                        params.put("password", passMain.getText().toString());

                        return params;
                    }
                };
                requestQueue.add(request);
            }

        });


    }
//    private void func(){
//        new Handler().postDelayed(new Runnable() {
//            public void run() {
//                // handler
//                progressBar.setVisibility(View.GONE);
//            }
//        }, 2500);
//    }


}
