package com.vakitpro;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();

        // JavaScript'i aç
        settings.setJavaScriptEnabled(true);

        // HTML içindeki localStorage vb. özellikler için
        settings.setDomStorageEnabled(true);

        // Sayfaların WebView içinde açılması
        webView.setWebViewClient(new WebViewClient());

        // VakitPro HTML sayfasını aç
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
