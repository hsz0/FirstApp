package com.e.savedata;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tv = findViewById(R.id.tv);

        //key-value 键值对
//        SharedPreferences sharedPreferences = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putInt("age", 30);
//        editor.putString("name", "Tom");
//        editor.putBoolean("isBoy", true);
//        editor.commit();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("age", 25);
        editor.putString("name", "lucy");
        editor.putBoolean("isBoy", false);
        editor.commit();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SharedPreferences sharedPreferences1 = getSharedPreferences("my_preferences", Context.MODE_PRIVATE);
                SharedPreferences sharedPreferences1 = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                int age = sharedPreferences1.getInt("age", 0);
                String name = sharedPreferences1.getString("name", "");
                boolean isBoy = sharedPreferences1.getBoolean("isBoy", false);

                Log.e("mytag", "age = " + age + " ,name = " + name + " ,isBoy =" + isBoy);
                tv.setText("age = " + age + " ,name = " + name + " ,isBoy =" + isBoy);
            }
        });
    }
}
