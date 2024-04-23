package com.example.wordleonthego;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
//import android.view.View;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

// Disables warning for button touch warning about accessibility since the app is purely visual
@SuppressLint("ClickableViewAccessibility")

public class MainActivity extends AppCompatActivity {
    Button start, rules, settings;
    Animation scaleUp, scaleDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scaleUp = AnimationUtils.loadAnimation(this, R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this, R.anim.scale_down);

        start = (Button)findViewById(R.id.play_button);
        start.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                start.startAnimation(scaleUp);
                start.startAnimation(scaleDown);
            }
            Intent menuPage = new Intent(MainActivity.this, Menu.class);
            startActivity(menuPage);
            return true;
        });

        rules = (Button)findViewById(R.id.rules_buttons);
        rules.setOnClickListener(v -> {
            Intent rulePage = RulePage.makeIntent(MainActivity.this);
            startActivity(rulePage);
        });

        settings = (Button)findViewById(R.id.setting_button);
        settings.setOnClickListener(v -> {
            Intent settingPage = Settings.makeIntent(MainActivity.this);
            startActivity(settingPage);
        });
    }
}