package com.e.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class WebviewActivity extends AppCompatActivity {
    TextView myTextView;
    ProgressBar myProgressbar;
    WebView myWebview;
    ImageView mySecondWebviewImageview;
    public static boolean myweb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        mySecondWebviewImageview = (ImageView) findViewById(R.id.mySecondWebviewImageview);
        myTextView = (TextView) findViewById(R.id.myTextview);
        myProgressbar = (ProgressBar) findViewById(R.id.myProgressBar);
        myProgressbar.setMax(50);
        myWebview = (WebView) findViewById(R.id.myWebView);
        myWebview.getSettings().setBuiltInZoomControls(true);
        myWebview.getSettings().setDisplayZoomControls(false);
        myWebview.getSettings().setJavaScriptEnabled(true);

        if (!myweb) {
            String webUrl = getIntent().getExtras().getString("searchIt");
            myWebview.loadUrl("https://www.google.com/search?q=" + webUrl);
        }
        else {
            String webur = getIntent().getExtras().getString("url");
            myWebview.loadUrl(webur);
        }



        myWebview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                myProgressbar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                myProgressbar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });

        myWebview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                myProgressbar.setProgress(newProgress);
            }
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                myTextView.setText(title);
            }
            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });

        myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent textIntent = new Intent(WebviewActivity.this, SearchActivity.class);
                startActivity(textIntent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        myTextView.requestFocus();
        InputMethodManager IMM = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        IMM.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);


        mySecondWebviewImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.mySecondWebviewImageview:
                        myWebview.reload();
                        mySecondWebviewImageview.setBackgroundResource(R.drawable.ic_close_black_24dp);
                        mySecondWebviewImageview.setMaxWidth(45);
                        break;
                    case R.drawable.ic_close_black_24dp:
                        myWebview.stopLoading();
                        mySecondWebviewImageview.setBackgroundResource(R.drawable.ic_refresh_black_24dp);
                        break;
                }
            }
        });
    }
    public static void webOpening(){

    }

    @Override
    public void onBackPressed() {
        if (myWebview.canGoBack()) {
            myWebview.goBack();
        } else {
             finish();
        }
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
