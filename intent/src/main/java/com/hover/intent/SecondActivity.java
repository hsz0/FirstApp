package com.hover.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by hover on 2018/1/30.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        int age = intent.getIntExtra("age", 0);
//        Log.e("mytag", "intent传递过来的参数 name :" + name + " , age :" + age);

        Intent intent = new Intent();
        intent.putExtra("name", "Jack Chen");
        setResult(2, intent);
    }
}
