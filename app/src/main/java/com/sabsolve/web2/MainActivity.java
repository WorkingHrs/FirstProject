package com.sabsolve.web2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(webView==null) {
            webView = (WebView) findViewById(R.id.webView1);
            webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://sabsolve.com/newtest/test");
//        webView.loadUrl("file:///android-assets/html5up-lens/index.html");
            webView.loadUrl("http://www.tutorialspoint.com/drupal/index.htm");


            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });

        }

        if (savedInstanceState != null)
            ((WebView)findViewById(R.id.webView1)).restoreState(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState ){
        ((WebView) findViewById(R.id.webView1)).saveState(outState);
    }
}
