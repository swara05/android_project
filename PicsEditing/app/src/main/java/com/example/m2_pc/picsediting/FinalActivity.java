package com.example.m2_pc.picsediting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.m2_pc.picsediting.EditingActivity.frameLayout;

public class FinalActivity extends AppCompatActivity {

    private ImageView done_image,download,share;
    TextView path;
    public static String _url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        share = (ImageView)findViewById(R.id.share);
        path = (TextView)findViewById(R.id.path);
        download = (ImageView)findViewById(R.id.download);
        done_image=(ImageView)findViewById(R.id.done_image);

        done_image.setImageBitmap(CropActivity.bitmap1);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                create_Save_Image();
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                File filepath = Environment.getExternalStorageDirectory();
//                String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//                String FileName = ts + ".jpg";
//                String _uri2 = filepath.getAbsolutePath() + "/" + "PicsEffect" + "/" + FileName;
//                _url = _uri2;//used in share image

                create_Save_Image();

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("image/*");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "PicsEditing" + getPackageName());
                shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(_url)));
                startActivity(Intent.createChooser(shareIntent, "Share Image using"));
            }
        });

    }

    public Bitmap finalEditedImage;
    private void create_Save_Image() {
        finalEditedImage = getMainFrameBitmap(done_image);
        saveImage(finalEditedImage);
    }

    private Bitmap getMainFrameBitmap(View view) {

        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        return bitmap;
    }

    private void saveImage(Bitmap bitmap2) {
        Log.e("TAG", "saveImageInCache is called");
        Bitmap bitmap;
        OutputStream output;

        // Retrieve the image from the res folder
        bitmap = bitmap2;

        File filepath = Environment.getExternalStorageDirectory();
        // Create a new folder in SD Card
        File dir = new File(filepath.getAbsolutePath() + "/" + "PicsEffect");
        dir.mkdirs();

        // Create a name for the saved image
        String ts = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String FileName = ts + ".jpg";
        File file = new File(dir, FileName);
        file.renameTo(file);
        String _uri = "file://" + filepath.getAbsolutePath() + "/" + "PicsEffect" + "/" + FileName;
        //for share image
        String _uri2 = filepath.getAbsolutePath() + "/" + "PicsEffect" + "/" + FileName;
        _url = _uri2;//used in share image
        Log.e("cache uri=", _uri);
        path.setText("Path :-"+"\t"+_url);
        Toast.makeText(this, "Image is Save JPEG", Toast.LENGTH_SHORT).show();
        MediaScannerConnection.scanFile(this, new String[]{_url}, null, new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
        });
        try {
            output = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
            output.flush();
            output.close();


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
