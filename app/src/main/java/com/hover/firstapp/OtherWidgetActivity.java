package com.hover.firstapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.NumberPicker;
import android.widget.Toast;

/**
 * Created by hover on 2018/3/7.
 */

public class OtherWidgetActivity extends AppCompatActivity {
    private CalendarView calendarView;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otherwidget_layout);
        calendarView = findViewById(R.id.calendarview);
        numberPicker = findViewById(R.id.numberpicker);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(OtherWidgetActivity.this, "年" + i + "月" + (i1 + 1) + "日" + i2, Toast.LENGTH_SHORT).show();
            }
        });

        numberPicker.setMaxValue(100);
        numberPicker.setMinValue(1);
        numberPicker.setValue(1);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int olderVal, int newVal) {
                Toast.makeText(OtherWidgetActivity.this, "olderVal =" + olderVal + "， newVal" + newVal, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
