package com.example.administrator.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<image> img = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        arrList();
        imageAdapter adapter = new imageAdapter(img);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
    private void arrList(){
        image a1 = new image("第一图",R.drawable.a1);
        img.add(a1);
        image a2 = new image("2图",R.drawable.a2);
        img.add(a2);
        img.add(new image("是谁呢",R.drawable.a3));
        img.add(new image("buzhidaoshinage",R.drawable.a4));
        img.add(new image("5张够不够",R.drawable.a5));
        img.add(new image("6张应该够了吧",R.drawable.a6));
        img.add(new image("就这么多了",R.drawable.a7));
    }
}
