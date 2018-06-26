package com.lemnistech.customdistortion;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.vr.sdk.base.Distortion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, DistortionService.class));

        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();

        new Handler().postDelayed(() -> {
            for (StackTraceElement traceElement : stackTraceElement) {
                Log.v("$ LAWG_TAG $", traceElement.toString());//traceElement.getMethodName());
            }
        }, 2000);

        findViewById(R.id.progressBar_button).setOnClickListener((v) -> startActivity(new Intent(this, TimerActivity.class)));
    }
}
