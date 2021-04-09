package com.hztuen.androidinterview.activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.hztuen.androidinterview.R;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/3/17 上午12:01
 * @Version: 1.0
 */
public class TranActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tran);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("zhou","onDestroy..");
    }

    public void test(View view) {
        ComponentName componentName = new ComponentName(this,OneActivity.class);
        Intent.makeRestartActivityTask(componentName);
    }
}
