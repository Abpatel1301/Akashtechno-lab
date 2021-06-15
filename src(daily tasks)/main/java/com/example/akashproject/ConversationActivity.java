package com.example.akashproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ConversationActivity extends AppCompatActivity {

    private EditText etphone, etSMSto, etSMSmsg, etEmail, etEmailsubject, etEmailcont;
    private ImageView ic_call, ic_send;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        etphone=findViewById(R.id.et_phone);

        etSMSto=findViewById(R.id.et_sms_to);
        etSMSmsg=findViewById(R.id.et_sms_msg);

        etEmail=findViewById(R.id.et_email);
        etEmailsubject=findViewById(R.id.et_email_sub);
        etEmailcont=findViewById(R.id.et_email_cont);

        ic_call=findViewById(R.id.ic_call);
        ic_send=findViewById(R.id.send_btn);

        btn=findViewById(R.id.btn);

        ic_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = etphone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (ActivityCompat.checkSelfPermission(ConversationActivity.this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED)  {
                    return;
                }
                startActivity(intent);
            }
        });

        ic_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String no = etSMSto.getText().toString();
                String msg = etSMSmsg.getText().toString();

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage("8160207090", null, "msg", null, null);
                Toast.makeText(getApplicationContext(), "Message Sent Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to = etEmail.getText().toString();
                String sub = etEmailsubject.getText().toString();
                String cont = etEmailcont.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                intent.putExtra(Intent.EXTRA_TEXT, cont);

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Send Email :"));
            }
        });
    }
}