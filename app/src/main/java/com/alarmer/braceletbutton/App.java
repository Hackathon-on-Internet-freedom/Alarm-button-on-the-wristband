package com.alarmer.braceletbutton;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        mContext = getApplicationContext();
    }
}
