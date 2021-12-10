package com.e.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class MainActivity extends AppCompatActivity {
    LinearLayout myDismissLayout, myShareLayout, myFullscreenLayout;
    ImageView menuDismiss, myTheme, mySettings;
    BottomNavigationItemView myMenu,myOutline;
    BottomNavigationView bottomNa;
    GridView myGridView;
    ImageView myFirstImageview;
    RelativeLayout myFirstLayout;
    RelativeLayout mySecondLayout;
    ImageView myThirdImageview;
    static final int Check  = 1111;
    int mylogos [] = {R.drawable.youtubelogo3,R.drawable.awslogo1, R.drawable.facebooklogo3,R.drawable.twitterlogo3,
            R.drawable.instagram3, R.drawable.gmaillogo2, R.drawable.googleslogo1,R.drawable.linkedin2,R.drawable.xclublogo1,
            R.drawable.figmalogo3, R.drawable.androidlogo1, R.drawable.betkinglogo1, R.drawable.wikipedia2};
    String myTextLogos [] = {"Youtube","Amazon","Facebook","Twitter","Instagram","Gmail",
            "Google","LinkedIn","Infinix Xclub","Figma","Android Developers","BetKing","Wikipedia",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myGridView = (GridView) findViewById(R.id.gridvieww);
        myFirstImageview = (ImageView) findViewById(R.id.myFirstImageview);
        myFirstLayout = (RelativeLayout) findViewById(R.id.myfirstLayout);
        mySecondLayout = (RelativeLayout) findViewById(R.id.mySecondLayout);
        myThirdImageview = (ImageView) findViewById(R.id.myThirdImageview);
        myMenu = (BottomNavigationItemView) findViewById(R.id.bottomShow);
        myOutline = (BottomNavigationItemView) findViewById(R.id.Outline);
        bottomNa = (BottomNavigationView) findViewById(R.id.bottomNavigation);
        menuDismiss = (ImageView) findViewById(R.id.menuDismiss);
        myTheme = (ImageView) findViewById(R.id.myTheme);
        mySettings = (ImageView) findViewById(R.id.settings);
        myDismissLayout = (LinearLayout) findViewById(R.id.myDismissLayout);
        myShareLayout = (LinearLayout) findViewById(R.id.myShareLayout);
        myFullscreenLayout = (LinearLayout) findViewById(R.id.myFullscreenLayout);

        myMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_layout, (LinearLayout)findViewById(R.id.bottomSheetContainer));
 ////////////////// the code below (setOnClickListener) was used to remove the BottomSheet ///////////////////////////
                bottomSheetView.findViewById(R.id.myDismissLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.myTheme).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent myIntent = new Intent(getApplicationContext(), MakaWhy.class);
                        startActivity(myIntent);
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.settings).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mysecondIntent = new Intent(getApplicationContext(), SettingsActivity.class);
                        startActivity(mysecondIntent);
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.myShareLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("Text/plain");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, "https://www.playstore.com");  //// THE WEBSITE ADDRESS YOU WANT TO SHARE ////
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "This app is great, recomended to have a try");  /// THE TITLE OF THE WEBSITE YOU SHARED ////
                        //shareIntent.putExtra(Intent.ACTION_ALL_APPS, "My Apps");
                        startActivity(Intent.createChooser(shareIntent,  "Share"));
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetView.findViewById(R.id.myFullscreenLayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myBottomNavClose();
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });


        MyGridViewAdapter myGridViewAdapter = new MyGridViewAdapter(getApplicationContext(), mylogos, myTextLogos);
        myGridView.setAdapter(myGridViewAdapter);
        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String url;
                switch (position){
                    case 0:
                        url = "https://www.youtube.com";
                        break;
                    case 1:
                        url = "https://www.amazon.com";
                        break;
                    case 2:
                        url = "https://www.facebook.com";
                        break;
                    case 3:
                        url = "https://www.twitter.com";
                        break;
                    case 4:
                        url = "https://www.instagram.com";
                        break;
                    case 5:
                        url = "https://www.gmail.com";
                        break;
                    case 6:
                        url = "https://www.google.com";
                        break;
                    case 7:
                        url = "https://www.linkedin.com";
                        break;
                    case 8:
                        url = "https://wap.infinix.club";
                        break;
                    case 9:
                        url = "https://www.figma.com";
                        break;
                    case 10:
                        url = "https://developer.android.com";
                        break;
                    case 11:
                        url = "https://www.betking.com";
                        break;
                   default: url = "https://www.wikipedia.com";
                }
                WebviewActivity.webOpening();
                WebviewActivity.myweb = true;
                InputMethodManager IMM1 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                IMM1.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
                intent.putExtra("url", url);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


            }
        });

        myThirdImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String searchingIt = myThirdImageview.toString();
                Intent I = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                I.putExtra(searchingIt, "comeIn");
                I.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                I.putExtra(RecognizerIntent.EXTRA_PROMPT, "Starting Speech");
                startActivityForResult(I,Check);
            }
        });

        mySecondLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(intent1);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        myFirstImageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogueHereFoeMe();
            }
        });

    }

    public void myBottomNavClose(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNa.setVisibility(View.INVISIBLE);
        Toast.makeText(this, "Turn Off Full Screen Mode", Toast.LENGTH_SHORT).show();
    }

    public void openDialogueHereFoeMe() {
        My_Dialogue my_dialogue = new My_Dialogue();
        my_dialogue.show(getSupportFragmentManager(), "ExampleDialogue");
    }
}
