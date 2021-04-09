package com.hztuen.androidinterview.activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    private Button btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        btn = findViewById(R.id.btn);
        Log.e("zhou","111:="+btn.getWidth());
    }

    public void startTranActivity(View view) {
        view.postInvalidate();
        startActivity(new Intent(this,TranActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("zhou","222222:="+btn.getWidth());
    }
}
