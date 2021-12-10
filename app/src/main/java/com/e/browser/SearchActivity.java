package com.e.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {
    ImageView myFirstImageview2;
    EditText mySearchEditText;
    TextView myEnterText;
    ImageView myThirdImageview2;
    static final int Checking  = 2222;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.argb(255, 233, 233, 233));
        }
        setContentView(R.layout.activity_search);

        myFirstImageview2 = (ImageView) findViewById(R.id.myFirstImageview2);
        myThirdImageview2 =  (ImageView) findViewById(R.id.myThirdImageview2);
        mySearchEditText = (EditText) findViewById(R.id.mySearchEditText);
        myEnterText = (TextView) findViewById(R.id.myEnterText);

        mySearchEditText.requestFocus();
        InputMethodManager IMM = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        IMM.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

        mySearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    WebviewActivity.webOpening();
                    WebviewActivity.myweb = false;
                    final String searching = mySearchEditText.getText().toString();
                        Intent int1 = new Intent(SearchActivity.this, WebviewActivity.class);
                        int1.putExtra("searchIt", searching);
                        startActivity(int1);
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                        finish();
                        return true;
                }
                return false;
            }
        });
        myEnterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebviewActivity.webOpening();
                WebviewActivity.myweb = false;
                    final String searching = mySearchEditText.getText().toString();
                    Intent int1 = new Intent(SearchActivity.this, WebviewActivity.class);
                    int1.putExtra("searchIt", searching);
                    startActivity(int1);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
            }
        });
        myThirdImageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchingIt = myThirdImageview2.toString();
                Intent I = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                I.putExtra(searchingIt, "comeIn");
                I.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                I.putExtra(RecognizerIntent.EXTRA_PROMPT, "Starting Speech");
                startActivityForResult(I,Checking);
                InputMethodManager IMM1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                IMM1.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();
    }
}
