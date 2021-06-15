package com.example.akashproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.prefs.Preferences;

public class EditActivity extends AppCompatActivity {

    EditText etPname, etCname, etUname, etMobile, etComName, etGname;
    Button doneBtn;

    public static final String KEY="AKASHTECHNOLABS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        etPname=findViewById(R.id.et_name);
        etCname=findViewById(R.id.et_cname);
        etUname=findViewById(R.id.et_uname);
        etMobile=findViewById(R.id.et_mobile);
        etComName=findViewById(R.id.et_com_name);
        etGname=findViewById(R.id.et_gname);

        doneBtn=findViewById(R.id.done_btn);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences(KEY, MODE_PRIVATE);
                String name = etPname.getText().toString();
                String cname = etCname.getText().toString();
                String uname = etUname.getText().toString();
                String mobile = etMobile.getText().toString();
                String comname = etComName.getText().toString();
                String gname = etGname.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("name", name);
                editor.putString("cname", cname);
                editor.putString("uname", uname);
                editor.putString("mobile", mobile);
                editor.putString("comname", comname);
                editor.putString("gname", gname);

                editor.commit();

                Intent intent = new Intent(EditActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}