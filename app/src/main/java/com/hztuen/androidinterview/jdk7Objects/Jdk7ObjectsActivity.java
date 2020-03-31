package com.hztuen.androidinterview.jdk7Objects;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import com.hztuen.androidinterview.R;
import com.hztuen.androidinterview.util.LoggUtil;
import java.util.Objects;

public class Jdk7ObjectsActivity extends AppCompatActivity {
    private AppCompatTextView tvDesc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jdk8objects);
        tvDesc =  findViewById(R.id.activity_jdk8objects_tv_desc);
        tvDesc.setText("Objects在jdk7开始出现,主要是解决Java中以前一些比如equals判断的问题,怕出现空指针异常情况,可以把它看作是一个工作类," +
                "主要有equals(),toString(),hash(),requireNonNull");
        LoggUtil.e("比较结果:"+Objects.equals(null,"zhouguizhi"));
        LoggUtil.e("比较结果:"+Objects.equals(110,"zhouguizhi"));
        LoggUtil.e("比较结果:"+Objects.equals("zhouguizhi","zhouguizhi"));

        LoggUtil.e("toString结果:"+Objects.toString("zhouguizhi"));
        //这是当对象为null的情况下默认是就返回第二个参数 可以从源码去看下 还是比较简单的
        LoggUtil.e("toString结果结果:"+Objects.toString(null,"zhouguizhi"));

        //requireNonNull这个方法好是判断对象是否为空 他的重载的方法的是当对象为空,抛出什么样的异常 message
       LoggUtil.e("结果:"+Objects.requireNonNull(tvDesc));

    }
}
