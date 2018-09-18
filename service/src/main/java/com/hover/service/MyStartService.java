package com.hover.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by hover on 2018/3/2.
 */

public class MyStartService extends Service {
    private Thread mThread;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("mytag", "MyStartService : 执行了onCreate()!!");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("mytag", "MyStartService : 执行了onStartCommand()!!");
        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Thread.sleep(2000);
                        Log.e("mytag", "正在下载数据中。。。");
                    }
                } catch (Exception e) {

                }
            }
        });
        mThread.start();
        return super.onStartCommand(intent, flags, startId);
//        return START_STICKY;//
//        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("mytag", "MyStartService : 执行了onDestroy()!!");
        mThread.interrupt();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
