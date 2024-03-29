package com.example.mobilenumberlocator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AudioInfo extends AppCompatActivity {

    ImageView back;
    LinearLayout ring,noti,alarm;
    private String f6882g;
    private String f6883h;
    SharedPreferences.Editor f6878c;
    int f6879d;
    SharedPreferences f6880e;
    View f6886k;
    CheckBox vibrate;

        class C1892a implements CompoundButton.OnCheckedChangeListener {
            C1892a() {
            }

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AudioInfo.this.f6878c.putBoolean("vibrate_when_ringing", z);
                AudioInfo.this.f6878c.commit();
            }
        }

        class C1893b implements View.OnClickListener {
            C1893b() {
            }

            public void onClick(View view) {
                Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(AudioInfo.this, 1);
                Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                intent.putExtra("android.intent.extra.ringtone.TYPE", 1);
                intent.putExtra("android.intent.extra.ringtone.TITLE", "Select Ringtone");
                intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", actualDefaultRingtoneUri);
                intent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", true);
                intent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", false);
                AudioInfo.this.startActivityForResult(intent, 1001);
            }
        }

        class C1894c implements View.OnClickListener {
            C1894c() {
            }



            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                intent.putExtra("android.intent.extra.ringtone.TYPE", 2);
                intent.putExtra("android.intent.extra.ringtone.TITLE", "Select Notification Tone");
                intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", RingtoneManager.getActualDefaultRingtoneUri(AudioInfo.this, 2));
                AudioInfo.this.startActivityForResult(intent, 1002);
            }
        }

        class C1895d implements View.OnClickListener {
            C1895d() {
            }

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setClassName("com.android.settings", "com.android.settings.personalvibration.SelectPatternDialog");
                try {
                    AudioInfo.this.startActivity(intent);
                } catch (Exception unused) {
                }
            }
        }

        class C1896e implements View.OnClickListener {
            C1896e() {
            }

            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.RINGTONE_PICKER");
                intent.putExtra("android.intent.extra.ringtone.TYPE", 4);
                intent.putExtra("android.intent.extra.ringtone.TITLE", "Select Alarm Tone");
                intent.putExtra("android.intent.extra.ringtone.EXISTING_URI", RingtoneManager.getActualDefaultRingtoneUri(AudioInfo.this, 4));
                AudioInfo.this.startActivityForResult(intent, 1003);
            }
        }


        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            AudioInfo activity;
            int i3;
            Log.d("TRing", "result code " + i2 + "Activity.RESULT_OK" + -1 + " request code " + i);
            if (i2 == -1) {
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
                switch (i) {
                    case 1001:
                        activity = AudioInfo.this;
                        i3 = 1;
                        break;
                    case 1002:
                        activity = AudioInfo.this;
                        i3 = 2;
                        break;
                    case 1003:
                        activity = AudioInfo.this;
                        i3 = 4;
                        break;
                    default:
                        return;
                }
                RingtoneManager.setActualDefaultRingtoneUri(activity, i3, uri);
            }
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_audio_info);

            back = findViewById(R.id.back);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            ring = findViewById(R.id.ring);
            noti = findViewById(R.id.noti);
            alarm = findViewById(R.id.alarm);
            SharedPreferences sharedPreferences = getSharedPreferences("vibrate_when_ringing", 0);
            this.f6880e = sharedPreferences;
            this.f6878c = sharedPreferences.edit();
            vibrate = findViewById(R.id.vibrate);
            this.f6879d = Settings.System.getInt(getApplicationContext().getContentResolver(), "vibrate_when_ringing", 0);
            Log.d("Ringer", "sys vibrate value " + this.f6879d);
            int i = this.f6879d;
            if (i == 0) {
                this.vibrate.setChecked(false);
            } else if (i == 1) {
                this.vibrate.setChecked(true);
            }

            this.vibrate.setOnCheckedChangeListener(new C1892a());
            vibrate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        Toast.makeText(AudioInfo.this, "Switch to Silent Mode.Ringtones for all call and notification are Silent now.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AudioInfo.this, "Silent Mode is off now.Ringtones are restored to normal.", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            this.ring.setOnClickListener(new C1893b());
            this.noti.setOnClickListener(new C1894c());
            this.alarm.setOnClickListener(new C1896e());
        }

    }
