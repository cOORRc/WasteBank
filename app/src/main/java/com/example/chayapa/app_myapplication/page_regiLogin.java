package com.example.chayapa.app_myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.function.Function;

public class page_regiLogin extends AppCompatActivity {
    private static final String URL = "http://192.168.65.128/wastebank/android_api/page_regi_login.php";
    private String TAG = page_regiLogin.class.getSimpleName();

    TextView topicNewMember,passNewMember,NameNewMember,
            EmailNewMember,DepartNewMember;
    EditText passBoxNew,nameBoxNew,emailBoxNew;
    Button submitNewmember;
    Spinner departBoxNew;

    @Override  ////////เขียน spinner เข้า db
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_regi_login);


        AlertDialog.Builder mBuilder = new AlertDialog.Builder(page_regiLogin.this);
        View mView = getLayoutInflater().inflate(R.layout.activity_page_regi_login,null);
        mBuilder.setView(mView);
        topicNewMember = (TextView)findViewById(R.id.topic_newmember);
        passNewMember = (TextView)findViewById(R.id.text_pass_newmember);
        passBoxNew = (EditText)findViewById(R.id.box_pass_newmember);
        NameNewMember = (TextView)findViewById(R.id.text_name_newmember);
        nameBoxNew = (EditText)findViewById(R.id.editTname_newmember);
        EmailNewMember = (TextView)findViewById(R.id.text_mail_newmember);
        emailBoxNew = (EditText)findViewById(R.id.box_mail_newmember);
        DepartNewMember = (TextView) mView.findViewById(R.id.text_depart_newmember);
        departBoxNew = (Spinner) mView.findViewById(R.id.spin_depart_newmember);

        ArrayList<String> depart_array = new ArrayList<>();  //data in spinner
        depart_array.add("เกษตรศาสตร์");
        depart_array.add("วิทยาศาสตร์ ");
        depart_array.add("วิศวกรรมศาสตร์");
        depart_array.add("เภสัชศาสตร์");
        depart_array.add("พยาบาลศาสตร์");
        depart_array.add("วิทยาลัยแพทยศาสตร์และการสาธารณสุข");
        depart_array.add("ศิลปศาสตร์");
        depart_array.add("บริหารศาสตร์");
        depart_array.add("นิติศาสตร์");
        depart_array.add("รัฐศาสตร์");
        depart_array.add("ศิลปประยุกต์และการออกแบบ");
        Log.d("ss","List Array Test " + depart_array.toString());

        // Adapter ตัวแรก
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (page_regiLogin.this,android.R.layout.simple_spinner_item,depart_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        departBoxNew.setAdapter(adapter);

        submitNewmember = (Button) findViewById(R.id.submit_newmember);
        submitNewmember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue requestQueue = Volley.newRequestQueue(page_regiLogin.this);
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
                            Toast.makeText(page_regiLogin.this, e.toString(), Toast.LENGTH_SHORT).show();
                            Log.d(TAG, "Catch :: " + e.toString());
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, error.toString());
                        Toast.makeText(page_regiLogin.this, error.toString(), Toast.LENGTH_SHORT).show();
                        Log.d(TAG, "onErrorResponse Catch :: " + error.toString());
                    }
                })

                {
                    @Override
                    protected Map<String, String> getParams(){  // ส่งไป api
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", nameBoxNew.getText().toString());
                        params.put("email", emailBoxNew.getText().toString());
                        params.put("pass", passBoxNew.getText().toString());
                     //   params.put("departmant", departBoxNew.toString());

                        return params;

                    }
                };
                requestQueue.add(request);


                Intent gotoMainActivity = new Intent(page_regiLogin.this, page_regi_choiceLogin.class);
                startActivity(gotoMainActivity);
                Toast.makeText(page_regiLogin.this,"บันทึกข้อมูลเรียบร้อย",Toast.LENGTH_SHORT).show();

            }

         });
}
}