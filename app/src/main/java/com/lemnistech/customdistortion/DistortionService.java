package com.lemnistech.customdistortion;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;

public class DistortionService extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Handler().postDelayed(() -> {

            ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

            Log.v(":::", activityManager.getRunningAppProcesses().get(0).processName);
            Log.v(":::", "Size of running app processes list = " + activityManager.getRunningAppProcesses().size());


        }, 8000);

        Handler handler = new Handler(Looper.getMainLooper());

        handler.post(() -> Log.v(":::", getMainLooper().toString()));

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
