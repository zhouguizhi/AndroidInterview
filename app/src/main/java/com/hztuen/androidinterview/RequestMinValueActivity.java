package com.hztuen.androidinterview;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RequestMinValueActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_min_value);
        test();
    }

    private void test() {
        int value = min(new Integer[]{1,2,3});
        Log.e("zhouguizhi","value--->"+value);
    }
    //注意：Number并没有实现Comparable
    private static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null || values.length == 0){
            return null;
        }
        T min = values[0];
        for (int i = 1; i < values.length; i++) {
            if (min.compareTo(values[i]) > 0){
                min = values[i];
            }
        }
        return min;
    }
}
