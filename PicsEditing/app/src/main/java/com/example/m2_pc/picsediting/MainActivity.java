package com.example.m2_pc.picsediting;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST = 4;

    ImageView gallery,camera,image;
    public static Bitmap bitmap1;
    public static Uri imageurl;
    public static int a;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView)findViewById(R.id.image);
        camera =(ImageView)findViewById(R.id.camera);
        gallery = (ImageView)findViewById(R.id.gallery);

//        TODO Pemition Of Manifest

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE))
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }

        }

        else
        {
            // do nothing
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE))
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }

        }

        else
        {
            // do nothing
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED)
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CAMERA))
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},MY_PERMISSION_REQUEST);
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CAMERA},MY_PERMISSION_REQUEST);
            }

        }

        else
        {
            // do nothing
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.INTERNET)!= PackageManager.PERMISSION_GRANTED)
        {

            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.INTERNET))
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.INTERNET},MY_PERMISSION_REQUEST);
            }
            else
            {
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.INTERNET},MY_PERMISSION_REQUEST);
            }

        }

        else
        {
            // do nothing
        }

        Animation animation2 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.together);
        image.startAnimation(animation2);

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move_left);
        gallery.startAnimation(animation);

        Animation animation1 = AnimationUtils.loadAnimation(MainActivity.this,R.anim.move_right);
        camera.startAnimation(animation1);


        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent();
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(Intent.createChooser(intent,"complete Action Using.."),1);



            }
        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"complete Action Using.."),2);

            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK)
        {
            switch (requestCode) {

                case 1:
                    a=1;
                    bitmap1 = (Bitmap)data.getExtras().get("data");
                    Intent intent1 = new Intent(MainActivity.this,EditingActivity.class);
                    intent1.putExtra("img1",bitmap1);
                    startActivity(intent1);
//                    image.setImageBitmap(bitmap1);
                    break;

                case 2:
                    a=2;
                    imageurl = data.getData();
                    Intent intent2 = new Intent(MainActivity.this,EditingActivity.class);
                    intent2.putExtra("img2",imageurl);
                    startActivity(intent2);
//                    image.setImageURI(imageurl);
                    break;

            }

        }

    }
}
