package com.example.m2_pc.picsediting;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView pics,editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linier);
        pics = (TextView)findViewById(R.id.pics);
        editing = (TextView)findViewById(R.id.editing);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        pics.startAnimation(animation);
        editing.startAnimation(animation);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font18.ttf");
        pics.setTypeface(typeface);

        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"font18.ttf");
        editing.setTypeface(typeface1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}
