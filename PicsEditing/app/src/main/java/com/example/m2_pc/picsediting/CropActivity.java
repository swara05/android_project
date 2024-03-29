package com.example.m2_pc.picsediting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

public class CropActivity extends AppCompatActivity {

    CropImageView crop;
    ImageView done,back2;
    public static Bitmap bitmap1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        back2 = (ImageView)findViewById(R.id.back2);
        done = (ImageView)findViewById(R.id.done_crop);
        crop = (CropImageView)findViewById(R.id.crop);
        crop.setImageBitmap(EditingActivity.finalEditedImage);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bitmap1 = crop.getCroppedImage();
                Intent intent=new Intent(CropActivity.this,FinalActivity.class);
                startActivity(intent);

            }
        });

    }
}
