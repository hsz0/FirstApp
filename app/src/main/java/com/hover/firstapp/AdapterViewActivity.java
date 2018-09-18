package com.hover.firstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hover on 2018/3/6.
 */

public class AdapterViewActivity extends AppCompatActivity {
    //listview + 适配器Adapter: ArrayAdapter SimpleAdapter BaseAdapter
    private ListView listView;
    private Spinner spinner;
    private ArrayAdapter arrayAdapter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapterview_layout);
//        listView = findViewById(R.id.listview);
//        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, getData());
//        listView.setAdapter(arrayAdapter);
        //自定义Adapter
//        myAdapter = new MyAdapter(AdapterViewActivity.this, getData());
//        listView.setAdapter(myAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(AdapterViewActivity.this, "当前点击了第" + (i + 1) + "列！！", Toast.LENGTH_SHORT).show();
//            }
//        });

//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(AdapterViewActivity.this, "当前长按了第" + (i + 1) + "列！！", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
        spinner = findViewById(R.id.spinner);
        arrayAdapter = ArrayAdapter.createFromResource(AdapterViewActivity.this,
                R.array.citys, android.R.layout.simple_spinner_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdapterViewActivity.this, "选择了第" + (i + 1) + "项！！", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

//    private ArrayList getData() {
//        ArrayList arrayList = new ArrayList();
//        for (int i = 0; i < 20; i++) {
//            arrayList.add("列表" + i);
//        }
//        return arrayList;
//    }

    private ArrayList<News> getData() {
        ArrayList<News> arrayList = new ArrayList<>();
        arrayList.add(new News("新闻标题1", "123", R.mipmap.picture1));
        arrayList.add(new News("新闻标题2", "25", R.mipmap.picture2));
        arrayList.add(new News("新闻标题3", "100", R.mipmap.picture3));
        arrayList.add(new News("新闻标题4", "78", R.mipmap.picture4));
        arrayList.add(new News("新闻标题5", "10", R.mipmap.picture5));
        arrayList.add(new News("新闻标题6", "156", R.mipmap.picture6));
        arrayList.add(new News("新闻标题7", "800", R.mipmap.picture7));
        arrayList.add(new News("新闻标题8", "12", R.mipmap.picture8));
        arrayList.add(new News("新闻标题9", "3", R.mipmap.picture9));
        return arrayList;
    }

    class MyAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<News> mDatas;

        public MyAdapter(Context context, ArrayList<News> datas) {
            mContext = context;
            mDatas = datas;
        }

        @Override
        public int getCount() {
            return mDatas.size();
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup viewGroup) {
            View view = null;
            ViewHolder viewHolder = null;
            if (convertview == null) {
                view = LayoutInflater.from(mContext).inflate(R.layout.news_item_layout, null);
                viewHolder = new ViewHolder();
                viewHolder.tvTitle = view.findViewById(R.id.tv_title);
                viewHolder.tvCommentNum = view.findViewById(R.id.tv_commentnum);
                viewHolder.imgNew = view.findViewById(R.id.img_news);
                view.setTag(viewHolder);
            } else {
                view = convertview;
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.tvTitle.setText(mDatas.get(i).getTitle());
            viewHolder.tvCommentNum.setText(mDatas.get(i).getCommentNum());
            viewHolder.imgNew.setImageResource(mDatas.get(i).getImgRes());
            return view;
        }
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvCommentNum;
        ImageView imgNew;
    }
}
