package com.example.makemoneyfromcreditcard;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class Welcome extends AppCompatActivity {

    ImageView start,privacy;
    private  boolean key = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        start = (ImageView) findViewById(R.id.start);
        privacy = (ImageView) findViewById(R.id.privacy);





        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!key) {
                    key = true;

                    if(Splash_screen.str_extra.equals("1")){
                        Intent i = new Intent(Welcome.this, LanguageActivity.class);
                        startActivity(i);
                        key = false;
                    }else{
                        Intent main = new Intent(Welcome.this, MainActivity.class);
                        startActivity(main);
                        key = false;
                    }
                }
                Intent lang = new Intent(Welcome.this, LanguageActivity.class);
                startActivity(lang);
            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://freeprivacypolicyonline.com/Cubiova_Hub/privacy-policy.html"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you want to leave?")
                .setCancelable(false)
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Welcome.this.finishAffinity();
                    }
                })
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}