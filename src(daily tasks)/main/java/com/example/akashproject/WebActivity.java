package com.example.akashproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;

public class WebActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView ic_search;
    private EditText search_text;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        search_text=findViewById(R.id.search_text);
        ic_search=findViewById(R.id.ic_search);
        webView=findViewById(R.id.webview);

        ic_search.setOnClickListener(this);
    }

    //@SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search_icon) {
            String url = search_text.getText().toString();
            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebViewClient(new MyWebviewClient());
            webView.loadUrl(url);
        }
    }

    private class MyWebviewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            //return super.shouldOverrideUrlLoading(view, url);
            view.loadUrl(url);
            return true;
        }
    }
}