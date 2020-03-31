package com.hztuen.androidinterview;
import android.app.Application;
import leakcanary.LeakCanary;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.Config config = LeakCanary.getConfig().newBuilder()
                .retainedVisibleThreshold(3)
                .computeRetainedHeapSize(false)
                .build();
        LeakCanary.setConfig(config);
    }
}
