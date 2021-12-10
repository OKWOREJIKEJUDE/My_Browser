package com.e.browser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyThemeGridviewAdapter extends BaseAdapter {
    Context context;
    int myImage[];
    LayoutInflater inflater;

    public MyThemeGridviewAdapter(Context context, int [] myImage) {
        this.context = context;
        this.myImage = myImage;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return myImage.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.my_theme_gridview_adapter, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.mySecondIcon);
        imageView.setImageResource(myImage[position]);
        return view;
    }
}
