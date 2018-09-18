package com.hover.service;


import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("mytag","MainActivity :执行了onServiceConnected()");
            MyBindService.MyBinder myBinder = (MyBindService.MyBinder) iBinder;
            myBinder.downloadData();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("mytag","MainActivity :执行了onServiceDisconnected()");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_startservice).setOnClickListener(this);
        findViewById(R.id.btn_stopservice).setOnClickListener(this);
        findViewById(R.id.btn_bindservice).setOnClickListener(this);
        findViewById(R.id.btn_unbindservice).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent startIntent = new Intent(MainActivity.this, MyStartService.class);
        Intent bindIntent = new Intent(MainActivity.this, MyBindService.class);
        switch (view.getId()) {
            //启动服务
            case R.id.btn_startservice:
                startService(startIntent);
                break;
            //停止服务
            case R.id.btn_stopservice:
                stopService(startIntent);
                break;
            //绑定服务
            case R.id.btn_bindservice:
                bindService(bindIntent, serviceConnection, BIND_AUTO_CREATE);
                break;
            //解绑服务
            case R.id.btn_unbindservice:
                unbindService(serviceConnection);
                break;
        }
    }
}
