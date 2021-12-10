package com.e.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MakaWhy extends AppCompatActivity {
    GridView mySecondGridview;

    int myImages [] = {R.drawable.wallpapperandroid1,
            R.drawable.wallpapperandroid2,
            R.drawable.wallpapperandroid3,
            R.drawable.wallpapperandroid4,
            R.drawable.wallpapperandroid5,
            R.drawable.wallpapperandroid6,
            R.drawable.wallpapperandroid7,
            R.drawable.wallpapperandroid8,
            R.drawable.wallpapperandroid9,
            R.drawable.wallpapperandroid10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maka_why);

        mySecondGridview = (GridView) findViewById(R.id.second_gridvieww);

        final MyThemeGridviewAdapter mySecondGridViewAdapter = new MyThemeGridviewAdapter(getApplicationContext(), myImages);
        mySecondGridview.setAdapter(mySecondGridViewAdapter);
        mySecondGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MakaWhy.this, MainActivity.class);
                myIntent.putExtra("image", myImages[position]);
                startActivity(myIntent);
            }
        });

    }
}
