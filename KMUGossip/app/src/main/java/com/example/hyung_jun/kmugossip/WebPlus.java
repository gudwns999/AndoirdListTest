package com.example.hyung_jun.kmugossip;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.security.AccessControlContext;

/**
 * Created by Hyung-Jun on 2015-08-06.
 */
public class WebPlus extends Activity {
    private WebView webView;
    @Override
    public void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.webplus_layout);

        webView = (WebView)findViewById(R.id.webView_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://10.30.126.246/KMU/kmugossip.html");
        webView.setWebViewClient(new WishWebViewClient());
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private  class WishWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }
}
