package com.hover.broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    //注册广播：静态注册和动态注册

    private MyBroadcastReceiver myBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送广播
                Intent intent = new Intent();
                intent.setAction("com.hover.myreciever");
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //动态注册广播
        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.hover.myreciever");
        registerReceiver(myBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //动态注销广播
        unregisterReceiver(myBroadcastReceiver);
    }
}
