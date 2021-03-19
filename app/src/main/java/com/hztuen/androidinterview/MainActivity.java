package com.hztuen.androidinterview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;

import com.hztuen.androidinterview.activity.OneActivity;
import com.hztuen.androidinterview.adapter.MainAdapter;
import com.hztuen.androidinterview.handler.HandlerActivity;
import com.hztuen.androidinterview.jdk7Objects.Jdk7ObjectsActivity;
import com.hztuen.androidinterview.reflect.ReflectTestActivity;

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
        list.add("jdk7 Objects类");
        list.add("求泛型中最小值问题");
        list.add("java中的反射");
        list.add("什么情况下Activity不走onDestory?");
    }

    @Override
    public void onItemClickListener(int position) {
        switch (position){
            case 0:
                startActivity(new Intent(this, HandlerActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, Jdk7ObjectsActivity.class));
                break;
            case 2:
                startActivity(new Intent(this, RequestMinValueActivity.class));
                break;
            case 3:
                startActivity(new Intent(this, ReflectTestActivity.class));
                break;
            case 4:
                startActivity(new Intent(this, OneActivity.class));
                break;
        }
    }
}
