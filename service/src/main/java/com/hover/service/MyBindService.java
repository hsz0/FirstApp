package com.hover.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by hover on 2018/3/2.
 */

public class MyBindService extends Service {
    private Thread mThread;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("mytag", "MyBindService : 执行了onCreate()!!");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("mytag", "MyBindService : 执行了onBind()!!");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("mytag", "MyBindService : 执行了onUnbind()!!");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("mytag", "MyBindService : 执行了onDestroy()!!");
        mThread.interrupt();
    }

    class MyBinder extends Binder {
        public void downloadData() {
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
        }
    }
}
