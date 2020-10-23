package com.example.myblog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        webView.clearCache(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode( WebSettings.LOAD_NO_CACHE );
        webSettings.setAppCacheEnabled( false );

        webSettings.setJavaScriptEnabled(true);

        webView.loadUrl("https://ess328.synology.me/");
        webView.setWebViewClient(new WebViewClient());
    }

    //폰의 뒤로가기 버튼의 동작 입력
    @Override
    public void onBackPressed(){
        if(webView.canGoBack()){
            webView.canGoBack();
        }else{
            super.onBackPressed();
        }
    }
}
