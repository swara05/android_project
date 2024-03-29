package com.loca.retrofitapi2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private TextView image;
    private ImageView show;
    private String img,img1;
    private ImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView)findViewById(R.id.VideoView);

        img = "1617874686.mp4";
        //MediaController mediaController = new MediaController(this);
        // mediaController.setAnchorView(videoView);
        //videoView.setMediaController(mediaController);

        videoView.setVideoPath("http://icallscreen.in/wallpaper/public/images/video/"+img);

        videoView.start();



        img1 = "1616583388.gif";

        gif = findViewById(R.id.gif);

        /* from internet*/
        Glide.with(this)
                .load("http://icallscreen.in/wallpaper/public/images/gif/"+img1)
                .into(gif);








        image =  findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowSessionActivity.class);
                startActivity(intent);
            }
        });

    }
}