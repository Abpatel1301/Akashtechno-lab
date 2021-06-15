package com.example.akashproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvName, tvCname, tvUname, tvMobile, tvComName, tvGname;
    Button editBtn;

    public static final String KEY="AKASHTECHNOLABS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        SharedPreferences preferences = getSharedPreferences(KEY, MODE_PRIVATE);

        tvName=findViewById(R.id.tv_name);
        tvCname=findViewById(R.id.tv_cname);
        tvUname=findViewById(R.id.tv_uname);
        tvMobile=findViewById(R.id.tv_mobile);
        tvComName=findViewById(R.id.tv_com_name);
        tvGname=findViewById(R.id.tv_gname);

        editBtn=findViewById(R.id.edit_btn);

        String name = preferences.getString("name", "-----");
        String cname = preferences.getString("cname", "-----");
        String uname = preferences.getString("uname", "-----");
        String mobile = preferences.getString("mobile", "-----");
        String comname = preferences.getString("comname", "-----");
        String gname = preferences.getString("gname", "-----");

        tvName.setText(name);
        tvCname.setText(cname);
        tvUname.setText(uname);
        tvMobile.setText(mobile);
        tvComName.setText(comname);
        tvGname.setText(gname);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DetailsActivity.this, EditActivity.class);
                startActivity(intent);

            }
        });
    }
}