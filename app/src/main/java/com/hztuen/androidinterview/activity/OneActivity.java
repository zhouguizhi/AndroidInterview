package com.hztuen.androidinterview.activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.hztuen.androidinterview.R;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/3/17 上午12:00
 * @Version: 1.0
 */
public class OneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
    }

    public void startTranActivity(View view) {
        view.postInvalidate();
        startActivity(new Intent(this,TranActivity.class));
    }
}
