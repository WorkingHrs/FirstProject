package com.sabsolve.web2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.sabsolve.utils.CommonUtil;

public class MainActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Here checking the internet connection.\
        if(!CommonUtil.isInternetWorking(this))
        {
            Toast.makeText(this, "Unable to connect to Internet.", Toast.LENGTH_LONG);
        }

        if(webView==null) {
            webView = (WebView) findViewById(R.id.sabSolveWV);
            webView.getSettings().setJavaScriptEnabled(true);

            // Initialize the WebView
//            webView.getSettings().setSupportZoom(true);
//            webView.getSettings().setBuiltInZoomControls(true);
            webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            webView.setScrollbarFadingEnabled(true);
            webView.getSettings().setLoadsImagesAutomatically(true);

            // This next one is crazy. It's the DEFAULT location for your app's cache
            // But it didn't work for me without this line
            webView.getSettings().setAppCachePath("/data/data/" + getPackageName() + "/cache");
            webView.getSettings().setAllowFileAccess(true);
            webView.getSettings().setAppCacheEnabled(true);

            webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
            // Set cache size to 8 mb by default. should be more than enough
            webView.getSettings().setAppCacheMaxSize(1024*1024*8);

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });

            webView.setWebChromeClient(new WebChromeClient());
            webView.loadUrl("http://sabsolve.com/newtest/test");
        }

        if (savedInstanceState != null)
            ((WebView)findViewById(R.id.sabSolveWV)).restoreState(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState ){
        ((WebView) findViewById(R.id.sabSolveWV)).saveState(outState);
    }
}
