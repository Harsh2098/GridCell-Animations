package com.lemnistech.customdistortion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        Circle circle = findViewById(R.id.circle);

        findViewById(R.id.animate_button).setOnClickListener((view -> {
            CircleAngleAnimation animation = new CircleAngleAnimation(circle, 360);
            animation.setDuration(1000);
            circle.startAnimation(animation);
        }));
    }
}
