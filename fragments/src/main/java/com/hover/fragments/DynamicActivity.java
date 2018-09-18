package com.hover.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by hover on 2018/1/26.
 */

public class DynamicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_layout);
        FrameLayout frameLayout = findViewById(R.id.fragment_container);
        //初始添加一个Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();//事务
        fragmentTransaction.add(R.id.fragment_container, new MyFragment());
        fragmentTransaction.commit();//提交事务

        Button btn1 = findViewById(R.id.btn_one);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction1.replace(R.id.fragment_container, new MyFragment());
                fragmentTransaction1.addToBackStack(null);//将fragment添加到回退栈
                fragmentTransaction1.commit();
            }
        });

        Button btn2 = findViewById(R.id.btn_two);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                fragmentTransaction2.replace(R.id.fragment_container, new SecondFragment());
                fragmentTransaction2.addToBackStack(null);//将fragment添加到回退栈
                fragmentTransaction2.commit();
            }
        });
    }
}
