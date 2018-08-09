package com.lgs.simplequickadapter;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ;
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TestAdapter testAdapter = new TestAdapter(R.layout.item_test, initList());
        recyclerView.setAdapter(testAdapter);


        testAdapter.setOnItemClickListener(new SimpleQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SimpleQuickAdapter adapter, View itemView, Object b, int position) {
                Toast.makeText(MainActivity.this, b.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private ArrayList<String> initList() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("测试数据" + i);
        }
        return list;
    }
}