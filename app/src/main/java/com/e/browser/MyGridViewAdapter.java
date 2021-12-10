package com.e.browser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyGridViewAdapter extends BaseAdapter {
    Context context;
    int logo[];
    String[] myTextLogo;
    LayoutInflater inflater;

    public MyGridViewAdapter(Context applicationContext, int [] myLogos, String[] myTextLogos) {
        this.context = applicationContext;
        this.logo = myLogos;
        this.myTextLogo = myTextLogos;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logo.length;
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.my_grid_images, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.myIcon);
        TextView textView = (TextView) view.findViewById(R.id.myTextIcon);
        imageView.setImageResource(logo[position]);
        textView.setText(myTextLogo[position]);
        return view;
    }
}
