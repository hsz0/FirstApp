package com.hover.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by hover on 2018/3/5.
 */

public class ImageViewActivity extends AppCompatActivity {
    private ImageView imageView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview);
        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.mipmap.butterknifer);
    }
}
