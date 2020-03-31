package com.hztuen.androidinterview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import com.hztuen.androidinterview.adapter.MainAdapter;
import com.hztuen.androidinterview.handler.HandlerActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {
    private List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        RecyclerView recyclerView =  findViewById(R.id.activity_main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter mainAdapter = new  MainAdapter(this,list);
        recyclerView.setAdapter(mainAdapter);
        mainAdapter.setOnItemClickListener(this);
    }

    private void initData() {
        list.add("handler面试问题");
    }

    @Override
    public void onItemClickListener(int position) {
        startActivity(new Intent(this, HandlerActivity.class));
    }
}
