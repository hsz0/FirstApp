package com.hover.activitylifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by hover on 2018/1/24.
 */

public class SecondAcitivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onCreate() ===");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onStart() ===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onRestart() ===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onResume() ===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onPause() ===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onStop() ===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyTag", "SecondAcitivity 执行了生命周期函数：=== onDestroy() ===");
    }
}
