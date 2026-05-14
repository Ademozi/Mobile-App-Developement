package com.tp4.translation;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        // Browser inside app.
        WebView myWebView = findViewById(R.id.WebView);

        // Without this, links open in Chrome.
        //With this, pages stay inside your app.
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl(
                "https://en.wikipedia.org/wiki/Larbi_Ben_M%27hidi"
        );
    }
}