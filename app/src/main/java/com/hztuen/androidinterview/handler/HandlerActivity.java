package com.hztuen.androidinterview.handler;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.hztuen.androidinterview.MainActivity;
import com.hztuen.androidinterview.R;
import com.hztuen.androidinterview.util.LoggUtil;

public class HandlerActivity extends AppCompatActivity {
    private AppCompatTextView handler_tv1;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==100){
                startActivity(new Intent(HandlerActivity.this, MainActivity.class));
            }
        }
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadler);
        handler_tv1 = findViewById(R.id.handler_tv1);
        handler_tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSend();
            }
        });
    }
    public void startSend(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 100;
                //在这如果Activity被销毁了线程还是在后台跑会容易造成内存泄露
//                SystemClock.sleep(4000);
//                if(!isFinishing()){//解决内存泄露
//                    handler.sendMessage(msg);
//                }
                //第二种
                handler.sendEmptyMessageDelayed(100,4000);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LoggUtil.e("handler activity  onDestory");
        //第二种方案的解决方法
        handler.removeMessages(100);
    }
}
