package com.hover.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        myHandler = new MyHandler();

        findViewById(R.id.btn_sendMsg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //模拟后台网络下载数据。。
//                        String data = "我是下载好的数据";
//                        Bundle bundle = new Bundle();
//                        bundle.putString("data", data);
//                        Message msg = myHandler.obtainMessage();
//                        msg.obj = data;
//                        msg.what = 0;
//                        msg.setData(bundle);
//                        myHandler.sendMessage(msg);

//                        myHandler.sendEmptyMessage(1);
//                        myHandler.sendEmptyMessageDelayed(2,3000);

                        myHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                tv.setText("通过post方式更新UI");
                            }
                        });

                    }
                }).start();
            }
        });
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    Log.e("mytag", "handleMessage接收消息: " + msg.obj);
//                    tv.setText((String) msg.obj);
                    tv.setText(msg.getData().getString("data"));
                    break;
                case 1:
                    Log.e("mytag", "接收到一个空消息");
                    break;
            }

        }
    }
}
