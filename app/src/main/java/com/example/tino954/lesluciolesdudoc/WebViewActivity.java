package com.example.tino954.lesluciolesdudoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("http://www.lesluciolesdudoc.org/intranet");
    }
    @Override
    protected void onDestroy() {
        WebView webView = (WebView) findViewById(R.id.webView);
        if (webView != null)
            webView.destroy();
        super.onDestroy();
    }
}
