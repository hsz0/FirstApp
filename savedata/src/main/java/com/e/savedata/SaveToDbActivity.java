package com.e.savedata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

/**
 * Created by hover on 2018/1/28.
 */

public class SaveToDbActivity extends AppCompatActivity {
    private String sql;
    private static final String TABLE_NAME = "mytable";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sava_to_db_layout);
        //sqlite  SQLiteOperHelper
        sql = "create table " + TABLE_NAME + " (_id integer primary key, name text not null, age integer)";
        MySqliteOpenhelper mySqliteOpenhelper = new MySqliteOpenhelper(this);
        final SQLiteDatabase sqLiteDatabase = mySqliteOpenhelper.getWritableDatabase();
        //添加数据
        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("name", "Mars");
                contentValues.put("age", 35);
                long newRow = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
            }
        });
        //查询数据
        findViewById(R.id.btn_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = sqLiteDatabase.query(TABLE_NAME, null, null, null, null, null, null);
                while (cursor.moveToNext()) {
                    int id = cursor.getInt(0);
                    String name = cursor.getString(1);
                    int age = cursor.getInt(2);
                    Log.e("mytag", "id = " + id + " ,name =" + name + " ,age =" + age);
                }
            }
        });
        //删除数据
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] args = {String.valueOf(1)};
                sqLiteDatabase.delete(TABLE_NAME, "_id=?", args);
            }
        });
    }

    class MySqliteOpenhelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "hover.db";
        private static final int DB_VERSION = 1;

        public MySqliteOpenhelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}
