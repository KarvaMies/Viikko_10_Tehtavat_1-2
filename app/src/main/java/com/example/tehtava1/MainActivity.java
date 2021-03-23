package com.example.tehtava1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    WebView web;

    TextInputEditText inputWebsite;
    String start, sWebsite, currentWebsite;

    Button search, refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = "http://www.google.fi";
        currentWebsite = start;
        web = findViewById(R.id.webView);
        web.loadUrl(start);

        inputWebsite = findViewById(R.id.inputWebsite);
        inputWebsite.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().startsWith("http://")) {
                    sWebsite = s.toString();
                } else {
                    sWebsite = "http://" + s.toString();
                }
            }
        });

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(sWebsite);

        search = findViewById(R.id.search);

    }

    public void Search(View v) {
        web.loadUrl(sWebsite);
        currentWebsite = sWebsite;
    }

    public void Refresh(View v) {
        web.loadUrl(currentWebsite);
    }
}