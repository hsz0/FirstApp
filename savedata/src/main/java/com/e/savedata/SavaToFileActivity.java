package com.e.savedata;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by hover on 2018/1/28.
 */

public class SavaToFileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String data = "我是将要保存到文件中的数据";
//        Log.e("mytag", "getFilesDir() : " + getFilesDir());
//        Log.e("mytag", "getCacheDir() : " + getCacheDir());

        //保存数据到内部存储
//        File savaFile = new File(getFilesDir(), "myfile");
//        File savaFile = new File(getCacheDir(), "myfile");
//        try {
//            FileOutputStream fileOutputStream = new FileOutputStream(savaFile);
//            fileOutputStream.write(data.getBytes());
//            fileOutputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Log.e("mytag", "getExternalFilesDir() : " + getExternalFilesDir(null));
        Log.e("mytag", "getExternalStoragePublicDirectory() : " + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
        //保存数据到外部存储
        File savaFile = new File(getExternalFilesDir(null), "myfile");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(savaFile);
            fileOutputStream.write(data.getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
