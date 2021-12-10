package com.e.browser;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.net.URL;

public class My_Dialogue extends AppCompatDialogFragment {
    private RadioButton google;
    private  RadioButton bing;
    private  RadioButton duckduckgo;
    private  RadioButton baidu;
    private  RadioButton yahoo;
    private  RadioButton startPage;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.my_dialogue, null);
        builder.setView(view);
        builder.setTitle("Search engine");
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               switch (view.getId()){
                   case R.id.google:
                       String input1 = "https://www.google.com/search?q=";
                       Intent intent = new Intent(getActivity(), WebviewActivity.class);
                       intent.putExtra("searchItnow", input1);
                       MainActivity mainActivity = new MainActivity();
                       mainActivity.myFirstImageview.setImageResource(R.drawable.facebooklogo3);
                       break;
                   case R.id.bing:
                       String input2 = "https://www.bing.com/search?q=";
                       //builder.setIcon(R.drawable.livescorelogo2);
                       Intent intent11 = new Intent(getActivity(), WebviewActivity.class);
                       intent11.putExtra("searchItnow", input2);
                       MainActivity mainActivity1 = new MainActivity();
                       mainActivity1.myFirstImageview.setImageResource(R.drawable.facebooklogo3);
                       break;
                   case R.id.baidu:
                       String input3 = "https://www.baidu.com/search?q=";
                       builder.setIcon(R.drawable.linkedin2);
                       break;
               }
            }
        });

        google = view.findViewById(R.id.google);
        bing = view.findViewById(R.id.bing);
        duckduckgo = view.findViewById(R.id.duckduckgo);
        yahoo = view.findViewById(R.id.yahoo);
        baidu = view.findViewById(R.id.baidu);
        startPage = view.findViewById(R.id.startpage);

       return builder.create();
    }

    public interface  myExampleDialogueListener {
        void  applyUrls(String google,String bing,String baidu);
    }
}

