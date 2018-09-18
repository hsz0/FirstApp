package com.e.savedata;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hover on 2018/1/30.
 */

public class TestActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        if (ActivityCompat.checkSelfPermission(TestActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(TestActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }

        findViewById(R.id.btn_intent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ActivityCompat.checkSelfPermission(TestActivity.this, Manifest.permission.CALL_PHONE)
                        == PackageManager.PERMISSION_GRANTED) {
                    Uri uri = Uri.parse("tel:123456");
                    Intent intent = new Intent(Intent.ACTION_CALL, uri);
                    startActivity(intent);
                } else {
                    Toast.makeText(TestActivity.this, "还没有获得CALL_PHONE权限", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if (ActivityCompat.checkSelfPermission(TestActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(TestActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }
    }
}
