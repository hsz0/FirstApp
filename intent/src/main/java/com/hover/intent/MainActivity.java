package com.hover.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            //动态申请权限(API>=23)
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

        //应用内部组件之间的通信交互
//        Intent in = new Intent(MainActivity.this, SecondActivity.class);
//        in.putExtra("name", "Jack Ma");
//        in.putExtra("age", 50);
//        startActivity(in);

        //应用与应用之间使用Intent实现通信交互
        findViewById(R.id.btn_startapp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
//                        == PackageManager.PERMISSION_GRANTED) {
//                    Uri uri = Uri.parse("tel:18371458585");
//                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(MainActivity.this, "还没有获得CALL_PHONE权限", Toast.LENGTH_SHORT).show();
//                }

//                Uri uri = Uri.parse("http://www.baidu.com");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);

                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(in, 100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2 && requestCode == 100) {
            String name = data.getStringExtra("name");
            Log.e("mytag","SecondActivity传回来的值name :" +name);
        }
    }
}
