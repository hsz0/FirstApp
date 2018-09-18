package com.hover.activitylifecycle;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_start);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显式Intent
//                Intent intent = new Intent(MainActivity.this, SecondAcitivity.class);
//                startActivity(intent);

                //隐式intent
//                Intent intent1 = new Intent();
//                intent.setAction("com.hover.lifecycle.secondAcitivity");
//                startActivity(intent1);

                final AlertDialog.Builder inputDialog =
                        new AlertDialog.Builder(MainActivity.this);
                inputDialog.setTitle("我是简单的弹框！");
                inputDialog.setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });

        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onCreate() ===");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onStart() ===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onRestart() ===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onResume() ===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onPause() ===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onStop() ===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyTag", "MainActivity 执行了生命周期函数：=== onDestroy() ===");
    }
}
