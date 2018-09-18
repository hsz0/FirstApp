package com.hover.firstapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by hover on 2018/3/6.
 */

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnOne, btnTwo, btnThree, btnFour;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog_layout);
        btnOne = findViewById(R.id.btn_one);
        btnTwo = findViewById(R.id.btn_two);
        btnThree = findViewById(R.id.btn_three);
        btnFour = findViewById(R.id.btn_four);
        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("对话框标题");
                builder.setMessage("是否进入下一关？");
                builder.setCancelable(false);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "进入下一关", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "取消进入下一关", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
                break;
            case R.id.btn_two:
                ProgressDialog progressDialog = ProgressDialog.show(AlertDialogActivity.this,
                        "提示", "正在下载...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();
                break;
            case R.id.btn_three:
                DatePickerDialog datePickerDialog = new DatePickerDialog(AlertDialogActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(AlertDialogActivity.this, "选择了" + i + "年" + (i1 + 1) + "月" + i2 + "日",
                                Toast.LENGTH_SHORT).show();
                    }
                }, 0, 0, 0);
                datePickerDialog.show();
                break;
            case R.id.btn_four:
                TimePickerDialog timePickerDialog = new TimePickerDialog(AlertDialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(AlertDialogActivity.this, "选择了" + i + "小时" + i1 + "分",
                                Toast.LENGTH_SHORT).show();
                    }
                }, 0, 0, false);
                timePickerDialog.show();
                break;
        }
    }
}
