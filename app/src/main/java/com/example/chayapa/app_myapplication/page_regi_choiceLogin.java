package com.example.chayapa.app_myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;




//ลบได้ไฟล์นี้

public class page_regi_choiceLogin extends AppCompatActivity {
    private static final String URL = "http://192.168.65.128/wastebank/android_api/page_regi_login.php";
    private String TAG = page_regiLogin.class.getSimpleName();

    TextView topicRegiChoiceLogin;
    EditText nameBoxRegiChoiceLogin,passBoxRegiChoiceLogin;
    Button btn_login,btn_newlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_login);

        nameBoxRegiChoiceLogin = (EditText) findViewById(R.id.box_name_regiChoiceLogin);
        passBoxRegiChoiceLogin = (EditText)findViewById(R.id.box_pass_regiChoiceLogin);
        btn_login = (Button)findViewById(R.id.butt_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue requestQueue = Volley.newRequestQueue(page_regi_choiceLogin.this);
                StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d(TAG, "dddd :: " + response);
                            JSONObject j = new JSONObject(response);
                            String result_status = j.getString("status");
                            String result_message = j.getString("result");
                            switch (result_status) {
                                case "true":
                                    Toast.makeText(getApplicationContext(), result_message, Toast.LENGTH_LONG).show();
                                    break;
                                case "false":
                                    Toast.makeText(getApplicationContext(), result_message, Toast.LENGTH_LONG).show();
                                    break;
                            }

                        } catch (Exception e) {
                            // e.printStackTrace();
                            Toast.makeText(page_regi_choiceLogin.this, e.toString(), Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Catch :: " + e.toString());
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, error.toString());
                        Toast.makeText(page_regi_choiceLogin.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onErrorResponse Catch :: " + error.toString());
                    }
                })

                {
                    @Override
                    protected Map<String, String> getParams(){  // ส่งไป api
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", nameBoxRegiChoiceLogin.getText().toString());
                        params.put("pass", passBoxRegiChoiceLogin.getText().toString());

                        return params;

                    }
                };
                requestQueue.add(request);

                Intent gotoPageMain = new Intent(page_regi_choiceLogin.this,page_center.class);
                startActivity(gotoPageMain);

            }
        });

        btn_newlogin = (Button)findViewById(R.id.butt_newRegi);
        btn_newlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoPageMain = new Intent(page_regi_choiceLogin.this,page_regiLogin.class);
                startActivity(gotoPageMain);
            }
        });




    }
}
