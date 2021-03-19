package com.hztuen.androidinterview.activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
/**
 * @Description: java类作用描述
 * @Author: zhouguizhi
 * @CreateDate: 2021/3/19 下午10:29
 * @Version: 1.0
 */
public class CustomView extends View {
    private Paint paint = new Paint();
    private Handler mHandler = new Handler();
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private boolean isFirst;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        paint.setTextSize(100);
        canvas.drawText(!isFirst?"1111111":"222222",100,100,paint);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                isFirst = !isFirst;
                postInvalidate();
            }
        },5000);

    }
}
