package com.hover.firstapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Button btnLogin, btnRegist;
    private EditText etName, etPhone, etPassword;
    private CheckBox checkBox;
    private Switch mSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview);
        btnLogin = findViewById(R.id.btn_login);
        btnRegist = findViewById(R.id.btn_regist);
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etPassword = findViewById(R.id.et_password);
//        checkBox = findViewById(R.id.checkbox);
        mSwitch = findViewById(R.id.switch_view);

        btnLogin.setOnClickListener(this);
        btnRegist.setOnClickListener(this);
//        checkBox.setOnCheckedChangeListener(this);
        mSwitch.setOnCheckedChangeListener(this);
    }

//    public void login(View view) {
//        Log.e("mytag", "执行了login");
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Log.e("mytag", "点击了登录");
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();
                Log.e("mytag", "点击登录，提交数据： name =" + name + " ,phone =" + phone + " ,password =" + password);
                break;
            case R.id.btn_regist:
                Log.e("mytag", "点击了注册");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) {
            Toast.makeText(MainActivity.this, "点击选中", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "取消选中", Toast.LENGTH_SHORT).show();
        }
    }
}
