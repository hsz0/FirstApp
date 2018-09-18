package com.hover.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.SeekBar;

/**
 * Created by hover on 2018/3/6.
 */

public class ProgressBarAcitvity extends AppCompatActivity {
    private ProgressBar progressBar;
    private SeekBar seekBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar_layout);
        progressBar = findViewById(R.id.progressbar_h);
        progressBar.setMax(100);
        //模拟从网络下载文件
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                try {
                    while (i < 100 && progressBar.getProgress() < 100) {
                        Thread.sleep(200);
                        progressBar.incrementProgressBy(2);
                        i++;
                    }
                } catch (Exception e) {

                }
            }
        }).start();

        //SeekBar
        seekBar = findViewById(R.id.seekbar);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                Log.e("mytag", "当前进度为：" + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.e("mytag", "手按住了SeekBar");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("mytag", "手离开了SeekBar");
            }
        });

    }
}
